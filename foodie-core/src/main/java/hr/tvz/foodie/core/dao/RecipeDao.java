package hr.tvz.foodie.core.dao;

import hr.tvz.foodie.core.model.FoodType;
import hr.tvz.foodie.core.model.Recipe;
import hr.tvz.foodie.core.model.User;

import java.util.Date;
import java.util.List;

public interface RecipeDao extends BaseDao<Recipe, Long> {

	List<Recipe> getRecommendedRecipes(Long userId);

	List<Recipe> getUserRecipes(User user);

	List<Recipe> searchRecipes(String title, String skillLevel, FoodType foodType, Date dateFrom, Date dateTo);

}
