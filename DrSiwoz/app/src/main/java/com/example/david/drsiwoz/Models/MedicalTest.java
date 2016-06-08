package com.example.david.drsiwoz.Models;

import android.util.Pair;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jacek on 30.05.16.
 */
public class MedicalTest {


    @SerializedName("first_name")
    String mDoctorFirstName;

    @SerializedName("last_name")
    String mDoctorLastName;

    @SerializedName("created")
    String mCreated;

    @SerializedName("done")
    String mDone;

    @SerializedName("result")
    String mResults;

    public MedicalTest(String status, String first_name, String last_name, String created, String done, String result) {
        this.mDoctorFirstName = first_name;
        this.mDoctorLastName = last_name;
        this.mCreated = created;
        this.mDone = done;
        this.mResults = result;
    }

    public String getDoctorName() {
        return mDoctorFirstName + " " + mDoctorLastName;
    }

    public String getStatus() {
        return mDone;
    }

    public String getCreated() {
        return mCreated;
    }

    public String getDone() {
        return mDone;
    }

    public List<Pair<String, String>> getmResults() {
        if (this.mResults.indexOf(new String("-")) == -1) {
            return new ArrayList<>();
        }
        List<Pair<String, String>> hashResults = new ArrayList<>();
        String[] parts = this.mResults.split("-");
        for (Integer i = 0; i < parts.length; i++) {
            String result[] = parts[i].split("\\|");
            Pair<String, String> hashResult = new Pair<>(result[0], result[1]);
            hashResults.add(hashResult);
        }
        return hashResults;
    }
}
