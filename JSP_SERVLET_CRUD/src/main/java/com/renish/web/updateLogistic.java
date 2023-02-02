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
import javax.xml.crypto.Data;

@WebServlet("/updateLogistic")
public class updateLogistic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private UserDao userDao;

	public void init() {
		userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messages", messages);

		response.setContentType("text/html");
		PrintWriter pWriter = response.getWriter();

		String itemNumber = request.getParameter("itemNo");
		String itemName = request.getParameter("itemName");
		String Date = request.getParameter("date");
		String category = request.getParameter("category");

		
		System.out.println(itemName);
		System.out.println(itemNumber);
		System.out.println(Date);
		System.out.println(category);
		
			int id = Integer.parseInt(request.getParameter("id"));

			User user = new  User(id,itemNumber, itemName,Date, category);
			UserDao.updateItemdata(user);
			response.sendRedirect("index.jsp");

		
			if (messages.size() != 0) {
				pWriter.println(messages);
				request.getRequestDispatcher("edit-form.jsp").forward(request, response);
			}
			pWriter.close();
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}