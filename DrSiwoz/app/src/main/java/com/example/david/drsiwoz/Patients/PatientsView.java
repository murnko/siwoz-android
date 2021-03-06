package com.example.david.drsiwoz.Patients;

import com.example.david.drsiwoz.Models.Patient;
import com.example.david.drsiwoz.REST.RequestResult;

/**
 * Created by david on 2016-03-19.
 */
public interface PatientsView {
    void updatePatient(Patient patient);
    void addPatientsResult(RequestResult result);
    void deletePatientsResult(RequestResult result);
}
