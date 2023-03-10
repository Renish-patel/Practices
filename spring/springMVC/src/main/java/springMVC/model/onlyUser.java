package springMVC.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class onlyUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 private int id;	
 private String passwords;
 private String userName;
public String getPasswords() {
	return passwords;
}
public void setPasswords(String passwords) {
	this.passwords = passwords;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
@Override
public String toString() {
	return "onlyUser [id=" + id + ", passwords=" + passwords + ", userName=" + userName + "]";
}
 
 
}