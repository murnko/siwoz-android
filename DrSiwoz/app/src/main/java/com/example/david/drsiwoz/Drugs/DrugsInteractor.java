package com.example.david.drsiwoz.Drugs;

import com.example.david.drsiwoz.Models.Drug;

import java.util.List;

/**
 * Created by jacek on 25.05.16.
 */
public interface DrugsInteractor {
    interface OnGetDrugsListener {
        void onError();

        void onSuccess(List<Drug> drugs);
    }

    void getDrugs(OnGetDrugsListener listener);
}
