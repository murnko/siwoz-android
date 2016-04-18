package com.example.david.drsiwoz.REST;

import com.google.gson.annotations.SerializedName;


/**
 * Created by jacek on 18.04.16.
 */
public class Token {
    @SerializedName("token")
    String token;

    public String toString() {
        return this.token;
    }

    public String getToken() {
        return this.token;
    }
}
