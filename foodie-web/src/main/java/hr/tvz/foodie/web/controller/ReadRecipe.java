package hr.tvz.foodie.web.controller;

import hr.tvz.foodie.core.model.Recipe;
import hr.tvz.foodie.core.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReadRecipe {

	@Autowired
	private RecipeService recipeService;

	@RequestMapping(value = "readRecipe/{id}", method = RequestMethod.GET)
	public String readRecipe(@PathVariable("id") Long id, Model model) {

		Recipe recipe = recipeService.getRecipeById(id);

		Integer readCount = recipe.getReadCount();
		readCount++;

		recipe.setReadCount(readCount);
		recipeService.saveOrUpdateRecipe(recipe);

		model.addAttribute("recipe", recipe);

		return "readRecipe";
	}

}
