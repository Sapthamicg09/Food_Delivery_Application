package com.myFoodApplication.menu;

public class Menu {
    private int menuId;
    private int restaurantId;
    private String menuName;
    private String description;
    private double price;
    private double rating;
    private boolean isAvailable;
    private String image;

    // Getters and Setters
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }


	public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public Menu() {
		super();
	}
	
    public Menu(int restaurantId, String menuName, String description, double price, double rating, boolean isAvailable,
			String image) {
		super();
		this.restaurantId = restaurantId;
		this.menuName = menuName;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.isAvailable = isAvailable;
		this.image = image;
	}

	
	

	public Menu(int menuId, int restaurantId, String menuName, String description, double price, double rating,
			String image) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.menuName = menuName;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.image = image;
	}

	public Menu(int menuId, int restaurantId, String menuName, String description, double price, double rating,
			boolean isAvailable, String image) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.menuName = menuName;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.isAvailable = isAvailable;
		this.image = image;
	}
    
}
