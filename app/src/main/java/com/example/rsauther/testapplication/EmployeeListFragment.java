package com.example.rsauther.testapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rsauther on 12/6/17.
 */

public class EmployeeListFragment extends Fragment{

    private View mRootView;
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_employee_list, container, false);
        mRecyclerView = (RecyclerView)mRootView.findViewById(R.id.recycler_view);
        // 1) git
        // 2) comment out recycler view and move to here and get it to compile
        // remove stuff from activity_main.xml


        return mRootView;

    }
}
