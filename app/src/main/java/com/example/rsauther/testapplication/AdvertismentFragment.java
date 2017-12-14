package com.example.rsauther.testapplication;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Created by rsauther on 12/6/17.
 */

public class AdvertismentFragment extends Fragment {

    private View mRootView;
    private Button mAdvertisementButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_advertisement,container,false);
        mAdvertisementButton = (Button)mRootView.findViewById(R.id.advertisementButton);
        mAdvertisementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),FragmentExampleActivity.class);
                startActivity(intent);

            }
        });
        return mRootView;

    }





}


//Create a new fragment that does anything