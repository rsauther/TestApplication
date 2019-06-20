package com.example.rsauther.testapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String URL = "https://img.staging.medscape.com/pi/iphone/AndroidLearning.json";
    private ArrayList<Contact> mDevContactList;
    private ArrayList<Contact> mQaContactList;
    private ArrayList<Contact> mProductContactList;
    //private ArrayList<Contact> mOtherContactList;
    private ViewPager mViewPager;
    private EmployeeListFragment mQaFragment;
    private EmployeeListFragment mDevFragment;
    private EmployeeListFragment mProductFragment;
    //private EmployeeListFragment mOtherFragment;
    private AdvertismentFragment mAdvertismentFragment;
    private ViewPagerAdapter mAdapter;
    private String status = null;

//new
//    @Inject
//    WeatherApiClient weatherApiClient;
//new

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//new
//        ((WeatherApp) getApplication()).appComponent().inject(this);
//new
        setContentView(R.layout.activity_main);
        mQaContactList = new ArrayList<>();
        mDevContactList = new ArrayList<>();
        mProductContactList = new ArrayList<>();
        //mOtherContactList = new ArrayList<>();
        mViewPager = (ViewPager)findViewById(R.id.view_pager);
        mQaFragment = new EmployeeListFragment();
        mDevFragment = new EmployeeListFragment();//Added by Rich - one of these, not sure which
        mProductFragment = new EmployeeListFragment();
        //mOtherFragment = new EmployeeListFragment();
        mAdvertismentFragment = new AdvertismentFragment();
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mAdapter.addFragment(mQaFragment);
        mAdapter.addFragment(mDevFragment);
        mAdapter.addFragment(mProductFragment);
        mAdapter.addFragment(mAdvertismentFragment);
        mViewPager.setAdapter(mAdapter);//
        Log.e(TAG, "RICH - before addOnPageListener");
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {/*ignore for now*/}
            @Override
            public void onPageSelected(int position) {
                Log.e(TAG, "RICH - in onPageSelected");
                if (position == 0) mQaFragment.setContacts(mQaContactList);
                if (position == 1) mDevFragment.setContacts(mDevContactList);
                if (position == 2) mProductFragment.setContacts(mProductContactList);
            }
            @Override
            public void onPageScrollStateChanged(int state) {/*ignore for now*/}
        });
        GetContactsTask task = new GetContactsTask(new ICallbackEvent() {
            @Override
            public void onCompleted(ArrayList<Contact> contacts)
            {
                Log.e(TAG, "RICH - in onCompleted GetContactsTask");
                if ((contacts != null) && (!contacts.isEmpty())) {
                    for (Contact contact : contacts) {
                        if (contact.getPosition().contains("QA")) {
                            mQaContactList.add(contact);
                        } else if (contact.getPosition().contains("Dev")) {
                            mDevContactList.add(contact);
                        } else if (contact.getPosition().contains("Product")) {
                            mProductContactList.add(contact);
                        }else {
                            Log.e(TAG, "someone did not fit");
                        }
                    }
                }else{Log.e(TAG, "RICH - it's null");}
                    mQaFragment.setContacts(mQaContactList);
                    mDevFragment.setContacts(mDevContactList);
                    mProductFragment.setContacts(mProductContactList);
            }
            @Override
            public void onError(Exception e) {// Toast.makeText(getApplicationContext(), "OOOOOOOPs", Toast.LENGTH_LONG).show();
                Log.e(TAG, "RICH - after ErrorInGetContactsTask: "+e);
            }
        });
        task.execute(URL);
    }

//new
//    @Override
//    public boolean onQueryTextSubmit(String query) {
//        if (!TextUtils.isEmpty(query)) {
//            loadWeatherData(query);
//        }
//        return true;
//    }
//
//    private void loadWeatherData(String cityName) {
//        subscription = weatherApiClient.getWeatherForCity(cityName)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        // handle result
//                );
//    }
//new

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_download)
        {
            downloadVer();
        }
        return true;
    }

    private void downloadVer ()
    {
        GetVersionTask gvt = new GetVersionTask(new Handler.Callback(){

            public boolean handleMessage(Message msg) {
            //<code to be executed during callback>
                Log.e(TAG, "RICH - in handleMessage");
                String message = (String) msg.obj;
                Log.e(TAG, "message: " + message);

                new AlertDialog.Builder(MainActivity.this)
                            .setTitle("STATUS")
                            .setMessage(message)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    dialog.cancel();
                                }
                            }).show();



                return true;
                }
            });

        gvt.execute();
        Log.e(TAG, "RICH - in downloadVer ");
    }
}

