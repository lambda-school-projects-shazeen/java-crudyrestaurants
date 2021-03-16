package com.lambdaschool.crudyrestaurants.controllers;
import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.services.RestaurantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantsController {
    @Autowired
    private RestaurantServices restaurantServices;
    //http://localhost:2019/restaurants/restaurants
    @GetMapping(value = "/restaurants", produces = "application/json")
    public ResponseEntity<?> listAllRestaurants() {
        List<Restaurant> restaurantList = restaurantServices.findAllRestaurants();
        return new ResponseEntity<>(restaurantList, HttpStatus.OK);
    }
    //http://localhost:2019/restaurants/restaurant/{restid}
    @GetMapping(value = "/restaurant/{restid}", produces = "application/json")
    public ResponseEntity<?> findRestaurantById(@PathVariable long restid) {
        Restaurant restaurant = restaurantServices.findRestaurantById(restid);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
    //http://localhost:2019/restaurants/name/Good%20Eats
    @GetMapping(value = "/name/{restname}", produces = "application/json")
    public ResponseEntity<?> findRestaurantByName(@PathVariable String restname) {
        Restaurant restaurant = restaurantServices.findRestaurantByName(restname);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
    //http://localhost:2019/restaurants/likename/eat
    @GetMapping(value = "/likename/{subname}", produces = "application/json")
    public ResponseEntity<?> findRestaurantsByLikeName(@PathVariable String subname) {
        List<Restaurant> restaurantList = restaurantServices.findRestaurantsByNameLike(subname);
        return new ResponseEntity<>(restaurantList, HttpStatus.OK);
    }
    //http://localhost:2019/restaurants/menucounts
    //http://localhost:2019/restaurants/likedish/cheese
}