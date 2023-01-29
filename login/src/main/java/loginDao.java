import java.sql.*;  
  
public class loginDao {  
public static boolean validate(String name,String password){  
boolean status=false;
try {
	Class.forName("com.mysql.jdbc.Drive");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");
	
	PreparedStatement pStatement =connection.prepareStatement("select * from log where name=? and password=?");
	
	pStatement.setString(1, name);
	pStatement.setString(2, password);
	
	ResultSet rSet = pStatement.executeQuery();
	status=rSet.next();
	
	
} catch (Exception e) {System.out.println(e);}
return status;
}
}