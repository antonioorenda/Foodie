package hr.tvz.foodie.core.dao.hibernate;

import hr.tvz.foodie.core.dao.BaseDao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDaoHibernate<E, ID> extends DaoHibernate implements BaseDao<E, ID> {

	private Class<E> entityClass;

	public BaseDaoHibernate() {
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
