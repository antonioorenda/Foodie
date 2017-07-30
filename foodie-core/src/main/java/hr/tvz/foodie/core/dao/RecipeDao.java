package hr.tvz.foodie.core.dao;

import hr.tvz.foodie.core.model.Recipe;
import hr.tvz.foodie.core.model.User;

import java.util.List;

public interface RecipeDao extends  BaseDao<Recipe, Long>{

	List<Recipe> getRecommendedRecipes(Long userId);

	List<Recipe> getUserRecipes(User user);

}
