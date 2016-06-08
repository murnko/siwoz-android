package com.example.david.drsiwoz;


import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.david.drsiwoz.MedicalTests.TestsFragment;
import com.example.david.drsiwoz.Models.MedicalTest;
import com.example.david.drsiwoz.Patients.PatientsFragment;
import com.example.david.drsiwoz.Drugs.DrugsFragment;
import com.example.david.drsiwoz.TileMenu.TileMenuFragment;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;





/**
 * Created by david on 2016-03-19.
 */
public class MainActivity extends AppCompatActivity
    implements
        TileMenuFragment.OnMenuItemSelectedListener,
        TileMenuFragment.onScanInitiatedListener,
        PatientsFragment.PatientListener {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private String authToken = "8729049481d5e40c78b0bff64523e4ff72283756";
    private String patientId;
    private String appliedDrugId;
    private int requestCodeBig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            authToken = extras.getString("authToken");
        }
    }

    @Override
    public void onBackPressed() {
        mViewPager.setCurrentItem(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_logout) {
            authToken = null;
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onScanInitiated(int requestCode) {


        requestCodeBig = requestCode;
        IntentIntegrator scanIntegrator = new IntentIntegrator(this);
        scanIntegrator.initiateScan();

        //scanIntegrator.initiateScan();
    }

    @Override
    public void onMenuItemSelected(int position) {
        if (position == 2) {
            mSectionsPagerAdapter.drugsFragment.getServings(authToken,patientId);

        }
        mViewPager.setCurrentItem(position);
    }

    @Override
    public void onPatientFetchFailedListener() {
        this.patientId = null;
    }

    @Override
    public String getPatientId() {
        return patientId;
    }

    public String getauthToken() {
        return authToken;
    }



    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public DrugsFragment drugsFragment;
        public PatientsFragment patientsFragment;
        public TestsFragment testsFragment;
        public TileMenuFragment tileMenuFragment;


        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            drugsFragment = new DrugsFragment();
            tileMenuFragment = new TileMenuFragment();
            patientsFragment = new PatientsFragment();
            testsFragment = new TestsFragment();
            patientsFragment.setAuthToken(authToken);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return tileMenuFragment;
            } else if (position == 1) {
                return patientsFragment;
            } else if (position == 2){
                return drugsFragment;
            }
              else if (position == 3){
                return testsFragment;
            }
            else{
                drugsFragment.getServings(authToken,patientId);
                return drugsFragment;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString(R.string.section_patients);
                case 1:
                    return getResources().getString(R.string.section_drugs);
            }
            return null;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            switch(requestCodeBig) {
                case 11:
                    this.patientId = scanContent;
                    mViewPager.setCurrentItem(1);
                    System.out.println(patientId);
                    this.mSectionsPagerAdapter.patientsFragment.getPatient(this.authToken, this.patientId);
                    this.mSectionsPagerAdapter.patientsFragment.getPatientStatus(this.authToken, this.patientId);
                    this.mSectionsPagerAdapter.testsFragment.getTests(this.authToken,this.patientId);
                    this.mSectionsPagerAdapter.drugsFragment.getServings(this.authToken,this.patientId);
                    break;
                case 21:
                    this.appliedDrugId = scanContent;
                    this.mSectionsPagerAdapter.drugsFragment.applyDrug(this.authToken,this.patientId,appliedDrugId);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.mSectionsPagerAdapter.drugsFragment.getServings(this.authToken,this.patientId);
                    break;
                default:
                    mViewPager.setCurrentItem(1);
                    break;
            }
        }
        else{System.out.println("scanningResult= NULL!");}


    }

}

