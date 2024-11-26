<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Payment Page</title>
    
</head>
<body>
    <div class="container">
        <h1>Order Summary</h1>
        <%
            // Retrieve session attributes
            Double totalPrice = (Double) session.getAttribute("totalPrice");
            Integer totalItems = (Integer) session.getAttribute("totalItems");

            // Handle null values
            if (totalPrice == null) totalPrice = 0.0;
            if (totalItems == null) totalItems = 0;
        %>
        <div class="order-summary">
            <p>Total Items: <%= totalItems %></p>
            <p class="total-price">Total Amount: ₹<%= totalPrice %></p>
        </div>

        <h2>Select Payment Method</h2>
        <form action="ProcessPaymentController" method="POST" class="payment-method">
            <label>
                <input type="radio" name="paymentMethod" value="Credit/Debit Card" required> Credit/Debit Card
            </label>
            <label>
                <input type="radio" name="paymentMethod" value="UPI"> UPI
            </label>
            <label>
                <input type="radio" name="paymentMethod" value="Cash on Delivery"> Cash on Delivery
            </label>
            <button type="submit" class="btn">Proceed to Pay</button>
        </form>
    </div>
</body>
</html>
