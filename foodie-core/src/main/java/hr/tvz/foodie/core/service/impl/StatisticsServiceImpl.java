package hr.tvz.foodie.core.service.impl;

import hr.tvz.foodie.core.dao.StatisticsDao;
import hr.tvz.foodie.core.model.Ingredient;
import hr.tvz.foodie.core.model.Recipe;
import hr.tvz.foodie.core.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	private StatisticsDao statisticsDao;

	@Override
	public Long getNumberOfRecipes() {
		return statisticsDao.getNumberOfRecipes();
	}

	@Override
	public Long getNumberOfUsers() {
		return statisticsDao.getNumberOfUsers();
	}

	@Override
	public List<Ingredient> getTopIngredients() {
		return statisticsDao.getTopIngredients();
	}

	@Override
	public List<Ingredient> getTopAllergens() {
		return statisticsDao.getTopAllergens();
	}

	@Override
	public List<Recipe> getTopRecipes() {
		return statisticsDao.getTopRecipes();
	}

}
