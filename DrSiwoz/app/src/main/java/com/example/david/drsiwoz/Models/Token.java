package com.example.david.drsiwoz.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jacek on 18.04.16.
 */
public class Token {
    @SerializedName("token")
    String mToken;

    public Token(String token) {
        this.mToken = token;
    }

    public String toString() {
        return this.mToken;
    }
}
