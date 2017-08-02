package hr.tvz.foodie.core.service;

import hr.tvz.foodie.core.model.Recipe;
import hr.tvz.foodie.core.model.User;

import java.util.List;

/**
 * Created by Antonio on 24.6.2017..
 */
public interface RecipeService {

	List<Recipe> findAllRecipes();

	Recipe getRecipeById(Long id);

	Recipe saveOrUpdateRecipe(Recipe recipe);

	List<Recipe> getRecommendedRecipes(User user);

	List<Recipe> getUserRecipes(User user);

	Recipe mergeRecipes(Recipe oldRecipe, Recipe newRecipe);

}
