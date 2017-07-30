package hr.tvz.foodie.web.controller;

import hr.tvz.foodie.core.model.Recipe;
import hr.tvz.foodie.core.model.User;
import hr.tvz.foodie.core.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MyRecipes {

	@Autowired
	private RecipeService recipeService;

	@RequestMapping(value = "myRecipes", method = RequestMethod.GET)
	public String getMyRecipes(Model model, HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");

		if (user == null) {
			return "home";
		}

		List<Recipe> recipes = recipeService.getUserRecipes(user);

		model.addAttribute("recipesList", recipes);

		return "myRecipes";
	}

}