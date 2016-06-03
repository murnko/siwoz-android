package com.example.david.drsiwoz.Drugs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.david.drsiwoz.MainActivity;
import com.example.david.drsiwoz.Models.Drug;
import com.example.david.drsiwoz.R;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 2016-03-19.
 */
public class DrugsFragment extends Fragment implements DrugsView {
    private ListView listView;
    private DrugsListViewAdapter adapter;
    private Button applyButton;

    private DrugsPresenter presenter;

    public DrugsFragment() {
        presenter = new DrugsPresenterImpl(this);
    }


    public void getDrugs(String authToken) {
        presenter.getDrugs(authToken);
    }
    public void applyDrug(String authToken, String appliedDrugId){
        presenter.applyDrug(authToken, appliedDrugId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.drugs_fragment, container, false);
        listView = (ListView) rootView.findViewById(R.id.listViewDrugs);
        applyButton = (Button) rootView.findViewById(R.id.applyBtn);
        List<Drug> mockDrugsList = new ArrayList<>();
        adapter = new DrugsListViewAdapter(getActivity(), mockDrugsList);
        listView.setAdapter(adapter);


        applyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.onScanInitiated(21);


            }
        });

        return rootView;
    }



    @Override
    public void showDrugsList(List<Drug> drugs) {
        adapter.clear();
        adapter.addAll(drugs);
        adapter.notifyDataSetChanged();
        Log.d("DrugsFragment", "Show drugs");
    }



    @Override
    public void displayGetDrugsError() {
        Log.d("DrugsFragment", "Error");
    }

}
