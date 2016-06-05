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

    @SerializedName("suspended")
    Boolean suspended;



    public Drug( String id, String name, float serving, String unit, Boolean applied, Boolean canceled, Boolean accepted, Boolean suspended){
        this.id = id;
        this.name = name;
        this.dosage = serving;
        this.unit = unit;
        this.applied = applied;
        this.canceled = canceled;
        this.accepted = accepted;
        this.suspended = suspended;
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

    public Boolean isApplied() {return  applied;}

    public Boolean isCanceled() {return canceled;}

    public Boolean isAccepted() {return accepted;}

    public Boolean isSuspended() {return suspended;}
}
