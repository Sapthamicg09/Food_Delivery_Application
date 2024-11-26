package com.myFoodApplication.restaurant;

public class Restaurant {
    private String name;
    private String cuisineType;
    private String address;
    private float ratings;
    private int deliveryTime;
    private boolean isActive;
    private String image;  // Change to String
	private int restaurantId;

    public int getRestaurantId() {
        return restaurantId ;
    }

    public void setRestaurantId(int restaurantId) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getRating() {
        return ratings;
    }

    public void setRating(float rating) {
        this.ratings = rating;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getImage() {
        return image;  // Change to String
    }

    public void setImage(String image) {  // Change to String
        this.image = image;
    }

    public Restaurant(int restaurantId, String name, String cuisineType, String address, float ratings, int deliveryTime,
                      boolean isActive, String image) {  // Change to String
        super();
        this.restaurantId = restaurantId;
        this.name = name;
        this.cuisineType = cuisineType;
        this.address = address;
        this.ratings = ratings;
        this.deliveryTime = deliveryTime;
        this.isActive = isActive;
        this.image = image;  // Change to String
    }

    public Restaurant() {
        super();
    }

    public Restaurant(String name, String cuisineType, String address, float ratings, int deliveryTime, boolean isActive,
                      String image) {  // Change to String
        super();
        this.name = name;
        this.cuisineType = cuisineType;
        this.address = address;
        this.ratings = ratings;
        this.deliveryTime = deliveryTime;
        this.isActive = isActive;
        this.image = image;  // Change to String
    }

    @Override
    public String toString() {
        return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", cuisineType=" + cuisineType + ", address=" + address
                + ", rating=" + ratings + ", deliveryTime=" + deliveryTime + ", isActive=" + isActive + ", image="
                + image + "]";  // Change to String
    }
}
