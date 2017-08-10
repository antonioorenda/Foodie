package hr.tvz.foodie.core.dao.hibernate;

import hr.tvz.foodie.core.dao.UserDao;
import hr.tvz.foodie.core.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Repository
public class UserDaoHibernate extends BaseDaoHibernate<User, Long> implements UserDao {

	@Override
	public User findByUsernameAndPassword(User user) {
		User foundUser;

		try {
			TypedQuery<User> query = getCurrentSession().createQuery("SELECT u FROM User u WHERE u.password = :u_password and u.username = :u_username", User.class);
			query.setParameter("u_password", user.getPassword());
			query.setParameter("u_username", user.getUsername());

			foundUser = query.getSingleResult();
		} catch (NoResultException e) {
			foundUser = null;
		}

		return foundUser;
	}

	@Override
	public User findByUsername(User user) {
		User foundUser;

		try {
			TypedQuery<User> query = getCurrentSession().createQuery("SELECT u FROM User u WHERE u.username = :u_username", User.class);
			query.setParameter("u_username", user.getUsername());

			foundUser = query.getSingleResult();
		} catch (NoResultException e) {
			foundUser = null;
		}

		return foundUser;
	}

}
