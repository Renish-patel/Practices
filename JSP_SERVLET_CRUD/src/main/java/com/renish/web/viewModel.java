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

import org.json.JSONObject;

@WebServlet("/viewModel")
public class viewModel extends HttpServlet {
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

		int id = Integer.parseInt(request.getParameter("id"));
		User user = UserDao.getLogisticRecord(id);

		String itemNumber = user.getItemNo();
		String itemName = user.getItemName();
		String Date = user.getDate();
		String category = user.getCategory();

		messages.put("itemNumber", itemNumber);
		messages.put("itemName", itemName);
		messages.put("date", Date);
		messages.put("category", category);

		response.setContentType("application/json");
		response.getWriter().write((new JSONObject(messages)).toString());
		pWriter.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

//8005-8080