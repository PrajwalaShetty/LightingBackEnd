package com.niit.lightingbackend.dao;

import com.niit.lightingbackend.model.Cart;
import com.niit.lightingbackend.model.CartItem;

public interface CartItemDAO {

	void addCartItem(CartItem cartItem);
	void removeCartItem(int cartitemid);
	void removeAllCartItems(Cart cart);
}
