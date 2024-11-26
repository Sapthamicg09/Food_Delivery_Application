package com.FoodApplication.Servlet.deleteCartItemController;

import com.myFoodApplication.cartItem.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;


public class DeleteCartItemController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the session
        HttpSession session = request.getSession();

        // Get the cart from the session
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");

        if (cart != null) {
            // Retrieve the itemId to delete
            int itemId = Integer.parseInt(request.getParameter("itemId"));

            // Remove the item from the cart
            cart.remove(itemId);

            // Save the updated cart back to the session
            session.setAttribute("cart", cart);
        }

        // Redirect back to the cart page
        response.sendRedirect("Cart.jsp");
    }
}
