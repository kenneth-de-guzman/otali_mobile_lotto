package com.otali.mobilelotto;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mfragmentList = new ArrayList<>();

    public SectionsPagerAdapter (FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return mfragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mfragmentList.get(position);
    }

    public void addFragment(Fragment fragment){
        mfragmentList.add(fragment);
    }

}
