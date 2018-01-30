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

public class GetContactsTask extends AsyncTask <String, Void, ArrayList<Contact>>{

    private final String TAG = GetContactsTask.class.getSimpleName();

    private ICallbackEvent mEvt;

    public GetContactsTask(ICallbackEvent evt){
        mEvt = evt;
    }


    @Override
    protected ArrayList<Contact> doInBackground(String... args) {

        HttpHandler sh = new HttpHandler();
        ArrayList<Contact> contactList = null;
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
                JSONArray jsonResult = jsonObj.getJSONArray("People");

                // looping through All Contacts
                for (int i = 0; i < jsonResult.length(); i++) {
                    Contact contact = new Contact();
                    JSONObject c = jsonResult.getJSONObject(i);
                    contact.setName(c.getString("name"));
                    contact.setPosition(c.getString("position"));
                    contact.setBirthdate(c.getString("birthdate"));
                    contact.setStartdate(c.getString("startdate"));
                    contact.setAvatar(c.getString("avatar"));
                    contact.setProject(c.getString("project"));
                    contact.setHobbies(c.getString("hobbies"));
                    contact.setBio(c.getString("bio"));
                }
            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
                mEvt.onError(e);

            }
        }
        return contactList;
    }

    @Override
    protected void onPostExecute(ArrayList<Contact> contacts) {
        super.onPostExecute(contacts);
        mEvt.onCompleted(contacts);
    }
}

