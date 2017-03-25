package hr.tvz.foodie.core.dao.hibernate;

import hr.tvz.foodie.core.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Antonio on 25.3.2017..
 */
public class BaseDaoHibernate<E, ID> implements BaseDao<E, ID> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<E> entityClass;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public BaseDaoHibernate() {
		// Dohvaća klasu preko generic tipa
		ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
		entityClass = (Class<E>) pt.getActualTypeArguments()[0];
	}
	@Override
	public E saveOrUpdate(E entity) {
		Object identifier = getCurrentSession().getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity);
		if (identifier == null) {
			getCurrentSession().persist(entity);
		}
		else {
			entity = (E)getCurrentSession().merge(entity);
		}
		return entity;
	}
	@Override
	public E findById(ID id) {
		return getCurrentSession().find(entityClass, id);
	}

	@Override
	public List<E> findAll() {
		String queryString = "select e from " + entityClass.getSimpleName() + " e";
		return getCurrentSession().createQuery(queryString, entityClass).getResultList();
	}

}
