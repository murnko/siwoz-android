package com.example.david.drsiwoz.Drugs;

import com.example.david.drsiwoz.Models.Drug;

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
    public void getDrugs(String authToken) {
        drugsInteractor.getDrugs(this, authToken);
    }

    @Override
    public void onError() {
       drugsView.displayGetDrugsError();
    }

    @Override
    public void onSuccess(List<Drug> drugs) {
        drugsView.showDrugsList(drugs);
    }
}
