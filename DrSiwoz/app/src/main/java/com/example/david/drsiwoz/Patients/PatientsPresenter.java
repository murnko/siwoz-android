package com.example.david.drsiwoz.Patients;

import android.util.Log;

import com.example.david.drsiwoz.Models.MedicalTest;
import com.example.david.drsiwoz.Models.Patient;
import com.example.david.drsiwoz.Models.UpPatient;
import com.example.david.drsiwoz.REST.ApiAuthProvider;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by david on 2016-03-19.
 */
public class PatientsPresenter {
    private PatientsView view;

    public PatientsPresenter(PatientsView view){
        this.view = view;
    }

    public void getPatient(String authToken, String patientId) {
        Call<Patient> call = ApiAuthProvider.getApi(authToken).getPatient(patientId);
        call.enqueue(new Callback<Patient>() {
            @Override
            public void onResponse(Call<Patient> call, Response<Patient> response) {
                int statusCode = response.code();
                if (statusCode == 500) {
                    Log.e("fetch patient code", String.valueOf(statusCode));
                } else if (statusCode == 404) {
                    Log.e("fetch patient", "not found");
                    view.resetPatientId();
                } else {
                    Patient patient = response.body();
                    view.showPatient(patient);
                }
            }

            @Override
            public void onFailure(Call<Patient> call, Throwable t) {
                Log.e("fetch patient", "onFailure");
            }
        });
    }

    public void getExamination(String authToken, String patientId) {
        Call<MedicalTest> call = ApiAuthProvider.getApi(authToken).getExamination(patientId);
        call.enqueue(new Callback<MedicalTest>() {
            @Override
            public void onResponse(Call<MedicalTest> call, Response<MedicalTest> response) {
                int statusCode = response.code();
                if (statusCode == 500) {
                    Log.e("fetch examination code", String.valueOf(statusCode));
                } else if (statusCode == 404) {
                    Log.e("fetch examination", "not found");
                } else {
                    MedicalTest medicalTest = response.body();
                    view.showExamination(medicalTest);
                }
            }

            @Override
            public void onFailure(Call<MedicalTest> call, Throwable t) {
                Log.e("fetch examination", "onFailure");
            }
        });
    }

    public void updatePatient(String authToken, final String patientId, UpPatient patientStatus) {
        Call<ResponseBody> call = ApiAuthProvider.getApi(authToken).updatePatient(patientId, patientStatus);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call call, Response response) {
                int statusCode = response.code();
                if (statusCode == 200) {
                    Log.d("code", "OK200");
                }
                else{
                    Log.d("code", "not 200");
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("bb", t.toString());
                Log.d("bb", "onFailure");
            }
        });
    }
}
