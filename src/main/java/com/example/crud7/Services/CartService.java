package com.example.crud7.Services;

import com.example.crud7.Models.Cart;

import java.util.HashMap;
import java.util.List;

public interface CartService {
    Cart save(Long pId, Long prodId); //This method is used to save a product with
    // the given productId into the cart with the peopleId

    HashMap<String, List<Cart>> listOfItems(String name); //This method retrieves a list of item from the cart by the given name
}
