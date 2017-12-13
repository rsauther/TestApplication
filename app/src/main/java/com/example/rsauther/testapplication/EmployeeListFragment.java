package com.example.rsauther.testapplication;


import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rsauther on 12/6/17.
 */

public class EmployeeListFragment extends Fragment {

    private View mRootView;
    private RecyclerView mRecyclerView;
    private Context mContext;
    private RecyclerAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_employee_list, container, false);
        mRecyclerView = (RecyclerView)mRootView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new RecyclerAdapter(mContext);
        mRecyclerView.setAdapter(mAdapter);
        return mRootView;

    }

    public void setContacts(ArrayList<Contact> contacts){
        if (contacts.size()!=0) {
            mAdapter.addItems(contacts);
            mAdapter.notifyDataSetChanged();
        }

    }
}


//Create a new fragment that does anything