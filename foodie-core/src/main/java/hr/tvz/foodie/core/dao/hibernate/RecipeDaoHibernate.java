package hr.tvz.foodie.core.dao.hibernate;

import hr.tvz.foodie.core.dao.RecipeDao;
import hr.tvz.foodie.core.model.Recipe;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RecipeDaoHibernate extends  BaseDaoHibernate<Recipe, Long> implements RecipeDao {

	@Override
	public List<Recipe> getUserRecipes(Long userId) {
		Query query = getCurrentSession().createNativeQuery("EXEC dbo.getUserRecipes :userId").addEntity(Recipe.class)
				.setParameter("userId", userId);

		List<Recipe> recipes = query.list();

		return recipes.stream().distinct().collect(Collectors.toList());
	}

}
