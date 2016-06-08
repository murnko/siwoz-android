package com.example.david.drsiwoz.MedicalTests;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Spinner;

import static android.R.layout.*;

import com.example.david.drsiwoz.MainActivity;
import com.example.david.drsiwoz.Models.MedicalTest;
import com.example.david.drsiwoz.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 2016-06-05.
 */
public class TestsFragment extends Fragment implements TestsView,AdapterView.OnItemSelectedListener {
    private ExpandableListView listView;
    private String itemSpinnerSelected;
    private List<MedicalTest> tests;
    TestsListViewAdapter testsAdapter;

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
        testsAdapter = new TestsListViewAdapter(getActivity(), tests);
        listView.setAdapter(testsAdapter);

        Button requestTestButton = (Button) rootView.findViewById(R.id.requestTestButton);

        Spinner spinner = (Spinner) rootView.findViewById(R.id.testsSpinner);
        spinner.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        List<String> categories = new ArrayList<>();
        categories.add("Krew A");
        categories.add("Krew B");
        categories.add("Krew C");
        categories.add("Mocz");
        categories.add("Głowa");
        categories.add("Nogi");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getActivity(), simple_spinner_item, categories );
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        requestTestButton.setOnClickListener(new View.OnClickListener() { @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                requestTest(activity.getauthToken(),activity.getPatientId(),itemSpinnerSelected);
            }
        });

        return rootView;
    }

    @Override
    public void showTestsList(List<MedicalTest> tests) {
        this.tests = tests;
        if (this.testsAdapter == null) {
            this.testsAdapter = new TestsListViewAdapter(getActivity(), tests);
        }
        this.testsAdapter.notifyDataSetChanged();
        this.testsAdapter.notifyDataSetInvalidated();
        Log.d("DrugsFragment", "show tests list");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        itemSpinnerSelected = parent.getItemAtPosition(i).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
