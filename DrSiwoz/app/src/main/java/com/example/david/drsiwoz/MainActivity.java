package com.example.david.drsiwoz;

import android.app.FragmentTransaction;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.david.drsiwoz.Patients.PatientsFragment;
import com.example.david.drsiwoz.Drugs.DrugsFragment;
import com.example.david.drsiwoz.TileMenu.TileMenuFragment;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


/**
 * Created by david on 2016-03-19.
 */
public class MainActivity extends AppCompatActivity
    implements TileMenuFragment.OnMenuItemSelectedListener, TileMenuFragment.onScanInitiatedListener {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private String token;

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
            token= extras.getString("token");
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
            token = null;
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onScanInitiated() {
        IntentIntegrator scanIntegrator = new IntentIntegrator(this);
        scanIntegrator.initiateScan();
    }

    @Override
    public void onMenuItemSelected(int position) {
        mViewPager.setCurrentItem(position);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private DrugsFragment drugsFragment;
        private PatientsFragment patientsFragment;
        private TileMenuFragment tileMenuFragment;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            drugsFragment = new DrugsFragment();
            patientsFragment = new PatientsFragment();
            tileMenuFragment = new TileMenuFragment();
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return tileMenuFragment;
            } else if (position == 1) {
                return patientsFragment;
            } else{
                drugsFragment.getDrugs();
                return drugsFragment;
            }
        }

        @Override
        public int getCount() {
            return 3;
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

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            this.token = scanContent;
        }
        mViewPager.setCurrentItem(1);
        mSectionsPagerAdapter.patientsFragment.getPatient(this.token);
    }

}

