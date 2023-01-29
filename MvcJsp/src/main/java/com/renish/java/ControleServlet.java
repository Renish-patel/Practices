package com.renish.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ControleServlet")
public class ControleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public ControleServlet() {
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		LoginBean bean= new LoginBean();
		bean.setName(name);
		bean.setPassword(password);
		request.setAttribute("bean", bean);
		
		boolean status = bean.validate();
		
		if(status) {
			
			RequestDispatcher rsDispatcher = request.getRequestDispatcher("login_sucessfull.jsp");
			rsDispatcher.forward(request, response);
		}
		else {
			RequestDispatcher rsDispatcher = request.getRequestDispatcher("login_error.jsp");
			rsDispatcher.forward(request, response);
		}
		
	}
	 @Override  
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}
	 
	 
	
	}

