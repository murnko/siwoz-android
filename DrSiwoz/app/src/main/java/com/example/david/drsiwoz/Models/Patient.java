package com.example.david.drsiwoz.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by david on 2016-03-19.
 */

public class Patient {
    @SerializedName("id")
    String mId;

    @SerializedName("name")
    String mName;

    @SerializedName("surname")
    String mSurname;

    @SerializedName("description")
    String mDescription;

    public Patient(String id, String name, String surname, String description) {
        this.mName = name;
        this.mSurname = surname;
        this.mId = id;
        this.mDescription = description;
    }

    public String getName() {
        return this.mName;
    }
    public String getSurname() {
        return this.mSurname;
    }
}

