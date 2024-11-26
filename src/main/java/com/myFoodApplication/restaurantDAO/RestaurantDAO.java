package com.myFoodApplication.restaurantDAO;

import java.util.List;

import com.myFoodApplication.restaurant.Restaurant;

public interface RestaurantDAO {
    Restaurant create(Restaurant restaurant);
    Restaurant getById(int restaurantId);
    List<Restaurant> getAll();
    Restaurant update(Restaurant restaurant);
    void delete(int restaurantId);
}
