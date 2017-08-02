package hr.tvz.foodie.core.service.impl;

import hr.tvz.foodie.core.dao.RecipeDao;
import hr.tvz.foodie.core.model.Recipe;
import hr.tvz.foodie.core.model.User;
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
		Recipe recipe = recipeDao.findById(id);

		if (recipe.getImage() != null) {
			String base64Encoded = ImageUtil.getImageBase64(recipe.getImage());
			recipe.setImageBase64(base64Encoded);
		}

		return recipe;
	}

	@Override
	public Recipe saveOrUpdateRecipe(Recipe recipe) {
		return recipeDao.saveOrUpdate(recipe);
	}

	@Override
	public List<Recipe> getRecommendedRecipes(User user) {

		List<Recipe> recommendedRecipes = recipeDao.getRecommendedRecipes(user.getId());

		recommendedRecipes.forEach(recipe -> {
			if (recipe.getImage() == null) {
				return;
			}

			String base64Encoded = ImageUtil.getImageBase64(recipe.getImage());
			recipe.setImageBase64(base64Encoded);
		});

		return recommendedRecipes;
	}

	@Override
	public List<Recipe> getUserRecipes(User user) {
		List<Recipe> userRecipes = recipeDao.getUserRecipes(user);

		userRecipes.forEach(recipe -> {
			if (recipe.getImage() == null) {
				return;
			}

			String base64Encoded = ImageUtil.getImageBase64(recipe.getImage());
			recipe.setImageBase64(base64Encoded);
		});

		return userRecipes;
	}

	@Override
	public Recipe mergeRecipes(Recipe oldRecipe, Recipe newRecipe) {
		oldRecipe.setTitle(newRecipe.getTitle());
		oldRecipe.setDescription(newRecipe.getDescription());
		oldRecipe.setFoodType(newRecipe.getFoodType());
		oldRecipe.setMakingTime(newRecipe.getMakingTime());
		oldRecipe.setSkillLevel(newRecipe.getSkillLevel());
		oldRecipe.setIngredients(newRecipe.getIngredients());
		oldRecipe.setStages(newRecipe.getStages());

		if (newRecipe.getImage() != null) {
			oldRecipe.setImage(newRecipe.getImage());
		}

		return oldRecipe;
	}

}
