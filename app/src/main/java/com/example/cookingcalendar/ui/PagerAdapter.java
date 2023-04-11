package com.example.cookingcalendar.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentStateAdapter {

    private List<DayData> dataList;

    public PagerAdapter(@NonNull FragmentActivity fragmentActivity,List<DayData> dataList) {
        super(fragmentActivity);
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       return OneWeekFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        int count = dataList.size()/7;
        if((dataList.size()%7) != 0){
            count++;
        }
        return count;
    }
}
