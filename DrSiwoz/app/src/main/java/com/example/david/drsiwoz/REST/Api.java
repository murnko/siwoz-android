package com.example.david.drsiwoz.REST;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;


import com.example.david.drsiwoz.Models.AuthData;
import com.example.david.drsiwoz.Models.Drug;
import com.example.david.drsiwoz.Models.Examination;
import com.example.david.drsiwoz.Models.Patient;
import com.example.david.drsiwoz.Models.Serving;
import com.example.david.drsiwoz.Models.UpPatient;
import com.example.david.drsiwoz.Models.UpServings;

/**
 * Created by david on 2016-03-19.
 */
public interface Api {

    //Patient API
    @GET("api/patients/{patient_id}")
    Call<Patient> getPatient(@Path("patient_id") String patientId);

    @GET("api/patients/{patientId}/status")
    Call<Examination> getExamination(@Path("patientId") String patientId);

    @POST("api/patients/{patientId}/status")
    Call<ResponseBody> updatePatient(@Path("patientId") String patientId, @Body UpPatient updatePatientBody);

    //Drugs API
    @GET("api/patients/{patientId}/servings")
    Call<List<Serving>> getServings(@Path("patientId") String patientId);

    @Headers("Content-Type: application/json")
    @POST("api/patients/{patientId}/drugs/apply")
    Call<ResponseBody> applyDrug(@Path("patientId") String patientId, @Body String servingId);

    @POST("api/patients/{patientId}/servings")
    Call<ResponseBody> updateServing(@Path("patientId") String patientId, @Body UpServings upServings);



    //Auth API
    @Headers("Content-Type: application/json")
    @POST("auth/login")
    Call<Token> getToken(@Body AuthData authData);
}
