package hr.tvz.foodie.core.service.impl;

import hr.tvz.foodie.core.dao.FoodTypeDao;
import hr.tvz.foodie.core.dao.UserDao;
import hr.tvz.foodie.core.model.FoodType;
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
	private FoodTypeDao foodTypeDao;

	@Autowired
	private UserDao userDao;

	@Override
	public List<FoodType> getAllFoodTypes() {
		return foodTypeDao.findAll();
	}

	@Override
	public FoodType getFoodTypeById(Long id) {
		return foodTypeDao.findById(id);
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
