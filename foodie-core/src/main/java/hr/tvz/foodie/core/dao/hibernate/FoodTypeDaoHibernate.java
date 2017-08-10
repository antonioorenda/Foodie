package hr.tvz.foodie.core.dao.hibernate;

import hr.tvz.foodie.core.dao.FoodTypeDao;
import hr.tvz.foodie.core.model.FoodType;
import org.springframework.stereotype.Repository;

@Repository
public class FoodTypeDaoHibernate extends BaseDaoHibernate<FoodType, Long> implements FoodTypeDao {}
