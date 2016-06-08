package com.example.david.drsiwoz.Drugs;

import android.util.Log;

import com.example.david.drsiwoz.MainActivity;
import com.example.david.drsiwoz.Models.Drug;
import com.example.david.drsiwoz.Models.Serving;
import com.example.david.drsiwoz.Models.UpServings;
import com.example.david.drsiwoz.Patients.PatientsFragment;
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
    public void getServings(final OnGetDrugsListener listener,String authToken,String patientId) {

        Log.d("get Drugs", "started");
        Call<List<Serving>> call = ApiAuthProvider.getApi(authToken).getServings(patientId);
        call.enqueue(new Callback<List<Serving>>() {
            @Override
            public void onResponse(Call<List<Serving>> call, Response<List<Serving>> response) {
                int statusCode = response.code();
                Log.d("status code", String.valueOf(statusCode));
                if (statusCode != 200) {
                    listener.onError();
                } else {
                    List<Serving> servings = response.body();
                    listener.onSuccess(servings);
                }
            }


            @Override
            public void onFailure(Call<List<Serving>> call, Throwable t) {
                Log.d("failure", t.toString());
                listener.onError();
            }
        });
    }

    @Override
    public void applyDrug(final OnGetDrugsListener listener, String authToken,String patientId, String appliedDrugId) {


        Call<List<Serving>> call = ApiAuthProvider.getApi(authToken).applyDrug(patientId, appliedDrugId);
        call.enqueue(new Callback<List<Serving>>() {
            @Override
            public void onResponse(Call<List<Serving>> call, Response<List<Serving>> response) {
                int statusCode = response.code();
                Log.d("status code", String.valueOf(statusCode));
                if (statusCode != 200) {
                    listener.onError();
                } else {
                    List<Serving> servings = response.body();
                    listener.onSuccess(servings);
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("bb", t.toString());
                Log.d("bb", "onFailureDrugUpdate");
            }
        });
    }


    @Override
    public void updateServings(final OnGetDrugsListener listener, String authToken,String patientId, UpServings upServingsList) {
        Call<List<Serving>> call = ApiAuthProvider.getApi(authToken).updateServing(patientId, upServingsList);
        call.enqueue(new Callback<List<Serving>>() {
            @Override
            public void onResponse(Call<List<Serving>> call, Response<List<Serving>> response) {
                int statusCode = response.code();
                Log.d("status code", String.valueOf(statusCode));
                if (statusCode != 200) {
                    listener.onError();
                } else {
                    List<Serving> servings = response.body();
                    listener.onSuccess(servings);
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("bb", t.toString());
                Log.d("bb", "onFailureDrugUpdate");
            }
        });
    }

}
