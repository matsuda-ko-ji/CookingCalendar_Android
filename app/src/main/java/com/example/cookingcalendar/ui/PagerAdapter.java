package com.example.cookingcalendar.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentStateAdapter {


    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
            case 1:
            case 2:
                return SampleBlankFragment.newInstance();
            default:
                return SampleBlankFragment.newInstance();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
