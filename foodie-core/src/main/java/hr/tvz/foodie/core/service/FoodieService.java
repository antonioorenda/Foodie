package hr.tvz.foodie.core.service;

import hr.tvz.foodie.core.model.Recipe;

import java.util.List;

/**
 * Created by Antonio on 25.3.2017..
 */
public interface FoodieService {

	List<Recipe> findAllRecipes();

}
