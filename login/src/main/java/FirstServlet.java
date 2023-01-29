

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter outPrintWriter = response.getWriter();
		
		String nString= request.getParameter("name");
		String pString = request.getParameter("pasword");
		if(loginDao.validate(nString,pString)) {
			RequestDispatcher rDispatcher = request.getRequestDispatcher("loginDao");
			rDispatcher.forward(request, response);
			
		}
		else {
			outPrintWriter.print("data dosent add successfully");
			RequestDispatcher rDispatcher = request.getRequestDispatcher("index.html");
			rDispatcher.include(request, response);
		}
		outPrintWriter.close();
	}

}
