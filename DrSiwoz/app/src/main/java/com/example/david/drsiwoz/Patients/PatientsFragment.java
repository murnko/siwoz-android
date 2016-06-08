package com.example.david.drsiwoz.Patients;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.david.drsiwoz.Models.MedicalTest;
import com.example.david.drsiwoz.Models.UpPatient;
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
    PatientListener mPatientCallback;

    private TextView descriptionTextView;
    private TextView descriptionEditText;
    private Button sendButton;
    private RadioGroup stateRGroup;
    private RadioButton infoButton;
    private RadioButton goodButton;
    private RadioButton careButton;
    private String patientStatus;
    private String authToken;

    private PatientsPresenter presenter;

    public PatientsFragment() {
        presenter = new PatientsPresenter(this);
    }

    public interface PatientListener {
        void onPatientFetchFailedListener();
        String getPatientId();
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

        descriptionEditText = (TextView) rootView.findViewById(R.id.patientStatusDescriptionEditText);
        descriptionTextView = (TextView) rootView.findViewById(R.id.patientStatusDescriptionTextView);

        stateRGroup = (RadioGroup) rootView.findViewById(R.id.radioPatientGroup);
        infoButton = (RadioButton) rootView.findViewById(R.id.info_rb);
        goodButton = (RadioButton) rootView.findViewById(R.id.good_rb);
        careButton = (RadioButton) rootView.findViewById(R.id.care_rb);

        sendButton = (Button) rootView.findViewById(R.id.btSend);
        final Integer checkedColor = getActivity().getResources().getColor(android.R.color.holo_orange_dark);

        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                UpPatient update = new UpPatient(patientStatus, descriptionEditText.getText().toString());
                String patientId = mPatientCallback.getPatientId();
                presenter.updatePatient(authToken, patientId, update);
            }
        });

        stateRGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            View radioButton = stateRGroup.findViewById(checkedId);
            int index = stateRGroup.indexOfChild(radioButton);

            switch (index){
                case 0:
                    descriptionTextView.setVisibility(View.VISIBLE);
                    descriptionEditText.setVisibility(View.INVISIBLE);

                    infoButton.setBackgroundColor(Color.TRANSPARENT);
                    goodButton.setBackgroundColor(checkedColor);
                    careButton.setBackgroundColor(Color.TRANSPARENT);

                    patientStatus = "good";
                    break;
                case 1:
                    descriptionTextView.setVisibility(View.INVISIBLE);
                    descriptionEditText.setVisibility(View.VISIBLE);

                    infoButton.setBackgroundColor(checkedColor);
                    goodButton.setBackgroundColor(Color.TRANSPARENT);
                    careButton.setBackgroundColor(Color.TRANSPARENT);

                    patientStatus = "info";
                    break;
                case 2:
                    descriptionTextView.setVisibility(View.INVISIBLE);
                    descriptionEditText.setVisibility(View.VISIBLE);

                    infoButton.setBackgroundColor(Color.TRANSPARENT);
                    goodButton.setBackgroundColor(Color.TRANSPARENT);
                    careButton.setBackgroundColor(checkedColor);

                    patientStatus = "care";
                    break;
            }
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mPatientCallback = (PatientListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnMenuItemSelectedListener");
        }
    }

    @Override
    public void resetPatientId() {
        mPatientCallback.onPatientFetchFailedListener();
    }

    @Override
    public void showPatient(Patient patient) {
        nameTextView.setText(patient.getName());
        releaseDateTextView.setText(patient.getReleaseDate());
        acceptanceDateTextView.setText(patient.getAcceptanceDate());
        peselTextView.setText(patient.getPesel());
    }

    @Override
    public void cleanPatientStatus() {
        descriptionEditText.setText(new String(""));
    }

//    @Override
//    public void showExamination(MedicalTest medicalTest) {
//        examinationDateTextView.setText(medicalTest.getCreated());
//        examinationDoctorTextView.setText(medicalTest.getDoctorName());
//        examinationDescriptionTextView.setText(medicalTest.getDescription());
//        String status = medicalTest.getStatus();
//        if (status.equals("i")) {
//            examinationDescriptionTextView.setTextColor(Color.BLUE);
//        } else if (status.equals("g")) {
//            examinationDescriptionTextView.setTextColor(Color.GREEN);
//        } else if (status.equals("c")) {
//            examinationDescriptionTextView.setTextColor(Color.CYAN);
//        }
//    }

    public void getPatient(String authToken, String patientId) {
        this.presenter.getPatient(authToken, patientId);
    }

//    public void getExamination(String authToken, String patientId) {
//        this.presenter.getExamination(authToken, patientId);
//    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
