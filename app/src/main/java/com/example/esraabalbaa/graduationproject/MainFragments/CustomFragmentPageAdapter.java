package com.example.esraabalbaa.graduationproject.MainFragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Shiko on 14/03/2017.
 */

public class CustomFragmentPageAdapter extends FragmentPagerAdapter {
    String names[] = {"الرئيسية","المنتجات","المفضلة"};


    public CustomFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }
    public void fragmentadd (Fragment fragments, String title) {
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Home();
            case 1:
                return new Categories();
            case 2:
                return new Favourites();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return names.length;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return names[position];
    }

}
