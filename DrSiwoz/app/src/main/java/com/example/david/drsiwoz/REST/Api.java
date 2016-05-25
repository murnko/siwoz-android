package com.example.david.drsiwoz.REST;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


import com.example.david.drsiwoz.Models.AuthData;
import com.example.david.drsiwoz.Models.Drug;
import com.example.david.drsiwoz.Models.Patient;

/**
 * Created by david on 2016-03-19.
 */
public interface Api {

    @GET("patients/{patient_id}")
    Call<Patient> getPatient(@Path("patient_id") String patientId);

    @POST("patient")
    Call<RequestResult> setPatient(int id, String name, int dose, String unit);
git a
    @DELETE("patient")
    Call<RequestResult> deletePatient(int id);

    @GET("drugs")
    Call<List<Drug>> getDrugs();

    @POST("drugs")
    Call<RequestResult> setDrugs(int id, String name, int dose, String unit);

    @DELETE("drugs")
    Call<RequestResult> deleteDrugs(int id);

    @Headers("Content-Type: application/json")
    @POST("auth/login")
    Call<Token> getToken(@Body AuthData authData);
}
