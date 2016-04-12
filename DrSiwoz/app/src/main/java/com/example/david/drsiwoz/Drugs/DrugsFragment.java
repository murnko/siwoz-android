package com.example.david.drsiwoz.Drugs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.david.drsiwoz.Models.Drug;
import com.example.david.drsiwoz.R;
import com.example.david.drsiwoz.REST.RequestResult;

import java.util.List;

/**
 * Created by david on 2016-03-19.
 */
public class DrugsFragment extends Fragment implements DrugsView {
    private TextView infoView;
    private ListView listView;
    private Button btGetList;
    private Button btAddItem;
    private Button btDeleteItem;
    private EditText drugID;
    private EditText drugName;
    private EditText drugUnit;
    private EditText drugDose;

    private DrugsPresenter presenter;

    public DrugsFragment() {
        presenter = new DrugsPresenter(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.drugs_fragment, container, false);
        listView = (ListView) rootView.findViewById(R.id.listViewDrugs);
        btGetList = (Button) rootView.findViewById(R.id.buttonUpdate);

        btGetList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    List<Drug> patrols = presenter.onUpdateButtonClick();
                    String[] pointsView = patrols.toArray(new String[patrols.size()]);
                    ArrayAdapter adapterPatrol = new ArrayAdapter<String>(getActivity(), R.layout.drugs_fragment, pointsView);
                    listView = (ListView) rootView.findViewById(R.id.listViewDrugs);
                    listView.setAdapter(adapterPatrol);
                } catch (Exception e) {
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootView;
    }
    @Override
    public void updateDrugsList(List<Drug> drugs){
        Toast.makeText(getActivity(), "update tabeli", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void deleteDrugsResult(RequestResult result) {
        Toast.makeText(getActivity(), result.result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addDrugsResult(RequestResult result) {
        Toast.makeText(getActivity(), result.result, Toast.LENGTH_SHORT).show();
    }

}
