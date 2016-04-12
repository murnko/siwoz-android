package com.example.david.drsiwoz.Models;

/**
 * Created by david on 2016-03-19.
 */
public class Patient {
    int id;
    String name;
    String surname;
    String description;

    public Patient( int id, String name, String surname, String description){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.description = description;
    }
}
