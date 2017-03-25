package hr.tvz.foodie.core.dao;

import java.util.List;

/**
 * Created by Antonio on 25.3.2017..
 */
public interface BaseDao<E, ID> {

	E saveOrUpdate(E entity);

	E findById(ID id);

	List<E> findAll();

}
