package com.example.rsauther.testapplication.contacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rsauther.testapplication.Contact;
import com.example.rsauther.testapplication.R;

/**
 * Created by nbhatia on 1/30/18.
 */

public class ContactActivity extends AppCompatActivity
{
    private Contact mContact;
    public TextView name;
    public TextView position;
    public TextView birthdate;
    public TextView startdate;
    //public ImageView avatar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //Intent i = getIntent();
        Bundle b = getIntent().getExtras();
        if (b != null)
        {
            mContact = b.getParcelable("contact");
            Log.e("ContactActivity", "RICH - before UpdateUIForScreen");
            updateUIForScreen();
        }
    }

    private void updateUIForScreen ()
    {
        //TODO display the contact details
        setContentView(R.layout.viewholder_contact);
        name = (TextView)findViewById(R.id.name_edit_text);
        position = (TextView)findViewById(R.id.position_edit_text);
        birthdate = (TextView)findViewById(R.id.birthdate_edit_text);
        startdate = (TextView)findViewById(R.id.startdate_edit_text);
        //avatar = (ImageView)findViewById(R.id.user_icon);
        Log.e("ContactActivity", "RICH - In UpdateUIForScreen");
        name.setText(mContact.getName());
        position.setText(mContact.getPosition());
        birthdate.setText(mContact.getBirthdate());
        startdate.setText(mContact.getStartdate());
        //avatar.get

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.contact_menu, menu);
        return true;
    }

}
