package com.example.rsauther.testapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
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
//        birthdate = (TextView) itemView.findViewById(R.id.birthdate_edit_text);
        startdate = (TextView) itemView.findViewById(R.id.startdate_data);
        project = (TextView) itemView.findViewById(R.id.project_data);
//        name = (TextView) itemView.findViewById(R.id.name_edit_text);
//        position = (TextView) itemView.findViewById(R.id.position_edit_text);
//        birthdate = (TextView) itemView.findViewById(R.id.birthdate_edit_text);
//        startdate = (TextView) itemView.findViewById(R.id.startdate_edit_text);
        avatar = (ImageView) itemView.findViewById(R.id.user_icon);
        //hobbies = (TextView) itemView.findViewById(R.id.hobbies);
        bio = (TextView) itemView.findViewById(R.id.bio);
    }

    public void bind(Contact contact){
        name.setText(contact.getName());
        position.setText(contact.getPosition());
        startdate.setText(contact.getStartdate());
//        birthdate.setText(contact.getBirthdate());

//        avatar.setText(contact.getAvatar());

//        Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(imageView);
        Picasso.with(mContext).load(contact.getAvatar()).into(avatar);


        project.setText(contact.getProject());
        //hobbies.setText(contact.getHobbies());
        bio.setText(contact.getBio());


    }


}
