package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.repositories.RestaurantRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "restaurantServices")
public class RestaurantServicesImpl implements RestaurantServices
{
    @Autowired
    private RestaurantRepositories restaurantRepositories;

    @Transactional
    @Override
    public Restaurant save(Restaurant restaurant)
    {
        return restaurantRepositories.save(restaurant);
    }
}
