package com.example.david.drsiwoz.Patients;

import com.example.david.drsiwoz.Models.MedicalTest;
import com.example.david.drsiwoz.Models.Patient;

/**
 * Created by david on 2016-03-19.
 */
public interface PatientsView {
    void resetPatientId();
    void showPatient(Patient patient);
    void cleanPatientStatus();
    //void showExamination(MedicalTest medicalTest);
}
