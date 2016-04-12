package com.example.david.drsiwoz.Models;

/**
 * Created by david on 2016-03-19.
 */
public class Drug {
    int id;
    String name;
    int dose;
    String unit;


    String description;

    public Drug( int id, String name, int dose, String unit){
        this.id = id;
        this.name = name;
        this.dose = dose;
        this.unit = unit;
    }
}
