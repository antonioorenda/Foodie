package hr.tvz.foodie.core.dao.hibernate;

import hr.tvz.foodie.core.dao.UserDao;
import hr.tvz.foodie.core.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoHibernate extends BaseDaoHibernate<User, Long> implements UserDao {
}
