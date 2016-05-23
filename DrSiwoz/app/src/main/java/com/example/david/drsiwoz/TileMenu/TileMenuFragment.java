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
        patientButton = (Button) rootView.findViewById(R.id.patientButton);
        drugsButton = (Button) rootView.findViewById(R.id.drugsButton);
        specialistReportsButton = (Button) rootView.findViewById(R.id.specialistReportsButton);
        Button scanButton = (Button) rootView.findViewById(R.id.scanButton);
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanBar(v);
            }
        });


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
    //product barcode mode
    public void scanBar(View v) {
        try {
            //start the scanning activity from the com.google.zxing.client.android.SCAN intent
            Intent intent = new Intent(ACTION_SCAN);
            intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException anfe) {
            //on catch, show the download dialog
            Log.e("Activity ZXING", "Activity not found");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == 200) {
                String id = intent.getStringExtra("SCAN_RESULT");
                Log.d("ID", "ID: " + id);
            }
        }
    }
}
