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

    @SerializedName("acceptance_date")
    String mAcceptanceDate;

    @SerializedName("release_date")
    String mReleaseDate;

    @SerializedName("pesel")
    String mPesel;

    public Patient(String id, String name, String acceptance_date, String release_date, String pesel) {
        this.mId = id;
        this.mName = name;
        this.mAcceptanceDate = acceptance_date;
        this.mReleaseDate = release_date;
        this.mPesel = pesel;
    }

    public String getName() {
        return this.mName;
    }
    public String getAcceptanceDate() {
        return this.mAcceptanceDate;
    }
    public String getReleaseDate() {
        return this.mReleaseDate;
    }
    public String getPesel() {
        return this.mPesel;
    }
}

