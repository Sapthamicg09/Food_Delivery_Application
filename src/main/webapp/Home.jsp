<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.myFoodApplication.user.User" %>
<%@ page import="com.myFoodApplication.restaurant.Restaurant" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <!-- Link to Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lora:wght@600&display=swap" rel="stylesheet">
    <!-- Font Awesome for Icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <style>
        body {
            background: url('https://www.example.com/food-background.jpg') no-repeat center center fixed;
            background-size: cover;
            height: 100vh;
            font-family: 'Poppins', sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            justify-content: flex-start;
            align-items: center;
        }

        .header {
            background-color: rgba(144, 238, 144, 0.8); /* Light green background */
            color: #2c6c39; /* Dark green text */
            padding: 20px;
            font-size: 1.5rem;
            text-align: center;
            width: 100%;
            margin-bottom: 30px;
            font-weight: bold;
            border-radius: 8px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
        }

        .restaurant-container {
            width: 100%;
            max-width: 1200px;
            display: grid;
            grid-template-columns: repeat(4, 1fr); /* 4 columns per row */
            gap: 20px;
            padding: 0 20px;
        }

        /* Ensure the link doesn't get underlined */
        .restaurant-card a {
            text-decoration: none !important; /* Forcefully remove underline */
            color: inherit !important; /* Ensure inherited color */
        }

        /* Styling for restaurant card */
        .restaurant-card {
            background: rgba(144, 238, 144, 0.3); /* Very light green background */
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
            text-align: center;
            font-family: 'Lora', serif;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            cursor: pointer; /* Indicate it's clickable */
            display: block;
        }

        .restaurant-card:hover {
            transform: scale(1.05);
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.15);
        }

        .restaurant-card img {
            width: 100%;
            height: 200px;
            object-fit: cover;
            border-radius: 8px;
            margin-bottom: 15px;
        }

        .restaurant-card h3 {
            font-size: 1.4rem;
            color: #2c6c39; /* Dark green color */
            margin-bottom: 10px;
        }

        .restaurant-card p {
            font-size: 1rem;
            color: #333;
            margin-bottom: 8px;
        }

        /* Remove underline from links inside card details */
        .restaurant-card p a {
            text-decoration: none !important; /* Forcefully remove underline */
            color: inherit !important; /* Ensure inherited color */
        }

        /* Mobile Responsiveness */
        @media (max-width: 768px) {
            .restaurant-container {
                grid-template-columns: repeat(2, 1fr); /* 2 columns per row on smaller screens */
            }

            .restaurant-card {
                width: 100%;
            }

            .header {
                font-size: 1.3rem;
                padding: 15px;
            }
        }
    </style>
</head>
<body>

<% 
    User user = (User)session.getAttribute("loggedInUser");
%>

<%
    List<Restaurant> restaurantList = (List<Restaurant>) session.getAttribute("restaurantList");
%>

<!-- Header -->
<div class="header">
    Welcome, <%= user != null ? user.getUsername() : "Guest" %>!
</div>

<!-- Restaurant List Section -->
<div class="restaurant-container">
    <% 
        if (restaurantList != null && !restaurantList.isEmpty()) {
            for (Restaurant restaurant : restaurantList) {
    %>
        <!-- Make the entire card clickable -->
        <a href="getMenu?restaurantId=<%= restaurant.getRestaurantId() %>" class="restaurant-card">
            <img src="<%= restaurant.getImage() %>" alt="<%= restaurant.getName() %>">
            <h3><%= restaurant.getName() %></h3>
            <p><strong>Cuisine:</strong> <%= restaurant.getCuisineType() %></p>
            <p><strong>Address:</strong> <%= restaurant.getAddress() %></p>
            <p><strong>Ratings:</strong> <%= restaurant.getRating() %>/5</p>
            <p><strong>Delivery Time:</strong> <%= restaurant.getDeliveryTime() %> mins</p>
        </a>
    <% 
            }
        } else {
    %>
        <p>No restaurants available at the moment.</p>
    <% } %>
</div>

</body>
</html>
