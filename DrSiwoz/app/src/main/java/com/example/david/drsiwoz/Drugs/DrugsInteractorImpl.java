package com.example.david.drsiwoz.Drugs;

import android.util.Log;

import com.example.david.drsiwoz.Models.Drug;
import com.example.david.drsiwoz.REST.ApiAuthProvider;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jacek on 25.05.16.
 */
public class DrugsInteractorImpl implements DrugsInteractor {
    @Override
    public void getDrugs(final OnGetDrugsListener listener, String authToken) {
        Log.d("get Drugs", "started");
        Call<List<Drug>> call = ApiAuthProvider.getApi(authToken).getDrugs();
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

    @Override
    public void applyDrug(OnGetDrugsListener listener, String authToken, String appliedDrugId) {
        Call<ResponseBody> call = ApiAuthProvider.getApi(authToken).applyDrug(appliedDrugId);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call call, Response response) {
                int statusCode = response.code();
                if (statusCode == 200) {
                    Log.d("code", "OK200");
                } else {
                    Log.d("code", "not 200");
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("bb", t.toString());
                Log.d("bb", "onFailureDrugAplly");
            }
        });
    }

}
