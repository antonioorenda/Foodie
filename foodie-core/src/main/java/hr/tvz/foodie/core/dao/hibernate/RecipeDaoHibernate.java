package hr.tvz.foodie.core.dao.hibernate;

import hr.tvz.foodie.core.dao.RecipeDao;
import hr.tvz.foodie.core.model.FoodType;
import hr.tvz.foodie.core.model.Recipe;
import hr.tvz.foodie.core.model.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RecipeDaoHibernate extends BaseDaoHibernate<Recipe, Long> implements RecipeDao {

	@Override
	public List<Recipe> getRecommendedRecipes(Long userId) {
		Query query = getCurrentSession().createNativeQuery("EXEC dbo.getUserRecipes :userId").addEntity(Recipe.class)
				.setParameter("userId", userId);

		List<Recipe> recipes = query.list();

		return recipes.stream().distinct().collect(Collectors.toList());
	}

	@Override
	public List<Recipe> getUserRecipes(User user) {
		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();

		CriteriaQuery<Recipe> criteria = builder.createQuery(Recipe.class);
		Root<Recipe> root = criteria.from(Recipe.class);
		criteria.select(root);
		criteria.where(builder.equal(root.get("user"), user));

		List<Recipe> recipes = getCurrentSession().createQuery(criteria).getResultList();

		return recipes;
	}

	@Override
	public List<Recipe> searchRecipes(String title, String skillLevel, FoodType foodType, Date dateFrom, Date dateTo) {
		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();

		CriteriaQuery<Recipe> criteria = builder.createQuery(Recipe.class);
		Root<Recipe> root = criteria.from(Recipe.class);
		criteria.select(root);

		if (!title.equals("")) {
			criteria.where(builder.like(root.get("title"), "%" + title + "%"));
		}

		if (skillLevel != null) {
			criteria.where(builder.equal(root.get("skillLevel"), skillLevel));
		}

		if (foodType != null) {
			criteria.where(builder.equal(root.get("foodType"), foodType));
		}

		if (dateFrom != null) {
			criteria.where(builder.greaterThanOrEqualTo(root.get("uploadDate"), dateFrom));
		}

		if (dateTo != null) {
			criteria.where(builder.lessThanOrEqualTo(root.get("uploadDate"), dateTo));
		}

		List<Recipe> recipes = getCurrentSession().createQuery(criteria).getResultList();

		return recipes;
	}

}
