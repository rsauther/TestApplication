package com.example.rsauther.testapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by nbhatia on 1/30/18.
 */

public class GetVersionTask extends AsyncTask<Void, Integer, Integer> {

    private final String TAG = GetVersionTask.class.getSimpleName();


    @Override
    protected Integer doInBackground(Void... args) {

        HttpHandler sh = new HttpHandler();
        String url = "https://alburt.us/sample_xml.xml";
        // Making a request to url and getting response
        String xmlStr = null;
        try {
            xmlStr = sh.makeServiceCall(url);

        } catch (IOException e) {
            e.printStackTrace();
        }


        if (xmlStr != null)
        {

        }
        return -1;
    }

    @Override
    protected void onPostExecute(Integer i) {
        super.onPostExecute(i);
    }
}