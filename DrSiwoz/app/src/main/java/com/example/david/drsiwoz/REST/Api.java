package com.example.david.drsiwoz.REST;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;


import com.example.david.drsiwoz.Models.AuthData;
import com.example.david.drsiwoz.Models.Drug;
import com.example.david.drsiwoz.Models.Examination;
import com.example.david.drsiwoz.Models.Patient;
import com.example.david.drsiwoz.Models.UpPatient;

/**
 * Created by david on 2016-03-19.
 */
public interface Api {

    @GET("api/patients/{patient_id}")
    Call<Patient> getPatient(@Path("patient_id") String patientId);

    @GET("api/patients/{patientId}/status")
    Call<Examination> getExamination(@Path("patientId") String patientId);

    @POST("api/patients/{patientId}/status")
    Call<ResponseBody> updatePatient(@Path("patientId") String patientId, @Body UpPatient updatePatientBody);

    @GET("api/drugs")
    Call<List<Drug>> getDrugs();

    @Headers("Content-Type: application/json")
    @POST("auth/login")
    Call<Token> getToken(@Body AuthData authData);
}
