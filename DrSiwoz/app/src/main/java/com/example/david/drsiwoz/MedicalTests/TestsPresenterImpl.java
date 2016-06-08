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
        this.testsInteractor = testsInteractor;
    }

    @Override
    public void getTests(String authToken) {
        testsInteractor.getTests( this, authToken);
    }

    @Override
    public void requestTest(String authToken, String requestedTestId) {
        testsInteractor.requestTest(this,authToken, requestedTestId);

    }

    @Override
    public void onError() {

    }

    @Override
    public void onSuccess(List<MedicalTest> tests) {

    }

}




