package hr.tvz.foodie.web.controller;

import hr.tvz.foodie.core.model.FoodType;
import hr.tvz.foodie.core.model.Recipe;
import hr.tvz.foodie.core.service.FoodieService;
import hr.tvz.foodie.core.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class UpdateRecipe {

	@Autowired
	private FoodieService foodieService;

	@Autowired
	private RecipeService recipeService;

	@RequestMapping(value = "updateRecipe/{id}", method = RequestMethod.GET)
	public String showRecipe(@PathVariable("id") Long id, Model model) {

		Recipe recipe = recipeService.getRecipeById(id);
		List<FoodType> foodTypes = foodieService.getAllFoodTypes();

		model.addAttribute("foodTypes", foodTypes);
		model.addAttribute("recipe", recipe);

		return "updateRecipe";
	}

	@RequestMapping(value = "updateRecipe/{id}", method = RequestMethod.POST)
	public String updateRecipe(@PathVariable("id") Long id, Model model, @ModelAttribute("recipe") Recipe
			updatedRecipe, @RequestParam("file") MultipartFile file) {

		Recipe oldRecipe = recipeService.getRecipeById(id);

		FoodType foodType = foodieService.getFoodTypeById(updatedRecipe.getFoodType().getId());
		updatedRecipe.setFoodType(foodType);

		if (!file.isEmpty()) {
			try {
				updatedRecipe.setImage(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		updatedRecipe = recipeService.mergeRecipes(oldRecipe, updatedRecipe);
		recipeService.saveOrUpdateRecipe(updatedRecipe);

		model.addAttribute("recipeUpdatedSuccessfully", true);

		return "updateRecipe";
	}

}
