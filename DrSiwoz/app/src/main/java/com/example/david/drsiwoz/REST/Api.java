package com.example.david.drsiwoz.REST;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


import com.example.david.drsiwoz.Models.AuthData;
import com.example.david.drsiwoz.Models.Drug;
import com.example.david.drsiwoz.Models.MedicalTest;
import com.example.david.drsiwoz.Models.Patient;
import com.example.david.drsiwoz.Models.UpPatient;

/**
 * Created by david on 2016-03-19.
 */
public interface Api {

    //Patient API
    @GET("api/patients/{patient_id}")
    Call<Patient> getPatient(@Path("patient_id") String patientId);

//    @GET("api/patients/{patientId}/status")
//    Call<MedicalTest> getExamination(@Path("patientId") String patientId);

    @POST("api/patients/{patientId}/status")
    Call<ResponseBody> updatePatient(@Path("patientId") String patientId, @Body UpPatient updatePatientBody);

    //Drugs API
    @GET("api/drugs")
    Call<List<Drug>> getDrugs();

    @Headers("Content-Type: application/json")
    @PUT("api/drugs/{drugId}")
    Call<ResponseBody> applyDrug(@Path("drugId") String drugId);

    @PUT("api/drugs")
    Call<ResponseBody> acceptDrugs(@Body List<String> listId );


    //Medical Tests Api
    @GET("api/patients/{patientId}/medtests")
    Call<List<MedicalTest>> getTests(@Path("patientId") String patientId);

    @POST("api/patients/{patientId}/medtests")
    Call<List<MedicalTest>> requestTest(@Path("patientId") String patientId, @Body String requestedTestId);


    //Exam API
    @GET("api/exams")
    Call<List<MedicalTest>> getExams();


    //Auth API
    @Headers("Content-Type: application/json")
    @POST("auth/login")
    Call<Token> getToken(@Body AuthData authData);
}
