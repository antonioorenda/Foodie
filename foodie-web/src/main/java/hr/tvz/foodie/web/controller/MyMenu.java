package hr.tvz.foodie.web.controller;

import hr.tvz.foodie.core.model.FoodType;
import hr.tvz.foodie.core.model.Recipe;
import hr.tvz.foodie.core.model.User;
import hr.tvz.foodie.core.service.FoodieService;
import hr.tvz.foodie.core.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MyMenu {

	@Autowired
	private RecipeService recipeService;

	@Autowired
	private FoodieService foodieService;

	@RequestMapping(value = "myMenu", method = RequestMethod.GET)
	public String showMyMenu(Model model, HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");

		if (user == null) {
			return "home";
		}

		List<Recipe> recipes = recipeService.getRecommendedRecipes(user);
		List<FoodType> foodTypes = foodieService.getAllFoodTypes();

		model.addAttribute("foodTypes", foodTypes);
		model.addAttribute("recipes", recipes);

		return "myMenu";
	}

}