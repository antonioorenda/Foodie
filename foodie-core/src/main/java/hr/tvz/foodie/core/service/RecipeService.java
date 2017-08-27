package hr.tvz.foodie.core.service;

import hr.tvz.foodie.core.model.FoodType;
import hr.tvz.foodie.core.model.Recipe;
import hr.tvz.foodie.core.model.User;

import java.util.List;

public interface RecipeService {

	List<Recipe> findAllRecipes();

	Recipe getRecipeById(Long id);

	Recipe saveOrUpdateRecipe(Recipe recipe);

	List<Recipe> getRecommendedRecipes(User user);

	List<Recipe> getUserRecipes(User user);

	Recipe mergeRecipes(Recipe oldRecipe, Recipe newRecipe);

	List<Recipe> searchRecipes(String title, String skillLevel, FoodType foodType);

}
