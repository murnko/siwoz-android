package com.example.david.drsiwoz.Models;

import android.text.BoringLayout;

import com.google.gson.annotations.SerializedName;

/**
 * Created by david on 2016-03-19.
 */
public class Drug {
    @SerializedName("id")
    String id;

    @SerializedName("name")
    String name;

    @SerializedName("serving")
    float dosage;

    @SerializedName("unit")
    String unit;

    @SerializedName("applied")
    Boolean applied;

    @SerializedName("canceled")
    Boolean canceled;

    @SerializedName("accepted")
    Boolean accepted;



    public Drug( String id, String name, float serving, String unit, Boolean applied, Boolean canceled, Boolean accepted){
        this.id = id;
        this.name = name;
        this.dosage = serving;
        this.unit = unit;
        this.applied = applied;
        this.canceled = canceled;
        this.accepted = accepted;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getDosage() {
        return dosage;
    }

    public String getUnit() {
        return unit;
    }

    public Boolean getApplied() {return  applied;}

    public Boolean getCanceled() {return canceled;}

    public Boolean getAccepted() {return accepted;}
}
