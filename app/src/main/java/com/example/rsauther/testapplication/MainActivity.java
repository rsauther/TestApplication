package com.example.rsauther.testapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String URL = "https://img.staging.medscape.com/pi/iphone/AndroidLearning.json";
    private ArrayList<HashMap<String, String>> mContactList;
    private ViewPager mViewPager;
    private EmployeeListFragment mQaFragment;
    private EmployeeListFragment mDevFragment;
    private EmployeeListFragment mProductFragment;
    private ViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContactList = new ArrayList<>();
        mViewPager = (ViewPager)findViewById(R.id.view_pager);
        mQaFragment = new EmployeeListFragment();
        mDevFragment = new EmployeeListFragment();
        mProductFragment = new EmployeeListFragment();
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mAdapter.addFragment(mQaFragment);
        mAdapter.addFragment(mDevFragment);
        mAdapter.addFragment(mProductFragment);
        mViewPager.setAdapter(mAdapter);

        //Lookup how to add a tablayout (type of view) to view pager

        GetContactsTask task = new GetContactsTask(new ICallbackEvent() {
            @Override
            public void onCompleted(ArrayList<HashMap<String, String>> obj) {

                //// TODO: 11/29/17 use a recycler view
                int i = 0;
                for (i = 0; i < obj.size(); i++) {
                    Contact c = new Contact();
                    c.setName(obj.get(i).get("name"));
                    c.setPosition(obj.get(i).get("position"));
                    c.setBirthdate(obj.get(i).get("birthdate"));
                    c.setStartdate(obj.get(i).get("startdate"));
                    c.setAvatar(obj.get(i).get("avatar"));
                    c.setProject(obj.get(i).get("project"));
                    c.setHobbies(obj.get(i).get("hobbies"));
                    c.setBio(obj.get(i).get("bio"));
                }
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(getApplicationContext(), "OOOOOOOPs", Toast.LENGTH_LONG).show();
            }
        });
        task.execute(URL);
    }


}

