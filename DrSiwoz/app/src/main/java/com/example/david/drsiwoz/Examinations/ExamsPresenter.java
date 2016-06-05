package com.example.david.drsiwoz.Examinations;

/**
 * Created by david on 2016-06-05.
 */
public interface ExamsPresenter {
        void getExams(String authToken);
        void requestExam(String authToken, String requestedExamId);
    }
