package com.example.david.drsiwoz.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jacek on 18.04.16.
 */
public class AuthData {
    @SerializedName("username")
    String mUsername;

    @SerializedName("password")
    String mPassword;

    public AuthData(String username, String password) {
        this.mUsername = username;
        this.mPassword = password;
    }
}

