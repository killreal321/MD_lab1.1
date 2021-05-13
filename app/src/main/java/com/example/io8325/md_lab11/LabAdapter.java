package com.example.io8325.md_lab11;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LabAdapter extends FragmentPagerAdapter {

    Context context;
    int totalTabs;

    public LabAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm, totalTabs);
        context = c;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        fragment = new Lab3Fragment();
        return fragment;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}