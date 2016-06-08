package com.example.david.drsiwoz.TileMenu;

import android.app.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;

import com.example.david.drsiwoz.R;



public class TileMenuFragment extends Fragment implements TileMenuView{
    private ImageButton patientButton;
    private ImageButton drugsButton;
    private ImageButton specialistReportsButton;
    private ImageButton medTestsButton;
    private ImageButton scanButton;

    private TileMenuPresenter presenter;

    public TileMenuFragment() {
        presenter = new TileMenuPresenter(this);
    }

    OnMenuItemSelectedListener mMenuItemSelectedCallback;
    onScanInitiatedListener mScanInitiatedCallback;

    public interface OnMenuItemSelectedListener {
        public void onMenuItemSelected(int position);
    }

    public interface onScanInitiatedListener {
        public void onScanInitiated(int requestCode);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mMenuItemSelectedCallback = (OnMenuItemSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnMenuItemSelectedListener");
        }

        try {
            mScanInitiatedCallback = (onScanInitiatedListener) activity;
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
        medTestsButton = (ImageButton) rootView.findViewById(R.id.medTestsButton);
        scanButton = (ImageButton) rootView.findViewById(R.id.scanButton);
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScanInitiatedCallback.onScanInitiated(11);
            }
        });


        patientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMenuItemSelectedCallback.onMenuItemSelected(1);
            }
        });

        drugsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMenuItemSelectedCallback.onMenuItemSelected(2);
            }
        });
        medTestsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMenuItemSelectedCallback.onMenuItemSelected(3);
            }
        });

        return rootView;
    }

}
