package com.example.rsauther.testapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsauther on 12/8/17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{

    private List<Fragment> mFragments = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //return super.getPageTitle(position);//Change here
        if (position == 0) return "QA";
        if (position == 1) return "Dev";
        if (position == 2) return "Product";
        return "none";
    }

    public void addFragment(Fragment fragment){
        mFragments.add(fragment);
    }
}


