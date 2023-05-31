package com.sathya.advjava.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sathya.advjavaproject.UserDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// getting client data
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				
				//Calling DAO Layer
				boolean result = UserDao.checkLogin(email,password);
				
				if(result==true) {
					RequestDispatcher dispatcher=request.getRequestDispatcher("loginsuccess.jsp");
				dispatcher.forward(request, response);
				}
				else {
					RequestDispatcher dispatcher=request.getRequestDispatcher("loginfail.jsp");
					dispatcher.forward(request, response);
				}
	}

}
