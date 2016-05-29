package com.example.david.drsiwoz.Patients;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    private TextView descriptionTextView;
    private TextView descriptionEditText;
    private Button postButton;
    private Button sendButton;
    private RadioGroup stateRGroup;
    private RadioButton infoButton;
    private RadioButton goodButton;
    private RadioButton careButton;

    private PatientsPresenter presenter;

    public PatientsFragment() {
        presenter = new PatientsPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.patients_fragment, container, false);
        nameTextView = (TextView) rootView.findViewById(R.id.nameTextView);
        surnameTextView = (TextView) rootView.findViewById(R.id.surnameTextView);
        descriptionTextView = (TextView) rootView.findViewById(R.id.tvDescr);
        descriptionEditText = (EditText) rootView.findViewById(R.id.txtPatDescr);

        stateRGroup = (RadioGroup) rootView.findViewById(R.id.radioPatientGroup);
        infoButton = (RadioButton) rootView.findViewById(R.id.info_rb);
        goodButton = (RadioButton) rootView.findViewById(R.id.good_rb);
        careButton = (RadioButton) rootView.findViewById(R.id.care_rb);

        sendButton = (Button) rootView.findViewById(R.id.btSend);
        postButton = (Button) rootView.findViewById(R.id.btPost);

        final Integer checkedColor = getActivity().getResources().getColor(android.R.color.holo_orange_dark);


        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getPatient("0");
            }

        });

        stateRGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                View radioButton = stateRGroup.findViewById(checkedId);
                int index = stateRGroup.indexOfChild(radioButton);
                postButton.setVisibility(View.VISIBLE);
                sendButton.setVisibility(View.INVISIBLE);

                switch (index){

                    case 0:

                        descriptionTextView.setVisibility(View.INVISIBLE);
                        descriptionEditText.setVisibility(View.VISIBLE);

                        infoButton.setBackgroundColor(checkedColor);
                        goodButton.setBackgroundColor(Color.TRANSPARENT);
                        careButton.setBackgroundColor(Color.TRANSPARENT);
                        break;
                    case 1:
                        descriptionTextView.setVisibility(View.VISIBLE);
                        descriptionEditText.setVisibility(View.INVISIBLE);

                        infoButton.setBackgroundColor(Color.TRANSPARENT);
                        goodButton.setBackgroundColor(checkedColor);
                        careButton.setBackgroundColor(Color.TRANSPARENT);
                        break;
                    case 2:
                        descriptionTextView.setVisibility(View.INVISIBLE);
                        descriptionEditText.setVisibility(View.VISIBLE);

                        infoButton.setBackgroundColor(Color.TRANSPARENT);
                        goodButton.setBackgroundColor(Color.TRANSPARENT);
                        careButton.setBackgroundColor(checkedColor);
                        break;

                }

            }
        });


        return rootView;
    }


    public void getPatient(final String patientId) {
        Call<Patient> call = ApiProvider.getApi().getPatient(patientId);
        call.enqueue(new Callback<Patient>() {
            @Override
            public void onResponse(Call<Patient> call, Response<Patient> response) {
                int statusCode = response.code();
                if (statusCode != 200) {
                    Log.d("code", "not 200");
                } else {
                    Patient patient = response.body();
                    if (nameTextView != null){
                        nameTextView.setText(patient.getName());
                        surnameTextView.setText(patient.getSurname());
                        descriptionTextView.setText(patient.getDescription());

                    }
                    else {
                        System.out.println("Imię pacjenta: " + patient.getName());
                    }
                }
            }

            @Override
            public void onFailure(Call<Patient> call, Throwable t) {
                Log.d("bb", t.toString());
                Log.d("bb", "onFailure: dupa");
            }
        });
    }


}
