package com.example.david.drsiwoz.Patients;

import android.util.Log;

import com.example.david.drsiwoz.Models.Examination;
import com.example.david.drsiwoz.Models.Patient;
import com.example.david.drsiwoz.REST.ApiAuthProvider;

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
        Call<Examination> call = ApiAuthProvider.getApi(authToken).getExamination(patientId);
        call.enqueue(new Callback<Examination>() {
            @Override
            public void onResponse(Call<Examination> call, Response<Examination> response) {
                int statusCode = response.code();
                if (statusCode == 500) {
                    Log.e("fetch examination code", String.valueOf(statusCode));
                } else if (statusCode == 404) {
                    Log.e("fetch examination", "not found");
                } else {
                    Examination examination = response.body();
                    view.showExamination(examination);
                }
            }

            @Override
            public void onFailure(Call<Examination> call, Throwable t) {
                Log.e("fetch examination", "onFailure");
            }
        });
    }
}
