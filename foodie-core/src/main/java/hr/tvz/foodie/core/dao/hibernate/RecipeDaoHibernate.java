package hr.tvz.foodie.core.dao.hibernate;

import hr.tvz.foodie.core.dao.RecipeDao;
import hr.tvz.foodie.core.model.Recipe;
import org.springframework.stereotype.Repository;

/**
 * Created by Antonio on 25.3.2017..
 */
@Repository
public class RecipeDaoHibernate extends  BaseDaoHibernate<Recipe, Long> implements RecipeDao {
}
