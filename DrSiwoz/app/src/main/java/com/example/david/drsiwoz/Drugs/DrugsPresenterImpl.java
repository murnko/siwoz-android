package com.example.david.drsiwoz.Drugs;

import com.example.david.drsiwoz.Models.Serving;
import com.example.david.drsiwoz.Models.UpServings;

import java.util.List;

/**
 * Created by jacek on 25.05.16.
 */
public class DrugsPresenterImpl implements DrugsPresenter, DrugsInteractor.OnGetDrugsListener {

    private DrugsInteractor drugsInteractor;
    private DrugsView drugsView;

    public DrugsPresenterImpl(DrugsView drugsView) {
        this.drugsView = drugsView;
        this.drugsInteractor = new DrugsInteractorImpl();
    }

    @Override
    public void getServings(String authToken, String patientId) {
        drugsInteractor.getServings(this, authToken, patientId);
    }

    @Override
    public void applyDrug(String authToken,String patientId, String appliedDrugId) {
        drugsInteractor.applyDrug(this, authToken,patientId, appliedDrugId);

    }

    @Override
    public void updateServings(String authToken, String patientID, UpServings upServingsList) {

    }

    @Override
    public void onError() {
       drugsView.displayGetDrugsError();
    }

    @Override
    public void onSuccess(List<Serving> servings) {
        drugsView.showDrugsList(servings);
    }
}
