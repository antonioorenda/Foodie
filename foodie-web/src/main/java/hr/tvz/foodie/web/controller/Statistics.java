package hr.tvz.foodie.web.controller;

import hr.tvz.foodie.core.model.Ingredient;
import hr.tvz.foodie.core.model.Recipe;
import hr.tvz.foodie.core.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class Statistics {

	@Autowired
	private StatisticsService statisticsService;

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "statistics", method = RequestMethod.GET)
	public String statistics(Model model, HttpServletRequest request) {

		boolean userIsAdministrator = (boolean) request.getSession().getAttribute("adminUser");

		if (userIsAdministrator) {
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
			
			return "statistics";
		}

		return "home";
	}

}
