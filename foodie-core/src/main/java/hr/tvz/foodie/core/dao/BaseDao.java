package hr.tvz.foodie.core.dao;

import java.util.List;

public interface BaseDao<E, ID> {

	E saveOrUpdate(E entity);

	E findById(ID id);

	List<E> findAll();

}
