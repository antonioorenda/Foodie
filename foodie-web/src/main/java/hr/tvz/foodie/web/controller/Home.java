package hr.tvz.foodie.web.controller;

import hr.tvz.foodie.core.model.Recipe;
import hr.tvz.foodie.core.service.FoodieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Antonio on 22.3.2017..
 */
@Controller
public class Home {

	@Autowired
	private FoodieService foodieService;

	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String printHello(Model model) {

		List<Recipe> allRecipes = foodieService.findAllRecipes();

		model.addAttribute("allRecipes", allRecipes);

		return "home";
	}

}
