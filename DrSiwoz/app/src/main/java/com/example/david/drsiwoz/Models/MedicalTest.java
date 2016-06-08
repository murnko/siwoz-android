package com.example.david.drsiwoz.Models;

import android.util.Pair;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jacek on 30.05.16.
 */
public class MedicalTest {


    @SerializedName("status")
    String mStatus;

    @SerializedName("doctor_first_name")
    String mDoctorFirstName;

    @SerializedName("doctor_last_name")
    String mDoctorLastName;

    @SerializedName("created")
    String mCreated;

    @SerializedName("done")
    String mDone;

    @SerializedName("results")
    List<Pair> mResults;

    public MedicalTest(String status, String doctor_first_name, String doctor_last_name, String created, String done, List<Pair> results) {
        this.mStatus = status;
        this.mDoctorFirstName = doctor_first_name;
        this.mDoctorLastName = doctor_last_name;
        this.mCreated = created;
        this.mDone = done;
        this.mResults = results;
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

    public String getDone() {
        return mDone;
    }

    public List<Pair> getmResults() {return mResults;}
}
