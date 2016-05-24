package com.example.david.drsiwoz.Patients;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



import com.example.david.drsiwoz.R;
import com.example.david.drsiwoz.Models.Patient;
import com.example.david.drsiwoz.REST.ApiProvider;
import com.example.david.drsiwoz.REST.RequestResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by david on 2016-03-19.
 */
public class PatientsFragment extends Fragment implements PatientsView {

    private TextView nameTextView;
    private TextView surnameTextView;
    private TextView infoView;
    private ListView listView;
    private Button btGetList;


    private PatientsPresenter presenter;

    public PatientsFragment() {
        presenter = new PatientsPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.patients_fragment, container, false);
        listView = (ListView) rootView.findViewById(R.id.lvReport);
        btGetList = (Button) rootView.findViewById(R.id.btSend);
        nameTextView = (TextView) rootView.findViewById(R.id.nameTextView);
        surnameTextView = (TextView) rootView.findViewById(R.id.surnameTextView);


        return rootView;
    }

    public void getPatient(String patientId) {
        Call<Patient> call = ApiProvider.getApi().getPatient(patientId);
        call.enqueue(new Callback<Patient>() {
            @Override
            public void onResponse(Call<Patient> call, Response<Patient> response) {
                int statusCode = response.code();
                if (statusCode != 200) {
                    Log.d("code", "not 200");
                } else {
                    Patient patient = response.body();
                    nameTextView.setText(patient.getName());
                    surnameTextView.setText(patient.getSurname());
                }
            }

            @Override
            public void onFailure(Call<Patient> call, Throwable t) {
                Log.d("bb", t.toString());
                Log.d("bb", "onFailure: dupa");
            }
        });
    }

    @Override
    public void updatePatient(Patient patient) {
        Toast.makeText(getActivity(), "update info", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addPatientsResult(RequestResult result) {
        Toast.makeText(getActivity(), result.result, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void deletePatientsResult(RequestResult result) {
        Toast.makeText(getActivity(), result.result, Toast.LENGTH_SHORT).show();
    }


}
