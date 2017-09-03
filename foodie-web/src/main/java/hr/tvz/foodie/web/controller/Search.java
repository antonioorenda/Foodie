package hr.tvz.foodie.web.controller;

import hr.tvz.foodie.core.model.FoodType;
import hr.tvz.foodie.core.model.Ingredient;
import hr.tvz.foodie.core.model.Recipe;
import hr.tvz.foodie.core.service.FoodieService;
import hr.tvz.foodie.core.service.RecipeService;
import hr.tvz.foodie.core.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

import static hr.tvz.foodie.web.controller.Registration.getPage;

@Controller
public class Search {

	@Autowired
	private RecipeService recipeService;

	@Autowired
	private FoodieService foodieService;

	@Autowired
	private StatisticsService statisticsService;

	private String referrer;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchRecipes(Model model, HttpServletRequest request,
								@RequestParam(name = "title", required = false) String title,
								@RequestParam(name = "skillLevel", required = false) String skillLevel,
								@RequestParam(name = "foodType", required = false) FoodType foodType,
								@DateTimeFormat(pattern = "dd.MM.yyyy") Date dateFrom,
								@DateTimeFormat(pattern = "dd.MM.yyyy") Date dateTo) {

		String referrer = getPage(request);

		if (!referrer.contains("search")) {
			this.referrer = referrer;
		}

		if (title.equals("") && skillLevel == null && foodType == null && dateFrom == null && dateTo == null) {
			String redirectPage = this.referrer != null ? this.referrer : referrer;
			return "redirect: " + redirectPage;
		}

		if (this.referrer.equals("statistics")) {
			Long numberOfRecipes = statisticsService.getNumberOfRecipes();
			model.addAttribute("numberOfRecipes", numberOfRecipes);

			Long numberOfUsers = statisticsService.getNumberOfUsers();
			model.addAttribute("numberOfUsers", numberOfUsers);

			List<Ingredient> topIngredients = statisticsService.getTopIngredients();
			model.addAttribute("topIngredients", topIngredients.toString().substring(1, topIngredients.toString().length() - 1));

			List<Ingredient> allergenList = statisticsService.getTopAllergens();
			model.addAttribute("topAllergens", allergenList.toString().substring(1, allergenList.toString().length() - 1));

			List<Recipe> topRecipes = statisticsService.getTopRecipes();
			model.addAttribute("topRecipes", topRecipes);

			model.addAttribute("foodTypes", foodieService.getAllFoodTypes());
		}

		List<Recipe> searchRecipes = recipeService.searchRecipes(title, skillLevel, foodType, dateFrom, dateTo);
		List<FoodType> foodTypes = foodieService.getAllFoodTypes();

		model.addAttribute("foodTypes", foodTypes);
		model.addAttribute("recipes", searchRecipes);

		return this.referrer;
	}

}
