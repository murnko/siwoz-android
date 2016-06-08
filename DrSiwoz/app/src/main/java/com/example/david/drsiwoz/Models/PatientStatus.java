package com.example.david.drsiwoz.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by david on 2016-06-08.
 */
public class PatientStatus {

    @SerializedName("doctor_first_name")
    String mDoctorFirstName;

    @SerializedName("doctor_last_name")
    String mDoctorLastName;

    @SerializedName("created")
    String mCreated;

    @SerializedName("status")
    String mStatus;

    @SerializedName("description")
    String mDescription;



    public PatientStatus(String status, String description, String doctor_first_name,
                         String doctor_last_name, String created) {

        this.mStatus = status;
        this.mDescription = description;
        this.mCreated= created;
        this.mDoctorFirstName = doctor_first_name;
        this.mDoctorLastName = doctor_last_name;

    }

    public String getStatus() {return mStatus;}
    public String getDescription() {return mDescription;}
    public String getCreated() {return mCreated;}
    public String getDoctorName() {return mDoctorFirstName+mDoctorLastName;}
}
