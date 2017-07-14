package hr.tvz.foodie.core.service;

import hr.tvz.foodie.core.model.Recipe;

import java.util.List;

/**
 * Created by Antonio on 24.6.2017..
 */
public interface RecipeService {

	List<Recipe> findAllRecipes();

	Recipe getRecipeById(Long id);

	Recipe saveOrUpdateRecipe(Recipe recipe);

	List<Recipe> getUserRecipes(Long userId);

}