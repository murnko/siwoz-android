package com.example.david.drsiwoz.MedicalTests;

import com.example.david.drsiwoz.Models.MedicalTest;

import java.util.List;

/**
 * Created by david on 2016-06-05.
 */
public class TestsPresenterImpl implements TestsPresenter, TestsInteractor.OnGetTestsListener {

    private TestsView testsView;
    private TestsInteractor testsInteractor;




    public TestsPresenterImpl(TestsView testsView){
        this.testsView = testsView;
        this.testsInteractor = new TestsInteractorImpl();
    }

    @Override
    public void getTests(String authToken, String patientId) {
        testsInteractor.getTests( this, authToken, patientId);
    }

    @Override
    public void requestTest(String authToken,String patientId, String requestedTestId) {
        testsInteractor.requestTest(this,authToken,patientId, requestedTestId);

    }

    @Override
    public void onError() {

    }

    @Override
    public void onSuccess(List<MedicalTest> tests) {

    }

}




