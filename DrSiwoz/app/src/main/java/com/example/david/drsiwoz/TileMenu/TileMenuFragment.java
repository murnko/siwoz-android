package com.example.david.drsiwoz.TileMenu;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.david.drsiwoz.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class TileMenuFragment extends Fragment implements TileMenuView{
    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";
    private Button patientButton;
    private Button drugsButton;
    private Button specialistReportsButton;
    private Button scanButton;

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
        public void onScanInitiated();
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
        patientButton = (Button) rootView.findViewById(R.id.patientButton);
        drugsButton = (Button) rootView.findViewById(R.id.drugsButton);
        specialistReportsButton = (Button) rootView.findViewById(R.id.specialistReportsButton);

        Button scanButton = (Button) rootView.findViewById(R.id.scanButton);
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScanInitiatedCallback.onScanInitiated();
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

        return rootView;
    }

}
