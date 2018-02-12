package com.example.rsauther.testapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rsauther.testapplication.interfaces.IContactClickListener;
import com.squareup.picasso.*;

/**
 * Created by rsauther on 12/1/17.
 */

public class ContactViewHolder extends RecyclerView.ViewHolder {
    private Context mContext;
    private TextView name;
    private TextView position;
    private TextView birthdate;
    private TextView startdate;
    private ImageView avatar;
    private TextView project;
    //private TextView hobbies;
    private TextView bio;

    public ContactViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        name = (TextView) itemView.findViewById(R.id.name);
        position = (TextView) itemView.findViewById(R.id.position_data);
        startdate = (TextView) itemView.findViewById(R.id.startdate_data);
        project = (TextView) itemView.findViewById(R.id.project_data);
        avatar = (ImageView) itemView.findViewById(R.id.user_icon);
        //hobbies = (TextView) itemView.findViewById(R.id.hobbies);
        bio = (TextView) itemView.findViewById(R.id.bio);
    }

    public void bind(final Contact contact, final IContactClickListener listener){
        //public void bind(Contact contact, View.OnClickListener listener){
        name.setText(contact.getName());
        position.setText(contact.getPosition());
        startdate.setText(contact.getStartdate());
        Picasso.with(mContext).load(contact.getAvatar()).into(avatar);
        project.setText(contact.getProject());
        //hobbies.setText(contact.getHobbies());
        bio.setText(contact.getBio());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("EmployeeListFragment", "RICH - Contact Clicked");
                Toast.makeText(mContext, "Contact Clicked", Toast.LENGTH_LONG).show();
                listener.onContactClicked(contact);
            }
        });



    }


}
