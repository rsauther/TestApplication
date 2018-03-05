package com.example.rsauther.testapplication;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by nbhatia on 1/30/18.
 */

public class GetVersionTask extends AsyncTask<Void, Integer, Integer> {

    private final String TAG = GetVersionTask.class.getSimpleName();
    private Context mContext;

    @Override
    protected Integer doInBackground(Void... args) {

        HttpHandler sh = new HttpHandler();
        String url = "https://alburt.us/sample_xml.xml";
        // Making a request to url and getting response
        String xmlStr = null;
        String result = null;
        try {
            xmlStr = sh.makeServiceCall(url);

        } catch (IOException e) {
            e.printStackTrace();
        }


        if (xmlStr != null)
        {
            Log.e(TAG, "RICH - in GetVersionTask");
            try {
                URL url1 = new URL("https://alburt.us/sample_xml.xml");
                URLConnection conn = url1.openConnection();

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(conn.getInputStream());
                //Document doc = builder.parse(xmlStr);


                NodeList nodes = doc.getElementsByTagName("legal");
                for (int i = 0; i < nodes.getLength(); i++) {
                    Element element = (Element) nodes.item(i);
                    NodeList title = element.getElementsByTagName("type");
                    Element line = (Element) title.item(0);
                    //phoneNumberList.add(line.getTextContent());
                    result = line.getAttribute("status");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        return -1;
    }

    @Override
    protected void onPostExecute(Integer i) {
        super.onPostExecute(i);
    }
}