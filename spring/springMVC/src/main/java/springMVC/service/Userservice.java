package springMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springMVC.Dao.UserDao;
import springMVC.model.onlyUser;
@Service
public class Userservice {
	@Autowired
	private UserDao userDao;
 public int createUser( onlyUser user) {
	return this.userDao.save(user);
}
}
