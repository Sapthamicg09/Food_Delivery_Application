package com.FoodApplication.Servlet.updateCartItemController;

import com.myFoodApplication.cartDAOImpl.CartDAOImpl;
import com.myFoodApplication.cartItem.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;



public class UpdateCartItemController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        CartDAOImpl cartDAO = new CartDAOImpl();

        if (cart != null) {
            // Retrieve itemId and new quantity from the request
            int itemId = Integer.parseInt(request.getParameter("itemId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            // Update the cart item quantity
            if (cart.containsKey(itemId)) {
                if (quantity <= 0) {
                    cart.remove(itemId); // Remove item if quantity is 0 or less
                } else {
                    cart.get(itemId).setQuantity(quantity); // Update quantity
                }
            }

            // Update the DAO if needed
            cartDAO.updateItem(itemId, quantity);

            // Save the updated cart back to the session
            session.setAttribute("cart", cart);
        }

        // Redirect back to the cart page
        response.sendRedirect("Cart.jsp");
    }
}