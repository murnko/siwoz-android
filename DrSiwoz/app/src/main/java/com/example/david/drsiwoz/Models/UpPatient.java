package com.example.david.drsiwoz.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by david on 2016-05-29.
 */
public class UpPatient {
    @SerializedName("status")
    String mStatus;

    @SerializedName("description")
    String mDescription;



    public UpPatient(String status, String description) {
        this.mStatus = status;
        this.mDescription = description;

    }

}
