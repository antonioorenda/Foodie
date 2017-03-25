package hr.tvz.foodie.core.service.impl;

import hr.tvz.foodie.core.dao.RecipeDao;
import hr.tvz.foodie.core.model.Recipe;
import hr.tvz.foodie.core.service.FoodieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Antonio on 25.3.2017..
 */
@Service
@Transactional
public class FoodieServiceImpl implements FoodieService {

	@Autowired
	private RecipeDao recipeDao;

	@Override
	public List<Recipe> findAllRecipes() {

		return recipeDao.findAll();
	}

}
