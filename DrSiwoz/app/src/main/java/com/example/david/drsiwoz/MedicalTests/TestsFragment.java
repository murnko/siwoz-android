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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import static android.R.layout.*;

import com.example.david.drsiwoz.Models.MedicalTest;
import com.example.david.drsiwoz.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 2016-06-05.
 */
public class TestsFragment extends Fragment implements TestsView,AdapterView.OnItemSelectedListener {
    private ListView listView;
    private TestsListViewAdapter adapter;

    private TestsPresenter presenter;

    public TestsFragment(){
        presenter = new TestsPresenterImpl(this);
    }

    public void getTests(String authToken, String patientId){presenter.getTests(authToken, patientId);}
    public void requestTest(String authToken,String patientId, String requestedTestId){presenter.requestTest(authToken, patientId, requestedTestId);}

    @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState){
        final View rootView = inflater.inflate(R.layout.medtests_fragment, container, false);
        listView = (ListView) rootView.findViewById(R.id.testsListView);
        Button requestTestButton = (Button) rootView.findViewById(R.id.requestTestButton);
        Spinner spinner = (Spinner) rootView.findViewById(R.id.testsSpinner);
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<>();
        categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getActivity(), simple_spinner_item, categories );

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        List<MedicalTest> testsList = new ArrayList<>();
        adapter = new TestsListViewAdapter(getActivity(), testsList);
        listView.setAdapter(adapter);

        return rootView;
    }







    @Override
    public void showTestsList(List<MedicalTest> tests) {
        adapter.clear();
        adapter.addAll(tests);
        adapter.notifyDataSetChanged();
        Log.d("DrugsFragment", "Show drugs");

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(i).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
