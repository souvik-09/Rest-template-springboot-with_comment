package com.example.crud7.Services;

import com.example.crud7.DTO.PeopleDTO;
import com.example.crud7.Models.Cart;
import com.example.crud7.Models.Product;
import com.example.crud7.Repository.CartRepo;
import com.example.crud7.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service //This indicates that this class is a service component
public class CartServiceImpl implements CartService {
    @Autowired
    RestTemplate restTemplate; //This is used to make HTTP requests to external services
    @Autowired
    CartRepo cartRepo; //This is repository interfaces used to interact with the database

    @Autowired
    ProductRepo productRepo; //This is repository interfaces used to interact with the database

    @Override
    public Cart save(Long pId, Long prodId) { //This method is used to save product
        // with given productId into the cart with given PeopleId

        PeopleDTO people = restTemplate.getForObject("http://localhost:8080/people/" + pId, PeopleDTO.class); // This line uses a RestTemplate instance to make an HTTP GET request to the URL that represents person based on the peopleId

        Product product = restTemplate.getForObject("http://localhost:8081/product/" + prodId, Product.class); // This line uses a RestTemplate instance to make an HTTP GET request to the URL that represents product based on the productId

        Product prod = productRepo.save(product); //This line saves the product object, obtained from the external service, to the database using the productRepo repository

        Cart cart = new Cart(); // This line creates a new instance of the Cart class
        cart.setName(people.getName()); // This line mapping the name field of the cart object with
        //the value we got from people object
        cart.setEmail(people.getEmail()); // This line mapping the email field of the cart object with
        //the value we got from people object
        cart.setProducts(Arrays.asList(product)); // This line sets the products property
        // of the cart object with a list containing a single Product object

        var save = cartRepo.save(cart); //This line saved the cart obj to the db

        return save; //Here we're returning saved cart obj
    }

    // It is using cartRepo to find carts by name and then retrieved list of Cart
    @Override
    public HashMap<String , List<Cart>> listOfItems(String name) {
        List<Cart> cart = cartRepo.findByName(name);

        HashMap<String ,List<Cart>> map = new HashMap<>(); //creates a new instance of HashMap
        // where the key is of type String and the value is a list of Cart objects
        map.put(name , cart); //This adds the retrieved list of Cart objects
        // to the HashMap with the key as the provided name

        return map; // returned a HashMap where the key is the provided
        // name and the value is a list of Cart objects retrieved
        // from the database based on that name
    }

}

