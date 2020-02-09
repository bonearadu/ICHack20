package com.example.studygroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabsAdapter extends FragmentStatePagerAdapter {

    private final int mNumOfTabs;

    public TabsAdapter(FragmentManager fm, int NoofTabs){
        super(fm);
        this.mNumOfTabs = NoofTabs;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new EngineeringFragment();
            case 1:
                return new MedicineFragment();
            case 2:
                return new NaturalSciencesFragment();
            case 3:
                return new BusinessFragment();
            default:
                return null;
        }
    }
}