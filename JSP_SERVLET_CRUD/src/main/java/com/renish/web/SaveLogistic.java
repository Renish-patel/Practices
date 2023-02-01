package com.renish.web;

import com.renish.bean.*;
import com.renish.dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveLogistic")
public class SaveLogistic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private UserDao userDao;

	public void init() {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messages", messages);

		response.setContentType("text/html");
		PrintWriter pWriter = response.getWriter();

		String itemNumber = request.getParameter("itemNo").trim();
		String itemName = request.getParameter("itemName").trim();
		String Date = request.getParameter("date").trim();
		String category = request.getParameter("category").trim();

		
			User user = new User(itemNumber, itemName, Date, category);
			user.setItemNo(itemNumber);
			user.setItemName(itemName);
			user.setDate(Date);
			user.setCategory(category);

			int status = UserDao.saveItemdata(user);
			if (status > 0) {
				pWriter.print("<b>Successfully Added</b>");
				response.sendRedirect("index-form.jsp");
			} else {
				pWriter.print("<b>Enter Another ItemNo.</b>");
			}

		
		pWriter.close();
	}
}