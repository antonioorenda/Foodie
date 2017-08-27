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
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("allRecipes", allRecipes);

		return "home";
	}

	@RequestMapping(value = "/home/search", method = RequestMethod.GET)
	public String searchRecipes(Model model, @RequestParam(name = "title", required = false) String title,
								@RequestParam(name = "skillLevel", required = false) String skillLevel,
								@RequestParam(name = "foodType", required = false) FoodType foodType) {

		if (title.equals("") && skillLevel == null && foodType == null) {
			showHomePage(model);
		}

		List<Recipe> searchRecipes = recipeService.searchRecipes(title, skillLevel, foodType);
		List<FoodType> foodTypes = foodieService.getAllFoodTypes();

		model.addAttribute("foodTypes", foodTypes);
		model.addAttribute("allRecipes", searchRecipes);

		return "home";
	}

}
