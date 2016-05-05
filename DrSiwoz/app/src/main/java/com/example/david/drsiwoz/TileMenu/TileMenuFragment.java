package com.example.david.drsiwoz.TileMenu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.david.drsiwoz.R;


public class TileMenuFragment extends Fragment implements TileMenuView{
    private ImageButton patientButton;
    private ImageButton drugsButton;
    private ImageButton specialistReportsButton;

    private TileMenuPresenter presenter;

    public TileMenuFragment() {
        presenter = new TileMenuPresenter(this);
    }

    OnMenuItemSelectedListener mCallback;

    public interface OnMenuItemSelectedListener {
        public void onMenuItemSelected(int position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (OnMenuItemSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnMenuItemSelectedListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_tile_menu, container, false);
        patientButton = (ImageButton) rootView.findViewById(R.id.patientButton);
        drugsButton = (ImageButton) rootView.findViewById(R.id.drugsButton);
        specialistReportsButton = (ImageButton) rootView.findViewById(R.id.specialistReportsButton);

        patientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onMenuItemSelected(1);
            }
        });

        drugsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onMenuItemSelected(2);
            }
        });

//        btGetList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    List<Drug> patrols = presenter.onUpdateButtonClick();
//                    String[] pointsView = patrols.toArray(new String[patrols.size()]);
//                    ArrayAdapter adapterPatrol = new ArrayAdapter<String>(getActivity(), R.layout.drugs_fragment, pointsView);
//                    listView = (ListView) rootView.findViewById(R.id.listViewDrugs);
//                    listView.setAdapter(adapterPatrol);
//                } catch (Exception e) {
//                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        return rootView;
    }
}
