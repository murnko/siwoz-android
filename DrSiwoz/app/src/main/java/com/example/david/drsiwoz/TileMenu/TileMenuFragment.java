package com.example.david.drsiwoz.TileMenu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.david.drsiwoz.R;


public class TileMenuFragment extends Fragment implements TileMenuView{

    public static final int RESULT_CANCELED = 0;
    public static final int RESULT_OK = -1;
    public static final int GET_PATIENT_CODE = 0;


    private Button patientButton;
    private Button drugsButton;
    private Button specialistReportsButton;
    private Button qrCodeScanButton;
    private TextView texttest;

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
        qrCodeScanButton = (Button) rootView.findViewById(R.id.scanButton);
        texttest = (TextView) rootView.findViewById(R.id.testQR);

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

        qrCodeScanButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                    intent.putExtra("SCAN_MODE", "QR_CODE_MODE");

                    startActivityForResult(intent,GET_PATIENT_CODE );
                } catch (Exception e){
                    Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
                    Intent marketIntent = new Intent(Intent.ACTION_VIEW,marketUri);
                    startActivity(marketIntent);
                }
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
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_PATIENT_CODE) {

            if (resultCode == RESULT_OK) { //Result_OK
                String contents = data.getStringExtra("SCAN_RESULT");
                mCallback.onMenuItemSelected(1);

            }
            if (resultCode == RESULT_CANCELED) { //Result_Canceled
                //handle cancel
            }
        }
    }

    }

