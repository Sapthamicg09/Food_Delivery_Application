package com.myFoodApplication.menuDAO;

import java.util.List;
import com.myFoodApplication.menu.Menu;

public interface MenuDAO {
	
	List<Menu> getAllMenus();
    List<Menu> getMenusByRestaurantId(int restaurantId);
    Menu getMenuById(int menuId);
    
}
