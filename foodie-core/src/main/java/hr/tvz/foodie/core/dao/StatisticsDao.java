package hr.tvz.foodie.core.dao;

import hr.tvz.foodie.core.model.Ingredient;
import hr.tvz.foodie.core.model.Recipe;

import java.util.List;

public interface StatisticsDao {

	Long getNumberOfRecipes();

	Long getNumberOfUsers();

	List<Ingredient> getTopIngredients();

	List<Ingredient> getTopAllergens();

	List<Recipe> getTopRecipes();

}
