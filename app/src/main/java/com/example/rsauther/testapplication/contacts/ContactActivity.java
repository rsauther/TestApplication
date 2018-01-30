package com.example.rsauther.testapplication.contacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.example.rsauther.testapplication.Contact;
import com.example.rsauther.testapplication.R;

/**
 * Created by nbhatia on 1/30/18.
 */

public class ContactActivity extends AppCompatActivity
{
    private Contact mContact;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        if (b != null)
        {
            mContact = b.getParcelable("Contact");
            updateUIForScreen();
        }
    }

    private void updateUIForScreen ()
    {
        //TODO display the contact details
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.contact_menu, menu);
        return true;
    }

}
