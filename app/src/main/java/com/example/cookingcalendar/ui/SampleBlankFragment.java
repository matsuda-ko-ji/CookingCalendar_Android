package com.example.cookingcalendar.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cookingcalendar.R;

public class SampleBlankFragment extends Fragment {

    public SampleBlankFragment() {}


    // TODO: Rename and change types and number of parameters
    public static SampleBlankFragment newInstance() {
        SampleBlankFragment fragment = new SampleBlankFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sample__blank, container, false);
    }
}