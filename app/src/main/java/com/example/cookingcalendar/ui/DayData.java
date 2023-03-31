package com.example.cookingcalendar.ui;

public class DayData {
    private int dayOfweek=-1;
    private int day=1;
    private boolean isSelected=false;

    public DayData(int dayOfweek, int day, boolean isSelected) {
        this.dayOfweek = dayOfweek;
        this.day = day;
        this.isSelected = isSelected;
    }

    public int getDayOfweek() {
        return dayOfweek;
    }

    public void setDayOfweek(int dayOfweek) {
        this.dayOfweek = dayOfweek;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

}
