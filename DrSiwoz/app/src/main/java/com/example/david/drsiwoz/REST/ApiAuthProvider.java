package com.example.david.drsiwoz.REST;

import com.example.david.drsiwoz.AppConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jacek on 26.05.16.
 */
public class ApiAuthProvider {
    private static Api api = null;
    private static ApiAuthProvider instance = null;
    private static Retrofit retrofit = null;

    public ApiAuthProvider(final String authToken){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                String token = "Token " + authToken;
                Request request = original.newBuilder()
                        .header("Authorization", token)
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });
        OkHttpClient client = httpClient.build();
        retrofit = new Retrofit.Builder()
                .baseUrl(AppConfig.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public static Api getApi(String authToken){
        if(instance == null){
            instance = new ApiAuthProvider(authToken);
        }
        if(api == null){
            api = retrofit.create(Api.class);
        }
        return api;
    }
}


