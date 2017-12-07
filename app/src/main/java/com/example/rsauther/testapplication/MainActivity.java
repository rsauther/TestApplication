package com.example.rsauther.testapplication;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    private RecyclerAdapter mAdapter;
    private String TAG = MainActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private ListView lv;
    private static String url = "https://img.staging.medscape.com/pi/iphone/AndroidLearning.json";


    ArrayList<HashMap<String, String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button AddAdButton = (Button) findViewById(R.id.add_ad);
//new
        contactList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.list);

        GetContactsTask task = new GetContactsTask(new ICallbackEvent() {
            @Override
            public void onCompleted(ArrayList<HashMap<String, String>> obj) {
                
                //// TODO: 11/29/17 use a recycler view
                int i = 0;
                for(i=0; i < obj.size(); i++){
                    Contact c = new Contact();
                    c.setName(obj.get(i).get("name"));
                    c.setPosition(obj.get(i).get("position"));
                    c.setBirthdate(obj.get(i).get("birthdate"));
                    c.setStartdate(obj.get(i).get("startdate"));
                    c.setAvatar(obj.get(i).get("avatar"));
                    c.setProject(obj.get(i).get("project"));
                    c.setHobbies(obj.get(i).get("hobbies"));
                    c.setBio(obj.get(i).get("bio"));
                    mAdapter.addItem(c);

                }

                mAdapter.notifyDataSetChanged();



//                ListAdapter adapter = new SimpleAdapter(
//                        MainActivity.this, obj,
//                        R.layout.list_item, new String[]{"name", "position",
//                        "birthdate", "startdate", "avatar"}, new int[]{R.id.name,
//                        R.id.position, R.id.birthdate, R.id.startdate, R.id.avatar});
//               lv.setAdapter(adapter);
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(getApplicationContext(),"OOOOOOOPs" ,Toast.LENGTH_LONG).show();
            }
        });
        task.execute(url);


        //From recyclerview setup
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecyclerAdapter(getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);

        AddAdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"Click" ,Toast.LENGTH_LONG).show();
                createAd(2);
            }
        });
    }

    public void createAd(int condition) {
        String[] colorNames = getResources().getStringArray(R.array.colorNames);
        TypedArray ta = getResources().obtainTypedArray(R.array.colors);
//        ta.getResourceId(1,0);
        if (condition == 1) {
            for (int i = 0; i < ta.length(); i++) {
                int colorToUse = ta.getResourceId(i, 0);
                Advertisement a = new Advertisement();
                a.setBackgroundColor(getResources().getColor(colorToUse));
                a.setAdColorText(colorNames[i]);
                mAdapter.addItem(a);
            }

        } else if (condition == 0) {
            int num;
            num = (int) (140 * Math.random());
            int colorToUse = ta.getResourceId(num, 0);
            Advertisement a = new Advertisement();
            a.setBackgroundColor(getResources().getColor(colorToUse));
            a.setAdColorText(colorNames[num]);
            mAdapter.addItem(a);

        } else if (condition == 2) {
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, contactList,
                    R.layout.list_item, new String[]{"name", "position",
                    "birthdate", "startdate", "avatar"}, new int[]{R.id.name,
                    R.id.position, R.id.birthdate, R.id.startdate, R.id.avatar});
//               lv.setAdapter(adapter);


//            new GetContacts().execute();

            int num;
            num = (int) (14 * Math.random());
            String pos;
            pos = contactList.get(num).values().toString();
////            String pos = contactList.get(1).toString();
            String[] details = new String[]{pos};
            Toast.makeText(getApplicationContext(), pos, Toast.LENGTH_LONG).show();

////            Log.i("test: ", pos);

            //         int num;
//            num = (int)(140 * Math.random());
//            int colorToUse = ta.getResourceId(num, 0);
//            Advertisement a = new Advertisement();
//            a.setBackgroundColor(getResources().getColor(colorToUse));
//            a.setAdColorText(colorNames[num]);
//            mAdapter.addItem(a);

        }

        mAdapter.notifyDataSetChanged();


    }


// create a method that creates a new advertisement and passes it to the adapter

//    private class GetContacts extends AsyncTask<Void, Void, Void> {
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            // Showing progress dialog
//            pDialog = new ProgressDialog(MainActivity.this);
//            pDialog.setMessage("Please wait...");
//
//            pDialog.show();
//
//        }
//
//
//        @Override
//        protected void onPostExecute(Void result) {
//            super.onPostExecute(result);
//            // Dismiss the progress dialog
//            if (pDialog.isShowing())
//                pDialog.dismiss();
//            /**
//             * Updating parsed JSON data into ListView
//             * */
////        ListAdapter adapter = new SimpleAdapter(
////                MainActivity.this, contactList,
////                R.layout.list_item, new String[]{"name", "position",
////                "birthdate", "startdate", "avatar"}, new int[]{R.id.name,
////                R.id.position, R.id.birthdate, R.id.startdate, R.id.avatar});
////
////        lv.setAdapter(adapter);
//        }
//    }

}
//{
//        "People": [{
//        "name": "Nick Bhatia",
//        "position": "Director, Mobile Engineering",
//        "birthdate": "1/1/1986",
//        "startdate": "September 05, 2011",
//        "avatar": "https://s3.amazonaws.com/uploads.hipchat.com/photos/1296774/ITVdTnjBUBTNKMj_125.png"
//        }
