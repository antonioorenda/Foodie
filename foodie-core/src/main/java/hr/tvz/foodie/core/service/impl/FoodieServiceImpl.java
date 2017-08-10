package hr.tvz.foodie.core.service.impl;

import hr.tvz.foodie.core.dao.FoodTypeDao;
import hr.tvz.foodie.core.dao.IngredientDao;
import hr.tvz.foodie.core.dao.StageDao;
import hr.tvz.foodie.core.dao.UserDao;
import hr.tvz.foodie.core.model.FoodType;
import hr.tvz.foodie.core.model.Ingredient;
import hr.tvz.foodie.core.model.Stage;
import hr.tvz.foodie.core.model.User;
import hr.tvz.foodie.core.service.FoodieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FoodieServiceImpl implements FoodieService {

	@Autowired
	private IngredientDao ingredientDao;

	@Autowired
	private FoodTypeDao foodTypeDao;

	@Autowired
	private StageDao stageDao;

	@Autowired
	private UserDao userDao;

	@Override
	public List<Ingredient> getAllIngredients() {
		return ingredientDao.findAll();
	}

	@Override
	public List<FoodType> getAllFoodTypes() {
		return foodTypeDao.findAll();
	}

	@Override
	public FoodType getFoodTypeById(Long id) {
		return foodTypeDao.findById(id);
	}

	@Override
	public List<Stage> getAllStages() {
		return stageDao.findAll();
	}

	@Override
	public User saveOrUpdateUser(User user) {
		return userDao.saveOrUpdate(user);
	}

	@Override
	public User fetchUserByUsernameAndPassword(User user) {
		return userDao.findByUsernameAndPassword(user);
	}

	@Override
	public User fetchUserByUsername(User user) {
		return userDao.findByUsername(user);
	}

}
