package com.lambdaschool.crudyrestaurants.models;

import javax.persistence.*;

@Entity
@Table(name = "menus")
public class Menu
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //to decide how much of the computer memory we are going to take up with thi field
    //always use long for id
    private long menuid;
    //value should not false - always want something for the name of the dish
    @Column(nullable = false)
    private String dish;

    private double price;

    //connecting the tables menu to restaurant using the primary key which is usually the id of the class
    @ManyToOne
    @JoinColumn(name = "restaurantid", nullable = false)
    private Restaurant restaurant;

    public Menu()
    {
        //default constructor (always) for the JPA
    }

    public Menu(
        String dish,
        double price,
        Restaurant restaurant)
    {
        this.dish = dish;
        this.price = price;
        this.restaurant = restaurant;
    }

    public long getId()
    {
        return menuid;
    }

    public void setId(long menuid)
    {
        this.menuid = menuid;
    }

    public String getDish()
    {
        return dish;
    }

    public void setDish(String dish)
    {
        this.dish = dish;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public Restaurant getRestaurant()
    {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant)
    {
        this.restaurant = restaurant;
    }
}
