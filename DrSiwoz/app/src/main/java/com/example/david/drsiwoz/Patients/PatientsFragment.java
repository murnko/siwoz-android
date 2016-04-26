package com.example.david.drsiwoz.Patients;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



import com.example.david.drsiwoz.R;
import com.example.david.drsiwoz.Models.Patient;
import com.example.david.drsiwoz.REST.RequestResult;


import java.util.List;

/**
 * Created by david on 2016-03-19.
 */
public class PatientsFragment extends Fragment implements PatientsView {

    private TextView infoView;
    private ListView listView;
    private Button btGetList;
    private Button btAddItem;
    private Button btDeleteItem;


    private PatientsPresenter presenter;

    public PatientsFragment() {
        presenter = new PatientsPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.patients_fragment, container, false);
        listView = (ListView) rootView.findViewById(R.id.lvReport);
        btGetList = (Button) rootView.findViewById(R.id.btSend);



        return rootView;
    }

    @Override
    public void updatePatient(Patient patient) {
        Toast.makeText(getActivity(), "update info", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addPatientsResult(RequestResult result) {
        Toast.makeText(getActivity(), result.result, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void deletePatientsResult(RequestResult result) {
        Toast.makeText(getActivity(), result.result, Toast.LENGTH_SHORT).show();
    }


}
