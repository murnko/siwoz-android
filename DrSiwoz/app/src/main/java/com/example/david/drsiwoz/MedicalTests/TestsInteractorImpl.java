package com.example.david.drsiwoz.MedicalTests;

import android.util.Log;

import com.example.david.drsiwoz.Models.Drug;
import com.example.david.drsiwoz.Models.MedicalTest;
import com.example.david.drsiwoz.REST.ApiAuthProvider;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by david on 2016-06-05.
 */
public class TestsInteractorImpl implements TestsInteractor {

    @Override
    public void getTests(final OnGetTestsListener listener, String authToken, String patientId) {
        Call<List<MedicalTest>> call = ApiAuthProvider.getApi(authToken).getTests(patientId);
        call.enqueue(new Callback<List<MedicalTest>>() {
            @Override
            public void onResponse(Call<List<MedicalTest>> call, Response<List<MedicalTest>> response) {
                int statusCode = response.code();
                Log.d("status code", String.valueOf(statusCode));
                if (statusCode != 200) {
                    listener.onError();
                } else {
                    List<MedicalTest> drugs = response.body();
                    listener.onSuccess(drugs);
                }
            }

            @Override
            public void onFailure(Call<List<MedicalTest>> call, Throwable t) {
                Log.d("failure", t.toString());
                listener.onError();
            }
        });
    }


    @Override
    public void requestTest(final OnGetTestsListener listener, String authToken, String patientId, String requestedTestId) {
        Call<List<MedicalTest>> call = ApiAuthProvider.getApi(authToken).requestTest(patientId,requestedTestId);
        call.enqueue(new Callback<List<MedicalTest>>() {
            @Override
            public void onResponse(Call<List<MedicalTest>> call, Response<List<MedicalTest>> response) {
                int statusCode = response.code();
                Log.d("status code", String.valueOf(statusCode));
                if (statusCode != 200) {
                    listener.onError();
                } else {
                    List<MedicalTest> drugs = response.body();
                    listener.onSuccess(drugs);
                }
            }

            @Override
            public void onFailure(Call<List<MedicalTest>> call, Throwable t) {
                Log.d("failure", t.toString());
                listener.onError();
            }
        });
    }
}
