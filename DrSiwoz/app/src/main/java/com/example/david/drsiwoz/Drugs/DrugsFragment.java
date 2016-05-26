package com.example.david.drsiwoz.Drugs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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

    private DrugsPresenter presenter;

    public DrugsFragment() {
        presenter = new DrugsPresenterImpl(this);
    }

    public void getDrugs() {
        presenter.getDrugs();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.drugs_fragment, container, false);
        listView = (ListView) rootView.findViewById(R.id.listViewDrugs);

        List<Drug> mockDrugsList = new ArrayList<>();
        adapter = new DrugsListViewAdapter(getActivity(), mockDrugsList);
        listView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void showDrugsList(List<Drug> drugs) {
        adapter.clear();
        adapter.addAll(drugs);
        adapter.notifyDataSetChanged();
        Log.d("DrugsFragment", "SHow drugs");
    }

    @Override
    public void displayGetDrugsError() {
        Log.d("DrugsFragment", "Error");
    }
}
