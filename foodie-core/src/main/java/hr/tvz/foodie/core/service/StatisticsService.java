package hr.tvz.foodie.core.service;

import hr.tvz.foodie.core.model.Ingredient;
import hr.tvz.foodie.core.model.Recipe;

import java.util.List;

public interface StatisticsService {

	Long getNumberOfRecipes();

	Long getNumberOfUsers();

	List<Ingredient> getTopIngredients();

	List<Ingredient> getTopAllergens();

	List<Recipe> getTopRecipes();

}
