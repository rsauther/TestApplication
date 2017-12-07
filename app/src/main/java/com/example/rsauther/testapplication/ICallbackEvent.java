package com.example.rsauther.testapplication;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rsauther on 11/29/17.
 */

public interface ICallbackEvent {

    void onCompleted(ArrayList<HashMap<String, String>> obj);

    void onError(Exception e);

}
