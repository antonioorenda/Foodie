package hr.tvz.foodie.core.dao.hibernate;

import hr.tvz.foodie.core.dao.IngredientDao;
import hr.tvz.foodie.core.model.Ingredient;
import org.springframework.stereotype.Repository;

@Repository
public class IngredientDaoHibernate extends  BaseDaoHibernate<Ingredient, Long> implements IngredientDao {
}
