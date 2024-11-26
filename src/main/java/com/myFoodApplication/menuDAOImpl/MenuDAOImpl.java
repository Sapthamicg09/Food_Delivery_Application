package com.myFoodApplication.menuDAOImpl;

import com.myFoodApplication.menu.Menu;
import com.myFoodApplication.menuDAO.MenuDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDAOImpl implements MenuDAO {
	
	
	private String url = "jdbc:mysql://localhost:3306/food_application";
	private String username="root";
	private String password = "2909";
	private Connection con;

    public MenuDAOImpl() {
       try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
 

    @Override
    public List<Menu> getAllMenus() {
        List<Menu> menuList = new ArrayList<>();
        String query = "SELECT * FROM menu "; // Fetch only available menu items

        try (PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                // Create Menu object and populate it with data from the database
                Menu menu = new Menu();
                menu.setMenuId(rs.getInt("menuId"));
                menu.setRestaurantId(rs.getInt("restaurantId"));
                menu.setMenuName(rs.getString("menuName"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setRating(rs.getDouble("rating"));
                menu.setIsAvailable(rs.getBoolean("isAvailable"));
                menu.setImage(rs.getString("image"));

                // Add the menu item to the list
                menuList.add(menu);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching menu data.");
            e.printStackTrace();
        }

        return menuList;
    }


    @Override
    public List<Menu> getMenusByRestaurantId(int restaurantId) {
        List<Menu> menus = new ArrayList<>();
        String sql = "SELECT * FROM menu WHERE restaurantId = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, restaurantId);  // Set the restaurantId in the query
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setMenuId(rs.getInt("menuId"));
                menu.setRestaurantId(rs.getInt("restaurantId"));
                menu.setMenuName(rs.getString("menuName"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setRating(rs.getDouble("rating"));
                menu.setIsAvailable(rs.getBoolean("isAvailable"));
                menu.setImage(rs.getString("image"));

                // Add the menu to the list
                menus.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menus;
    }



    public Menu getMenuById(int menuId) {
        String sql = "SELECT * FROM menu WHERE menuId = ?";  // Fixed column name
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, menuId);
            try (ResultSet rs = stmt.executeQuery()) { // Ensure ResultSet is closed automatically
                if (rs.next()) {
                    System.out.println("Found menu: " + rs.getString("menuName"));
                    return new Menu(
                        rs.getInt("menuId"),
                        rs.getInt("restaurantId"),
                        rs.getString("menuName"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getFloat("rating"),
                        rs.getBoolean("isAvailable"),
                        rs.getString("image")
                    );
                } else {
                    System.out.println("No menu found for menuId: " + menuId); // Debugging
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this instead
        }
        return null; // No result found
    }

    
}
    

