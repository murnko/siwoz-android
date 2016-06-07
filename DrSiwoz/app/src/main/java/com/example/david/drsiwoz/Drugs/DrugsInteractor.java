package com.example.david.drsiwoz.Drugs;

import com.example.david.drsiwoz.Models.Drug;
import com.example.david.drsiwoz.Models.Serving;
import com.example.david.drsiwoz.Models.UpServings;

import java.util.List;

/**
 * Created by jacek on 25.05.16.
 */
public interface DrugsInteractor {
    interface OnGetDrugsListener {

        void onError();
        void onSuccess(List<Serving> servings);

    }


    void getServings(OnGetDrugsListener listener, String authToken, String patientId);
    void applyDrug(OnGetDrugsListener listener, String authToken,String patientId, String appliedDrugId);
    void updateServings(OnGetDrugsListener listener, String authToken, UpServings upServingsList);
}
