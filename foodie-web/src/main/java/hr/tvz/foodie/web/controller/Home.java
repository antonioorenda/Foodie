package hr.tvz.foodie.web.controller;

import hr.tvz.foodie.core.model.FoodType;
import hr.tvz.foodie.core.model.Recipe;
import hr.tvz.foodie.core.service.FoodieService;
import hr.tvz.foodie.core.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class Home {

	@Autowired
	private RecipeService recipeService;

	@Autowired
	private FoodieService foodieService;

	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String showHomePage(Model model) {
		List<Recipe> allRecipes = recipeService.findAllRecipes();
		List<FoodType> foodTypes = foodieService.getAllFoodTypes();

		model.addAttribute("foodTypes", foodTypes);
		model.addAttribute("recipes", allRecipes);

		return "home";
	}

}
