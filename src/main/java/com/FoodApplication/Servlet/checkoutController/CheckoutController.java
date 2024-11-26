package com.FoodApplication.Servlet.checkoutController;

import com.myFoodApplication.cartItem.CartItem;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;

public class CheckoutController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");

        if (cart != null && !cart.isEmpty()) {
            double totalPrice = 0.0;
            int totalItems = 0;

            // Calculate total price and total items in the cart
            for (CartItem item : cart.values()) {
                totalPrice += item.getPrice() * item.getQuantity();
                totalItems += item.getQuantity();
            }

            // Set calculated values as session attributes
            session.setAttribute("totalPrice", totalPrice);
            session.setAttribute("totalItems", totalItems);

            // Redirect to the Payment Page
            response.sendRedirect("PaymentPage.jsp");
        } else {
            // If the cart is empty, redirect to the Cart Page
            response.sendRedirect("CartPage.jsp");
        }
    }
}
