package com.example.david.drsiwoz.Patients;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.david.drsiwoz.Models.Examination;
import com.example.david.drsiwoz.R;
import com.example.david.drsiwoz.Models.Patient;

/**
 * Created by david on 2016-03-19.
 */
public class PatientsFragment extends Fragment implements PatientsView {

    private TextView nameTextView;
    private TextView acceptanceDateTextView;
    private TextView releaseDateTextView;
    private TextView peselTextView;
    private TextView examinationDescriptionTextView;
    private TextView examinationDoctorTextView;
    private TextView examinationDateTextView;
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
        acceptanceDateTextView = (TextView) rootView.findViewById(R.id.acceptanceDateTextView);
        releaseDateTextView = (TextView) rootView.findViewById(R.id.releaseDateTextView);
        peselTextView = (TextView) rootView.findViewById(R.id.peselTextView);
        examinationDateTextView = (TextView) rootView.findViewById(R.id.examinationDateTextView);
        examinationDoctorTextView = (TextView) rootView.findViewById(R.id.examinationDoctorTextView);
        examinationDescriptionTextView = (TextView) rootView.findViewById(R.id.examinationDescriptionTextView);

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
        releaseDateTextView.setText(patient.getReleaseDate());
        acceptanceDateTextView.setText(patient.getAcceptanceDate());
        peselTextView.setText(patient.getPesel());
    }

    @Override
    public void showExamination(Examination examination) {
        examinationDateTextView.setText(examination.getCreated());
        examinationDoctorTextView.setText(examination.getDoctorName());
        examinationDescriptionTextView.setText(examination.getDescription());
        String status = examination.getStatus();
        if (status.equals("i")) {
            examinationDescriptionTextView.setTextColor(Color.BLUE);
        } else if (status.equals("g")) {
            examinationDescriptionTextView.setTextColor(Color.GREEN);
        } else if (status.equals("c")) {
            examinationDescriptionTextView.setTextColor(Color.CYAN);
        }
    }

    public void getPatient(String authToken, String patientId) {
        this.presenter.getPatient(authToken, patientId);
    }

    public void getExamination(String authToken, String patientId) {
        this.presenter.getExamination(authToken, patientId);
    }
}
