package com.example.david.drsiwoz.MedicalTests;

/**
 * Created by david on 2016-06-05.
 */
public interface TestsPresenter {
        void getTests(String authToken, String patientId);
        void requestTest(String authToken,String patientId, String requestedTestId);
    }
