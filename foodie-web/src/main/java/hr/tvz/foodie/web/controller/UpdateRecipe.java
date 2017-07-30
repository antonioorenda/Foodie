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

	@RequestMapping(value = "updateRecipe", method = RequestMethod.POST)
	public String updateRecipe(Model model, @ModelAttribute("recipe") Recipe recipe, @RequestParam("file")
			MultipartFile file) {

		FoodType foodType = foodieService.getFoodTypeById(recipe.getFoodType().getId());
		recipe.setFoodType(foodType);

		if (file != null) {
			try {
				recipe.setImage(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		recipeService.saveOrUpdateRecipe(recipe);

		model.addAttribute("recipeAddedSuccessfully", true);

		return "updateRecipe";
	}

}
