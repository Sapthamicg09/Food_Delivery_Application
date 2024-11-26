package com.FoodApplication.Servlet.cartController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myFoodApplication.cartItem.CartItem;
import com.myFoodApplication.menu.Menu;
import com.myFoodApplication.menuDAOImpl.MenuDAOImpl;

public class AddToCartController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    
    {
        // Retrieve the existing cart from the session or create a new one
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
        
        if (cart == null)
        {
            cart = new HashMap<>();
            
            req.getSession().setAttribute("cart", cart);
        }
        

        // Get menuId and quantity from request parameters
        int menuId = Integer.parseInt(req.getParameter("menuId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        // Fetch the menu item details using the menuId
        MenuDAOImpl mdaoi = new MenuDAOImpl();
        Menu m = mdaoi.getMenuById(menuId);

        // Check if the item already exists in the cart
        if (cart.containsKey(menuId))
        {
            // Update the quantity of the existing item
            CartItem existingItem = cart.get(menuId);
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        } 
        else
        {
            // Add a new item to the cart
            CartItem newItem = new CartItem(menuId, m.getRestaurantId(), m.getMenuName(), quantity, m.getPrice(), m.getImage());
            cart.put(menuId, newItem);
        }

        // Save the updated cart back to the session
        req.getSession().setAttribute("cart", cart);

        // Redirect to the menu page
        resp.sendRedirect("getMenu.jsp");
    }
}
