package com.example.david.drsiwoz.Examinations;

import com.example.david.drsiwoz.Models.Examination;

import java.util.List;

/**
 * Created by david on 2016-06-05.
 */
public interface ExamsInteractor {
    interface OnGetExamsListener {
        void onError();

        void onSuccess(List<Examination> exams);
    }

    void getExams(OnGetExamsListener listener, String authToken);
    void requestExam(OnGetExamsListener listener, String authToken, String appliedDrugId);
}
