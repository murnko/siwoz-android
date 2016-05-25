package com.example.david.drsiwoz.Drugs;

import android.util.Log;

import com.example.david.drsiwoz.Models.Drug;
import com.example.david.drsiwoz.REST.ApiProvider;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jacek on 25.05.16.
 */
public class DrugsInteractorImpl implements DrugsInteractor {
    @Override
    public void getDrugs(final OnGetDrugsListener listener) {
        Log.d("get Drugs", "started");
        Call<List<Drug>> call = ApiProvider.getApi().getDrugs();
        call.enqueue(new Callback<List<Drug>>() {
            @Override
            public void onResponse(Call<List<Drug>> call, Response<List<Drug>> response) {
                int statusCode = response.code();
                Log.d("status code", String.valueOf(statusCode));
                if (statusCode != 200) {
                    listener.onError();
                } else {
                    List<Drug> drugs = response.body();
                    listener.onSuccess(drugs);
                }
            }

            @Override
            public void onFailure(Call<List<Drug>> call, Throwable t) {
                Log.d("failure", t.toString());
                listener.onError();
            }
        });
    }
}
