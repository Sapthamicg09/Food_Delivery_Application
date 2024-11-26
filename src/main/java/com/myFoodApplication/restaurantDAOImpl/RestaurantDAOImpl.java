package com.myFoodApplication.restaurantDAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myFoodApplication.restaurant.Restaurant;
import com.myFoodApplication.restaurantDAO.RestaurantDAO;


public class RestaurantDAOImpl implements RestaurantDAO {
    
    private String url = "jdbc:mysql://localhost:3306/food_application";
	private String username="root";
	private String password = "2909";
	private Connection con;

    public RestaurantDAOImpl() {
       try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        String sql = "INSERT INTO restaurant (name, cuisine_type, address, rating, delivery_time, is_active, image) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, restaurant.getName());
            stmt.setString(2, restaurant.getCuisineType());
            stmt.setString(3, restaurant.getAddress());
            stmt.setFloat(4, restaurant.getRating());
            stmt.setInt(5, restaurant.getDeliveryTime());
            stmt.setBoolean(6, restaurant.isActive());
            stmt.setString(7, restaurant.getImage());  // Use setString for String
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                restaurant.setRestaurantId(generatedKeys.getInt(1));
            }
            return restaurant;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Restaurant getById(int RestaurantId) {
        String sql = "SELECT * FROM restaurant WHERE restaurantId = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, RestaurantId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Restaurant(
                    rs.getInt("restaurantId"),
                    rs.getString("name"),
                    rs.getString("cuisineType"),
                    rs.getString("address"),
                    rs.getFloat("ratings"),
                    rs.getInt("deliveryTime"),
                    rs.getBoolean("isActive"),
                    rs.getString("image")  // Use getString for String
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Restaurant> getAll() {
        List<Restaurant> restaurants = new ArrayList<>();
        String sql = "SELECT * FROM restaurant";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                restaurants.add(new Restaurant(
                    rs.getInt("restaurantId"),
                    rs.getString("name"),
                    rs.getString("cuisineType"),
                    rs.getString("address"),
                    rs.getFloat("ratings"),
                    rs.getInt("deliveryTime"),
                    rs.getBoolean("isActive"),
                    rs.getString("image")  // Use getString for String
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        String sql = "UPDATE restaurant SET name = ?, cuisine_type = ?, address = ?, rating = ?, delivery_time = ?, is_active = ? WHERE restaurantId = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, restaurant.getName());
            stmt.setString(2, restaurant.getCuisineType());
            stmt.setString(3, restaurant.getAddress());
            stmt.setFloat(4, restaurant.getRating());
            stmt.setInt(5, restaurant.getDeliveryTime());
            stmt.setBoolean(6, restaurant.isActive());
            stmt.setString(7, restaurant.getImage());  // Use setString for String
            stmt.setInt(8, restaurant.getRestaurantId());
            stmt.executeUpdate();
            return restaurant;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(int restaurantId) {
        String sql = "DELETE FROM restaurant WHERE restaurantId = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, restaurantId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}