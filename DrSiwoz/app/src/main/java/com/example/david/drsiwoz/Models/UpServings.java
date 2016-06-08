package com.example.david.drsiwoz.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by david on 2016-06-07.
 */
public class UpServings {

    @SerializedName("action")
    String action;

    @SerializedName("servingIdList")
    List<String> servingIdList;


    public UpServings(String action, List<String> servingIdList) {
        this.action = action;
        this.servingIdList = servingIdList;
    }
}
