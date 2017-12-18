package com.example.rsauther.testapplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/**
 * Created by rsauther on 12/15/17.
 */

class GetContactsTask2 {

    private final String TAG = GetContactsTask2.class.getSimpleName();
    private ICallbackEvent mEvt;
    //OkHttpClient client = new OkHttpClient();
    
    
    
    public GetContactsTask2(ICallbackEvent iCallbackEvent) { mEvt = iCallbackEvent;}

    String run(String url) throws IOException {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(urls[0])
                    .build();
            Response responses = null;

            try {
                responses = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String jsonData = responses.body().string();
            JSONObject Jobject = new JSONObject(jsonData);
            JSONArray Jarray = Jobject.getJSONArray("employees");

            for (int i = 0; i < Jarray.length(); i++) {
                JSONObject object = Jarray.getJSONObject(i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }





public class GetExample {
    OkHttpClient client = new OkHttpClient();

  

    public static void main(String[] args) throws IOException {
        GetExample example = new GetExample();
        String response = example.run("https://raw.github.com/square/okhttp/master/README.md");
        System.out.println(response);
    }
}