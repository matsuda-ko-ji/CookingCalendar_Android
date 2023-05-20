package com.example.cookingcalendar.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.cookingcalendar.R;
import com.example.cookingcalendar.ui.main.MainViewModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OneWeekFragment extends Fragment {

    private static final String KEY_POSITION = "key_position";
    private static final int[] dayOfWeekTextIds = {
            R.id.day_of_week_0,R.id.day_of_week_1,R.id.day_of_week_2,
            R.id.day_of_week_3,R.id.day_of_week_4,R.id.day_of_week_5,
            R.id.day_of_week_6
    };

    private static final int[] dayTextIds = {
            R.id.day_text_0,R.id.day_text_1,R.id.day_text_2,
            R.id.day_text_3,R.id.day_text_4,R.id.day_text_5,
            R.id.day_text_6
    };

    private static final int[] frameIds = {
            R.id.day_text_layout_0,R.id.day_text_layout_1,R.id.day_text_layout_2,
            R.id.day_text_layout_3,R.id.day_text_layout_4,R.id.day_text_layout_5,
            R.id.day_text_layout_6
    };

    private List<TextView> dayOfWeekTextViewList = new ArrayList<>();
    private List<TextView> dayTextViewList = new ArrayList<>();
    private List<FrameLayout> frameFlameLayoutList = new ArrayList<>();
    private MainViewModel viewModel;
    private int position = -1;

    public OneWeekFragment() {}


    // TODO: Rename and change types and number of parameters
    public static OneWeekFragment newInstance(int position) {
        OneWeekFragment fragment = new OneWeekFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION,position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        position = getArguments().getInt(KEY_POSITION);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one_week, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for(int i = 0;i < dayOfWeekTextIds.length; i++) {
            TextView dayOfWeekTextView = view.findViewById(dayOfWeekTextIds[i]);
            dayOfWeekTextViewList.add(dayOfWeekTextView);
        }

        for(int i = 0;i < dayTextIds.length; i++) {
            TextView dayTextView = view.findViewById(dayTextIds[i]);
            dayTextViewList.add(dayTextView);
        }

        for(int i = 0;i < frameIds.length; i++) {
            FrameLayout frameFrameLayout = view.findViewById(frameIds[i]);
            frameFlameLayoutList.add(frameFrameLayout);
        }
        List<DayData> dayDataList = viewModel.getDayDataList();
        int endPosition = (position + 1) * 7;
        if(position == 4) {
            endPosition = (position + 1) * 7 - 4;
        }
        List<DayData> subList = dayDataList.subList(position * 7,endPosition);
        for(int i = 0; i < subList.size(); i++) {
            DayData dayData = subList.get(i);
            String week = getDayOfWeekName(dayData.getDayOfweek());
            dayOfWeekTextViewList.get(i).setText(week);
            dayOfWeekTextViewList.get(i).setTextColor(
                    getActivity().getResources().getColor(
                            getWeekColorResId(dayData.getDayOfweek()),
                            getActivity().getTheme()
                    )
            );
            // 日付データの設定
            dayTextViewList.get(i).setText(String.valueOf(dayData.getDay()));
            // 選択状態の確認
            FrameLayout dayTextBg = frameFlameLayoutList.get(i);
            if(dayData.isSelected()){
                //　選択されてたら背景を変える
                dayTextBg.setBackgroundResource(R.drawable.shape_calender_bg_on);
            }
            else {
                dayTextBg.setBackgroundResource(R.drawable.shape_calender_bg_off);
            }
        }

    }

    private String getDayOfWeekName(int dayOfWeekNum) {
        String weekStr = "";
        if (dayOfWeekNum == Calendar.SUNDAY) {
            weekStr = "日";
        } else if (dayOfWeekNum == Calendar.MONDAY) {
            weekStr = "月";
        } else if (dayOfWeekNum == Calendar.TUESDAY) {
            weekStr = "火";
        } else if (dayOfWeekNum == Calendar.WEDNESDAY) {
            weekStr = "水";
        } else if (dayOfWeekNum == Calendar.THURSDAY) {
            weekStr = "木";
        } else if (dayOfWeekNum == Calendar.FRIDAY) {
            weekStr = "金";
        } else if (dayOfWeekNum == Calendar.SATURDAY) {
            weekStr = "土";
        }
        return weekStr;
    }

    private int getWeekColorResId(int weekNum) {
        int colorResId = R.color.black;
        if (weekNum == Calendar.SUNDAY) {
            colorResId = R.color.red;
        } else if (weekNum == Calendar.SATURDAY) {
            colorResId = R.color.blue;
        }
        return colorResId;
    }
}