package hr.tvz.foodie.core.dao;

import hr.tvz.foodie.core.model.User;

public interface UserDao extends  BaseDao<User, Long> {

	User findByUsernameAndPassword(User user);

	User findByUsername(User user);

}
