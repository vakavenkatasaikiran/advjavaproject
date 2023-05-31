package com.sathya.advjava.reset;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sathya.advjavaproject.UserDao;

@WebServlet("/ResetServlet")
public class ResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ResetServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getting client data
				String email=	request.getParameter("email");
				String newPassword=	request.getParameter("newpassword");
				String confPassword=	request.getParameter("confpassword");
				
				if(newPassword.equals(confPassword)) {
					
				int res =	UserDao.passwordreset(email, confPassword);
				
				if(res>1) {
					RequestDispatcher dispatcher=request.getRequestDispatcher("resetsuccess.jsp");
					dispatcher.forward(request, response);
				}
				else {
					RequestDispatcher dispatcher=request.getRequestDispatcher("resetfail.jsp");
					dispatcher.forward(request, response);
				}
				}
				else {
					RequestDispatcher dispatcher=request.getRequestDispatcher("resetfail.jsp");
					dispatcher.forward(request, response);
				}	
	}

}
