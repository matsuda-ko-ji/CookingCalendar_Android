package com.example.cookingcalendar.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cookingcalendar.R;
import com.example.cookingcalendar.ui.main.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class OneWeekFragment extends Fragment {

    private static final String KEY_POSITION = "key_position";
    private static final int[] dayOfWeekTextIds = {
            R.id.day_of_week_0,R.id.day_of_week_1,R.id.day_of_week_2,
            R.id.day_of_week_3,R.id.day_of_week_4,R.id.day_of_week_5,
            R.id.day_of_week_6
    };

    private List<TextView> dayOfWeekTextViewList = new ArrayList<>();
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
        return inflater.inflate(R.layout.fragment_sample__blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for(int i = 0;i < dayOfWeekTextIds.length; i++) {
            TextView dayOfWeekTextView = view.findViewById(dayOfWeekTextIds[i]);
            dayOfWeekTextViewList.add(dayOfWeekTextView);
        }

        // TODO: 日付表示用TextViewを取得する

        // TODO: 日付選択用Viewを取得する

    }
}