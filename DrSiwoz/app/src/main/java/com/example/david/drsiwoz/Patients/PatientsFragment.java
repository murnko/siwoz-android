package com.example.david.drsiwoz.Patients;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.david.drsiwoz.R;
import com.example.david.drsiwoz.Models.Patient;

/**
 * Created by david on 2016-03-19.
 */
public class PatientsFragment extends Fragment implements PatientsView {

    private TextView nameTextView;
    private TextView surnameTextView;
    OnPatientFetchFailedListener mOnPatientFetchFailedCallback;

    private PatientsPresenter presenter;

    public PatientsFragment() {
        presenter = new PatientsPresenter(this);
    }

    public interface OnPatientFetchFailedListener {
        void onPatientFetchFailedListener();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.patients_fragment, container, false);
        nameTextView = (TextView) rootView.findViewById(R.id.nameTextView);
        surnameTextView = (TextView) rootView.findViewById(R.id.surnameTextView);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mOnPatientFetchFailedCallback = (OnPatientFetchFailedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnMenuItemSelectedListener");
        }
    }

    @Override
    public void resetPatientId() {
        mOnPatientFetchFailedCallback.onPatientFetchFailedListener();
    }

    @Override
    public void showPatient(Patient patient) {
        nameTextView.setText(patient.getName());
        surnameTextView.setText(patient.getSurname());
    }

    public void getPatient(String authToken, String patientId) {
        this.presenter.getPatient(authToken, patientId);
    }

}
