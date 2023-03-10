package springMVC.Dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import springMVC.model.onlyUser;
@Repository
public class UserDao {
	@Autowired

	private HibernateTemplate hibernateTemplate;
	@Transactional
	public int save(onlyUser user) {	
		int id = (Integer) this.hibernateTemplate.save(user);

		return id;
	}
}
