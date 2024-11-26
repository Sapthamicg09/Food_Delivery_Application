package com.FoodApplication.Servlet.clearCartController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class ClearCartController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the session
        HttpSession session = request.getSession();

        // Clear the cart from the session
        session.removeAttribute("cart");

        // Redirect back to the cart page
        response.sendRedirect("Cart.jsp");
    }
}
