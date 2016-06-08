package com.example.david.drsiwoz.MedicalTests;

import com.example.david.drsiwoz.Models.MedicalTest;

import java.util.List;

/**
 * Created by david on 2016-06-05.
 */
public interface TestsInteractor {
    interface OnGetTestsListener {
        void onError();

        void onSuccess(List<MedicalTest> tests);
    }

    void getTests(OnGetTestsListener listener, String authToken, String patientId);
    void requestTest(OnGetTestsListener listener, String authToken,String patientId, String requestedTestId);
}
