

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String nString = request.getParameter("name");
		String pString = request.getParameter("password");
		String eString = request.getParameter("email");
		String cString = request.getParameter("country");
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/registeruser","root","root");
		PreparedStatement ps= con.prepareStatement("insert into username values(?,?,?,?)");
		ps.setString(1, nString);
		ps.setString(2, pString);
		ps.setString(3, eString);
		ps.setString(4, cString);
		
		int i = ps.executeUpdate();
		if(i>0) {
			out.print("you are sucessfully registerd");
		}
	} catch (Exception e) {
			
		System.out.println(e);
	}	
	out.close();
	}
}
