package com.example.david.drsiwoz.Examinations;

import com.example.david.drsiwoz.Models.Drug;
import com.example.david.drsiwoz.Models.Examination;

import java.util.List;

/**
 * Created by david on 2016-06-05.
 */
public class ExamsPresenterImpl implements ExamsPresenter, ExamsInteractor.OnGetExamsListener {

    private ExamsView examsView;
    private ExamsInteractor examsInteractor;




    public ExamsPresenterImpl(ExamsView examsView){
        this.examsView = examsView;
        this.examsInteractor = examsInteractor;
    }

    @Override
    public void getExams(String authToken) {
        examsInteractor.getExams( this, authToken);
    }

    @Override
    public void requestExam(String authToken, String requestedExamId) {
        examsInteractor.requestExam(this,authToken,requestedExamId);

    }

    @Override
    public void onError() {

    }

    @Override
    public void onSuccess(List<Examination> exams) {

    }

}




