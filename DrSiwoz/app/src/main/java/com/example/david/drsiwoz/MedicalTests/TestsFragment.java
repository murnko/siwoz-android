package com.example.david.drsiwoz.MedicalTests;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Spinner;

import com.example.david.drsiwoz.Models.MedicalTest;
import com.example.david.drsiwoz.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 2016-06-05.
 */
public class TestsFragment extends Fragment implements TestsView {
    private ExpandableListView listView;
    private TestsListViewAdapter adapter;

    private TestsPresenter presenter;

    public TestsFragment(){
        presenter = new TestsPresenterImpl(this);
    }

    public void getTests(String authToken, String patientId){presenter.getTests(authToken, patientId);}
    public void requestTest(String authToken,String patientId, String requestedTestId){presenter.requestTest(authToken, patientId, requestedTestId);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View rootView = inflater.inflate(R.layout.medtests_fragment, container, false);
        listView = (ExpandableListView) rootView.findViewById(R.id.medicalTestExpandableListView);
        Button requestTestButton = (Button) rootView.findViewById(R.id.requestTestButton);
        Spinner spinner = (Spinner) rootView.findViewById(R.id.testsSpinner);
        List<MedicalTest> testsList = new ArrayList<>();

        showTestsList();
        listView.setAdapter(adapter);

        return rootView;
    }

    public void showTestsList() {
        ArrayList myPair = new ArrayList<>();
        myPair.add(new Pair<>("param", "value"));
        myPair.add(new Pair<>("param", "value"));
        myPair.add(new Pair<>("param", "value"));
        myPair.add(new Pair<>("param", "value"));
        myPair.add(new Pair<>("param", "value"));
        MedicalTest test = new MedicalTest(
                new String("quite good"),
                new String("Michael"),
                new String("Douglas"),
                new String("2016-05-30"),
                new String("done"),
                myPair
        );
        ArrayList listDataChild = new ArrayList<MedicalTest>();
        listDataChild.add(test);

        adapter = new TestsListViewAdapter(getActivity(), listDataChild);
        Log.d("DrugsFragment", "Show drugs");
    }

    @Override
    public void showTestsList(List<MedicalTest> tests) {

    }
}
