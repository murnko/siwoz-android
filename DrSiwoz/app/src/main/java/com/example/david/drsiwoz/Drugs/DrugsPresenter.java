package com.example.david.drsiwoz.Drugs;

import com.example.david.drsiwoz.Models.Serving;
import com.example.david.drsiwoz.Models.UpServings;

import java.util.List;

/**
 * Created by david on 2016-03-19.
 */
public interface DrugsPresenter {
    void getServings(String authToken,String patientId);
    void applyDrug(String authToken,String patientId,String appliedDrugId);
    void updateServings(String authToken, String patientID, UpServings upServingsList);
    void onSuccess(List<Serving> servings);
}
