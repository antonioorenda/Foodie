package hr.tvz.foodie.core.dao.hibernate;

import hr.tvz.foodie.core.dao.StatisticsDao;
import hr.tvz.foodie.core.model.Ingredient;
import hr.tvz.foodie.core.model.Recipe;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class StatisticsDaoHibernate extends DaoHibernate implements StatisticsDao {

	@Override
	public Long getNumberOfRecipes() {
		Long count = getCurrentSession().createQuery("select count(*) from Recipe", Long.class)
				.getSingleResult();

		return count;
	}

	@Override
	public Long getNumberOfUsers() {
		Long numberOfUsers = getCurrentSession().createQuery("select count(*) from User", Long.class)
				.getSingleResult();

		return numberOfUsers;
	}

	@Override
	public List<Ingredient> getTopIngredients() {
		Query query = getCurrentSession().createNativeQuery("EXEC dbo.getTopIngredients").addScalar("Naziv", StringType.INSTANCE);

		List<Ingredient> ingredients = query.getResultList();

		return ingredients;
	}

	@Override
	public List<Ingredient> getTopAllergens() {
		Query query = getCurrentSession().createNativeQuery("EXEC dbo.getTopAllergens").addScalar("Naziv", StringType.INSTANCE);;

		List<Ingredient> allergens = query.getResultList();

		return allergens;
	}

	@Override
	public List<Recipe> getTopRecipes() {
		Query query = getCurrentSession().createNativeQuery("EXEC dbo.getTopRecipes").addEntity(Recipe.class);

		List<Recipe> recipes = query.getResultList();

		return recipes;
	}

}
