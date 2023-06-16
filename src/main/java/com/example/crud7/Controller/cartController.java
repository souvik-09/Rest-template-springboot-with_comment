package com.example.crud7.Controller;
import com.example.crud7.Models.Cart;
import com.example.crud7.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;

@RestController // This represents that this is a Restful controller which handles http
//requests and returns json response
public class cartController {
    @Autowired
    CartService cartService; //Here we injected the instance of the CartService interface

    //This Http method handles only Post request to save product to cart
    @PostMapping("/cart/{pId}/{prodId}")
    public Cart save (@PathVariable Long pId , @PathVariable Long prodId ){
        return cartService.save(pId,prodId);
    }

    //This Http method handles only Get request to retrieve the list of items from the
    // Cart and returns a HashMap where the key is the provided name and the value
    // is the list of Cart objects
    @GetMapping("/cart/{name}")
    public HashMap<String , List<Cart>> listOfItems (@PathVariable String name){
        return  cartService.listOfItems(name);
    }
}
