package com.example.rsauther.testapplication;

import android.os.AsyncTask;
import android.os.Message;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import android.os.Handler.Callback;

/**
 * Created by nbhatia on 1/30/18.
 */

public class GetVersionTask extends AsyncTask<Object, Object, String> {

    private final String TAG = GetVersionTask.class.getSimpleName();

    private Callback mEvt;

    public GetVersionTask(Callback evt) {mEvt = evt;}

    @Override
    protected String doInBackground(Object... args) {

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
        return result; //-1;
    }

    @Override
    protected void onPostExecute(String i) {
        Log.e(TAG, "RICH - in GetVersionTask onPostExecute");
        super.onPostExecute(i);
        //Message message = new Message();
        //message.toString();
        //String message = "linkSpeed = " + linkSpeed;
        Message msg = Message.obtain(); // Creates an new Message instance
        msg.obj = i;//message; // Put the string into Message, into "obj" field.
        //msg.setTarget(handler); // Set the Handler
        //msg.sendToTarget(); //Send the message
        //mEvt.onCompleted(i);
        mEvt.handleMessage(msg);//(message);
    }
}