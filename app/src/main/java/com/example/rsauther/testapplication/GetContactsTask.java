package com.example.rsauther.testapplication;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rsauther on 11/28/17.
 */

public class GetContactsTask extends AsyncTask <String, Void, ArrayList<HashMap<String, String>>>{

    private final String TAG = GetContactsTask.class.getSimpleName();

    private ICallbackEvent mEvt;

    public GetContactsTask(ICallbackEvent evt){
        mEvt = evt;
    }


    @Override
    protected ArrayList<HashMap<String, String>> doInBackground(String... args) {

        HttpHandler sh = new HttpHandler();
        ArrayList<HashMap<String, String>> contactList = new ArrayList<>();
        String url = args[0];
        // Making a request to url and getting response
        String jsonStr = null;
        try {
            jsonStr = sh.makeServiceCall(url);

        } catch (IOException e) {
            e.printStackTrace();
            mEvt.onError(e);
        }


        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);

                // Getting JSON Array node
                JSONArray contacts = jsonObj.getJSONArray("People");

                // looping through All Contacts
                for (int i = 0; i < contacts.length(); i++) {
                    JSONObject c = contacts.getJSONObject(i);
                    String name = c.getString("name");
                    String position = c.getString("position");
                    String birthdate = c.getString("birthdate");
                    String startdate = c.getString("startdate");
                    String avatar = c.getString("avatar");
                    String project = c.getString("project");
                    String hobbies = c.getString("hobbies");
                    String bio = c.getString("bio");

                    // tmp hash map for single contact
                    HashMap<String, String> contact = new HashMap<>();

                    // adding each child node to HashMap key => value
                    contact.put("name", name);
                    contact.put("position", position);
                    contact.put("birthdate", birthdate);
                    contact.put("startdate", startdate);
                    contact.put("avatar", avatar);
                    contact.put("project", project);
                    contact.put("hobbies", hobbies);
                    contact.put("bio", bio);

                    // adding contact to contact list
                    contactList.add(contact);
                }
            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
                mEvt.onError(e);

            }
        }
        return contactList;
    }

    @Override
    protected void onPostExecute(ArrayList<HashMap<String, String>> hashMaps) {
        super.onPostExecute(hashMaps);
        mEvt.onCompleted(hashMaps);
    }
}

