package com.FoodApplication.Servlet.Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myFoodApplication.userDAOImpl.UserDAOImpl;
import com.myFoodApplication.user.User;

public class Login extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserDAOImpl udaoi = new UserDAOImpl();
		User u = udaoi.fetchSpecific(email);
		
        if(u!=null) {
			
			if(u.getPassword().equals(password)) {
				
				HttpSession session = req.getSession();
				session.setAttribute("loggedInUser", u);
				
                //resp.sendRedirect("Home.jsp");
				resp.sendRedirect("getrestaurant");

			}
			else
			{
				//wrong password
				resp.sendRedirect("PwdIncorrect.jsp");
			}
		}
		else
		{
			//no such user
			resp.sendRedirect("InvalidUser.jsp");
		}
		
	}
}
