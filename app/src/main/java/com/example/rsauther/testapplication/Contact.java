package com.example.rsauther.testapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rsauther on 12/1/17.
 */

public class Contact implements Parcelable {

    String mName;
    String mPosition;
    String mBirthdate;
    String mStartdate;
    String mAvatar;
    String mProject;
    String mHobbies;
    String mBio;

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String mAvatar) {
        this.mAvatar = mAvatar;
    }

    public String getBio() {
        return mBio;
    }

    public void setBio(String bio) {
        mBio = bio;
    }
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getBirthdate() {
        return mBirthdate;
    }

    public void setBirthdate(String birthdate) {
        mBirthdate = birthdate;
    }

    public String getStartdate() {
        return mStartdate;
    }

    public void setStartdate(String startdate) {
        mStartdate = startdate;
    }

    public String getPosition() {
        return mPosition;
    }

    public void setPosition(String position) {
        mPosition = position;
    }

    public String getProject() {
        return mProject;
    }

    public void setProject(String project) {
        mProject = project;
    }

    public String getHobbies() {
        return mHobbies;
    }

    public void setHobbies(String hobbies) {
        mHobbies = hobbies;
    }

    public Contact() {}

    protected Contact(Parcel in) {
        this.mName = in.readString();
        this.mPosition = in.readString();
        this.mBirthdate = in.readString();
        this.mStartdate = in.readString();
        this.mAvatar = in.readString();
        this.mProject = in.readString();
        this.mHobbies = in.readString();
        this.mBio = in.readString();
    }

    public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel source) {return new Contact(source);}

        @Override
        public Contact[] newArray(int size) {return new Contact[size];}

    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeString(this.mPosition);
        parcel.writeString(this.mBirthdate);
        parcel.writeString(this.mStartdate);
        parcel.writeString(this.mAvatar);
        parcel.writeString(this.mProject);
        parcel.writeString(this.mHobbies);
        parcel.writeString(this.mBio);
    }
}
