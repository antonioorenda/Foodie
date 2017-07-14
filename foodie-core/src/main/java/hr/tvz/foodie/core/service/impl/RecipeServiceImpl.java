package hr.tvz.foodie.core.service.impl;

import hr.tvz.foodie.core.dao.RecipeDao;
import hr.tvz.foodie.core.model.Recipe;
import hr.tvz.foodie.core.service.RecipeService;
import hr.tvz.foodie.core.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeDao recipeDao;

	@Override
	public List<Recipe> findAllRecipes() {

		List<Recipe> allRecipes = recipeDao.findAll();

		allRecipes.forEach(recipe -> {
			if (recipe.getImage() == null) {
				return;
			}

			String base64Encoded = ImageUtil.getImageBase64(recipe.getImage());
			recipe.setImageBase64(base64Encoded);
		});

		return allRecipes;
	}

	@Override
	public Recipe getRecipeById(Long id) {
		return recipeDao.findById(id);
	}

	@Override
	public Recipe saveOrUpdateRecipe(Recipe recipe) {
		return recipeDao.saveOrUpdate(recipe);
	}

	@Override
	public List<Recipe> getUserRecipes(Long userId) {

		List<Recipe> userRecipes = recipeDao.getUserRecipes(userId);

		userRecipes.forEach(recipe -> {
			if (recipe.getImage() == null) {
				return;
			}

			String base64Encoded = ImageUtil.getImageBase64(recipe.getImage());
			recipe.setImageBase64(base64Encoded);
		});

		return userRecipes;
	}

}
