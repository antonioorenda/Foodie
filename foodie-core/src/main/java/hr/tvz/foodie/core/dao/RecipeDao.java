package hr.tvz.foodie.core.dao;

import hr.tvz.foodie.core.model.Recipe;

import java.util.List;

public interface RecipeDao extends  BaseDao<Recipe, Long>{

	List<Recipe> getUserRecipes(Long userId);

}
