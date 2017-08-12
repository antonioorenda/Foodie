package hr.tvz.foodie.core.service;

import hr.tvz.foodie.core.model.FoodType;
import hr.tvz.foodie.core.model.User;

import java.util.List;

public interface FoodieService {

	List<FoodType> getAllFoodTypes();

	FoodType getFoodTypeById(Long id);

	User saveOrUpdateUser(User user);

	User fetchUserByUsernameAndPassword(User user);

	User fetchUserByUsername(User user);

}
