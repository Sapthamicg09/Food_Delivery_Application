package com.myFoodApplication.cartItem;

public class CartItem 
{
	
	private int itemId;
	private int restaurantId;
	private String name;
	private int quantity;
	private double price;
	private String image;
	
	
	public CartItem(int itemId, int restaurantId, String name, int quantity, double price, String image) {
		super();
		this.itemId = itemId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.image = image;
	}

	public CartItem(int itemId, int restaurantId, String name, int quantity, double price) 
	{
		this.itemId = itemId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", restaurantId=" + restaurantId + ", name=" + name + ", quantity="
				+ quantity + ", price=" + price + ", image=" + image + "]";
	}

	
	
	
	
	
	
	
	

}
