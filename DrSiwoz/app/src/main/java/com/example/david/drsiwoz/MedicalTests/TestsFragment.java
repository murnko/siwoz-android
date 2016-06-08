package com.example.david.drsiwoz.MedicalTests;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.david.drsiwoz.Models.MedicalTest;
import com.example.david.drsiwoz.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 2016-06-05.
 */
public class TestsFragment extends Fragment implements TestsView {
    private ListView listView;
    private TestsListViewAdapter adapter;

    private TestsPresenter presenter;

    public TestsFragment(){
        presenter = new TestsPresenterImpl(this);
    }

    public void getTests(String authToken){presenter.getTests(authToken);}
    public void requestTest(String authToken, String requestedTestId){presenter.requestTest(authToken, requestedTestId);}

    @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState){
        final View rootView = inflater.inflate(R.layout.medTests_fragment, container, false);
        listView = (ListView) rootView.findViewById(R.id.testsListView);
        Button requestTestButton = (Button) rootView.findViewById(R.id.requestTestButton);
        Spinner spinner = (Spinner) rootView.findViewById(R.id.testsSpinner);
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

}
