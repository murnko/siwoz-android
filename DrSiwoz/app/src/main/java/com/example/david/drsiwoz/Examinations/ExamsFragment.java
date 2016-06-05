package com.example.david.drsiwoz.Examinations;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.david.drsiwoz.Drugs.DrugsListViewAdapter;
import com.example.david.drsiwoz.Models.Drug;
import com.example.david.drsiwoz.Models.Examination;
import com.example.david.drsiwoz.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 2016-06-05.
 */
public class ExamsFragment extends Fragment implements ExamsView {
    private ListView listView;
    private ExamsListViewAdapter adapter;

    private ExamsPresenter presenter;

    public ExamsFragment(){
        presenter = new ExamsPresenterImpl(this);
    }

    public void getExams(String authToken){presenter.getExams(authToken);}
    public void RequestExam (String authToken, String requestedExamId){presenter.requestExam(authToken, requestedExamId);}

    @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState){
        final View rootView = inflater.inflate(R.layout.exams_fragment, container, false);
        listView = (ListView) rootView.findViewById(R.id.examsListView);
        Button requestExamButton = (Button) rootView.findViewById(R.id.requestExamButton);
        Spinner spinner = (Spinner) rootView.findViewById(R.id.examSpinner);
        List<Examination> examsList = new ArrayList<>();
        adapter = new ExamsListViewAdapter(getActivity(), examsList);
        listView.setAdapter(adapter);

        return rootView;
    }







    @Override
    public void showExamsList(List<Examination> exams) {
        adapter.clear();
        adapter.addAll(exams);
        adapter.notifyDataSetChanged();
        Log.d("DrugsFragment", "Show drugs");

    }

}
