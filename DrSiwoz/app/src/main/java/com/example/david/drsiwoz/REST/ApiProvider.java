package com.example.david.drsiwoz.REST;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.david.drsiwoz.AppConfig;

/**
 * Created by david on 2016-03-19.
 */
public class ApiProvider {
    private static Api api = null;
    private static ApiProvider instance = null;
    private static Retrofit retrofit = null;

    public ApiProvider(){
        retrofit = new Retrofit.Builder()
                .baseUrl(AppConfig.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Api getApi(){
        if(instance == null){
            instance = new ApiProvider();
        }
        if(api == null){
            api = retrofit.create(Api.class);
        }
        return api;
    }
}
