package com.example.david.drsiwoz.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jacek on 30.05.16.
 */
public class Examination {
    @SerializedName("status")
    String mStatus;

    @SerializedName("doctor_first_name")
    String mDoctorFirstName;

    @SerializedName("doctor_last_name")
    String mDoctorLastName;

    @SerializedName("created")
    String mCreated;

    @SerializedName("description")
    String mDescription;

    public Examination(String status, String doctor_first_name, String doctor_last_name, String created, String description) {
        this.mStatus = status;
        this.mDoctorFirstName = doctor_first_name;
        this.mDoctorLastName = doctor_last_name;
        this.mCreated = created;
        this.mDescription = description;
    }

    public String getDoctorName() {
        return mDoctorFirstName + " " + mDoctorLastName;
    }

    public String getStatus() {
        return mStatus;
    }

    public String getCreated() {
        return mCreated;
    }

    public String getDescription() {
        return mDescription;
    }
}
