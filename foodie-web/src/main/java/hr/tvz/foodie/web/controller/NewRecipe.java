package hr.tvz.foodie.web.controller;

import hr.tvz.foodie.core.model.FoodType;
import hr.tvz.foodie.core.model.Recipe;
import hr.tvz.foodie.core.model.User;
import hr.tvz.foodie.core.service.FoodieService;
import hr.tvz.foodie.core.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class NewRecipe {

	@Autowired
	private FoodieService foodieService;

	@Autowired
	private RecipeService recipeService;

	@RequestMapping(value = "newRecipe", method = RequestMethod.GET)
	public String newRecipe(Model model) {

		List<FoodType> foodTypes = foodieService.getAllFoodTypes();

		model.addAttribute("foodTypes", foodTypes);

		return "newRecipe";
	}

	@RequestMapping(value = "saveNewRecipe", method = RequestMethod.POST)
	public String saveRecipe(Model model, @Valid @ModelAttribute("recipe") Recipe recipe, BindingResult bindingResult,
							 @RequestParam("amount") List<String> amount, @RequestParam("file") MultipartFile file,
							 HttpServletRequest request) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("recipeHasErrors", true);

			return "newRecipe";
		}

		for (int i = 0; i < amount.size(); i++) {
			recipe.getIngredients().get(i).setAmount(Integer.parseInt(amount.get(i)));
		}

		FoodType foodType = foodieService.getFoodTypeById(recipe.getFoodType().getId());
		recipe.setFoodType(foodType);

		try {
			recipe.setImage(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		User user = (User) request.getSession().getAttribute("user");
		recipe.setUser(user);
		recipe.setReadCount(0);

		recipeService.saveOrUpdateRecipe(recipe);

		model.addAttribute("recipeAddedSuccessfully", true);
		model.addAttribute("recipeHasErrors", false);

		return "newRecipe";
	}

}
