package com.example.orion_stark.yourcalc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.*;

/**
 * Created by orion_stark on 04/11/17.
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> myFragment = new ArrayList<>();
    private List<String> myFragmentTitle = new ArrayList<>();

    public void setFragment(Fragment frag, String title) {
        this.myFragment.add(frag);
        this.myFragmentTitle.add(title);
    }
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.myFragmentTitle.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return this.myFragment.get(position);
    }

    @Override
    public int getCount() {
        return this.myFragment.size();
    }
}
