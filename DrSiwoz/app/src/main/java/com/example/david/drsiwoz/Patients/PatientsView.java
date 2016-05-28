package com.example.david.drsiwoz.Patients;

import com.example.david.drsiwoz.Models.Patient;
import com.example.david.drsiwoz.REST.RequestResult;

/**
 * Created by david on 2016-03-19.
 */
public interface PatientsView {
    public void resetPatientId();
    public void showPatient(Patient patient);
}
