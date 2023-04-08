package com.example.cookingcalendar.ui.main;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.cookingcalendar.ui.DayData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainViewModel extends ViewModel {
    /**
     * カレンダーで使用する日付データを作成するメソッド
     * @return　日付データのリスト
     */
    public List<DayData> createListDayData(){
        //現在の日付でカレンダーインスタンスを生成
        Calendar calendar = Calendar.getInstance();
        int currentDay = calendar.get(Calendar.DATE);
        int currentWeek = calendar.get(Calendar.DAY_OF_WEEK);

        //15日前の日付データを取得
        calendar.add(calendar.DATE,-15);
        int day = calendar.get(Calendar.DATE);
        int week = calendar.get(Calendar.DAY_OF_WEEK);

        Log.d("TAG","currentDay="+ currentDay +"/day="+day);
        Log.d("TAG","currentWeek="+ currentWeek +"/Week="+week);

        DayData dayData = new DayData(6,day,false);

        ArrayList dayDataList = new ArrayList<DayData>();

        dayDataList.add(dayData);

        for(int i = 0;i < 31;i++){
            calendar.add(Calendar.DATE,+1);
            int nextDay = calendar.get(Calendar.DATE);
            int nextWeek = calendar.get(Calendar.DAY_OF_WEEK);
            boolean isSelected = false;
            if(currentDay == nextDay) {
                isSelected = true;
            }
            DayData nextDayData = new DayData(nextWeek, nextDay, isSelected);

            dayDataList.add(nextDayData);
            Log.d("TAG","dayDataList="+ nextDayData);

        }
        //先頭から31日分のデータを作成しリストに返す
        return dayDataList;
    }

}
