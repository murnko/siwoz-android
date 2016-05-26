package com.example.david.drsiwoz.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by david on 2016-03-19.
 */
public class Drug {
    @SerializedName("id")
    String id;

    @SerializedName("name")
    String name;

    @SerializedName("dosage")
    int dosage;

    @SerializedName("unit")
    String unit;

    public Drug( String id, String name, int dosage, String unit){
        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.unit = unit;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDosage() {
        return dosage;
    }

    public String getUnit() {
        return unit;
    }
}
