package com.myFoodApplication.cartDAOImpl;

import java.util.HashMap;
import java.util.Map;

import com.myFoodApplication.cartItem.CartItem;

public class CartDAOImpl 
{
	
	private Map<Integer, CartItem> items;

	public CartDAOImpl() {
		this.items = new HashMap<>();
	}
	
	//Add an item to the cart
	public Map<Integer, CartItem> addItems(CartItem item) {
		
		int itemId = item.getItemId();
		
		if(items.containsKey(itemId))
		{
			CartItem existingItem = items.get(itemId);
			existingItem.setQuantity(existingItem.getQuantity()+item.getQuantity());
			
		}
		else
		{
			items.put(itemId, item);
		}
		
		return items;
		
	}
	
	
	public void updateItem(int itemId, int quantity) 
	{
	    if (items.containsKey(itemId)) 
	    {
	        if (quantity <= 0)
	        {
	            items.remove(itemId); // Remove item if quantity is 0 or less
	        }
	        else 
	        {
	            items.get(itemId).setQuantity(quantity); // Update quantity
	        }
	    }
	}

	
	public Map<Integer, CartItem> removeItem(Map<Integer, CartItem> items, int itemId) {
	    if (items != null) {
	        items.remove(itemId);
	    }
	    return items;
	}
	
	

	
	
	public Map<Integer, CartItem> getItems() {
		return items;
	}
	
	public void clear() {
		items.clear();
	}
	
	

}
