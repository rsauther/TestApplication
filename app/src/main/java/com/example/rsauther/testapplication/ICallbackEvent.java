package com.example.rsauther.testapplication;

import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rsauther on 11/29/17.
 */

public interface ICallbackEvent {

    void onCompleted(ArrayList<Contact> obj);

    void onError(Exception e);

}
