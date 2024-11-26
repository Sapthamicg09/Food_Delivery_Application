<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.myFoodApplication.menu.Menu" %>
<%@ page import="java.util.List" %>
<%@ page import="com.myFoodApplication.menuDAOImpl.MenuDAOImpl" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu List</title>
    
</head>
<body>

    <h1>Menu List</h1>

    <div class="container">
        <%
            List<Menu> menuList = (List<Menu>) session.getAttribute("menuList");
            if (menuList == null || menuList.isEmpty()) {
        %>
            <p>No menu items available.</p>
        <%
            } else {
                int index = 0;
                for (Menu menu : menuList) {
                    String quantityId = "quantity_" + index;
        %>
                    <div class="card">
                        <img src="<%= menu.getImage() %>" alt="<%= menu.getMenuName() %>">
                        <div class="card-body">
                            <h3 class="card-title"><%= menu.getMenuName() %></h3>
                            <p class="card-description"><%= menu.getDescription() %></p>
                            <p class="card-price">₹<%= menu.getPrice() %></p>
                            <p class="card-rating">Rating: <%= menu.getRating() %>/5</p>

                            <form action="AddToCartController" method="POST">
                                <input type="hidden" name="menuId" value="<%= menu.getMenuId() %>">
                                <select name="quantity" class="quantity-select">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                </select>

                                <button type="submit" class="add-card-button">Add to Cart</button>
                            </form>
                        </div>
                    </div>
        <%
                    index++;
                }
            }
        %>
    </div>

    <button class="cart-button" onclick="goToCart()">Go to Cart</button>

    <script>
        function goToCart() {
            window.location.href = 'Cart.jsp';
        }
    </script>

</body>
</html>