<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.myFoodApplication.cartItem.CartItem" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
    <title>Your Cart</title>
    
</head>
<body>
    <h1>Your Cart</h1>

    <div class="cart-container">
        <%
            // Retrieve the cart from the session
            Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
            double totalPrice = 0;

            if (cart == null || cart.isEmpty()) {
        %>
                <p class="empty-message">Your cart is empty. <a href="Home.jsp">Go to Menu</a> to add items!</p>
        <%
            } else {
        %>
                <!-- Loop through cart items -->
        <%
                for (CartItem cartItem : cart.values()) {
                    double itemTotal = cartItem.getPrice() * cartItem.getQuantity();
                    totalPrice += itemTotal;
        %>
                    <div class="cart-item">
                        <div class="item-details">
                            <h3><%= cartItem.getName() %></h3>
                            <p>Price per item: ₹<%= cartItem.getPrice() %></p>
                            <p>Total: ₹<%= itemTotal %></p>
                        </div>

                        <!-- Update form for quantity -->
                        <form action="UpdateCartItemController" method="POST" style="margin: 0; display: inline;">
                            <div class="update-quantity">
                                <select name="quantity">
                                    <% for (int i = 1; i <= 15; i++) { %>
                                        <option value="<%= i %>" <%= cartItem.getQuantity() == i ? "selected" : "" %>>
                                            <%= i %>
                                        </option>
                                    <% } %>
                                </select>
                                <input type="hidden" name="itemId" value="<%= cartItem.getItemId() %>">
                                <button type="submit" class="update-btn">Update</button>
                            </div>
                        </form>

                        <!-- Delete form for item -->
                        <form action="DeleteCartItemController" method="POST" style="margin: 0; display: inline;">
                            <input type="hidden" name="itemId" value="<%= cartItem.getItemId() %>">
                            <button type="submit" class="delete-btn">Delete</button>
                        </form>
                    </div>
        <%
                }
        %>
            <div class="cart-total">
                Total Price: ₹<%= totalPrice %>
            </div>

            <!-- Checkout Button -->
            <form action="CheckoutController" method="POST" style="text-align: center; margin-top: 20px;">
                <input type="hidden" name="totalPrice" value="<%= totalPrice %>">
                <button type="submit" class="checkout-btn">Proceed to Checkout</button>
            </form>

            <!-- Clear All Button -->
            <form action="ClearCartController" method="POST" style="text-align: center; margin-top: 20px;">
                <button type="submit" class="clear-btn">Clear All</button>
            </form>
        <%
            }
        %>
    </div>
</body>
</html>
