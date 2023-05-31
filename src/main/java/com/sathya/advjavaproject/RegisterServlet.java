package com.sathya.advjavaproject;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		String[] qualification = request.getParameterValues("qualification");
		String gender = request.getParameter("gender");
		
		String[] technologies = request.getParameterValues("technologies");
		String[] address = request.getParameterValues("address");
		String comments = request.getParameter("comments");
		
		String finalqual =  String.join(",", qualification);
		String finaltech = String.join(",", technologies);
		String finaladdr = String.join(",", address);
		
		UserData user = new UserData(username, password, email, country, finalqual, gender, finaltech, finaladdr, comments);
		int res = UserDao.saveData(user);
		if(res==1)
		{	RequestDispatcher dispatcher = request.getRequestDispatcher("regsuccess.jsp");
			dispatcher.forward(request, response);
		}
		else
		{	RequestDispatcher dispatcher = request.getRequestDispatcher("regfail.jsp");
			dispatcher.forward(request, response);
		}
	}
}

