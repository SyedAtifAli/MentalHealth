package com.example.mentalhealth.well_bieng_guide.Resilience.Model;

public class DAYS {

    String Day;
    String title;

    public DAYS(String Day, String title){
        this.Day= Day;
        this.title = title;
    }

    public String getDay() {
        return Day;
    }

    public String getTitle() {
        return title;
    }

    public void setDay(String day) {
        Day = day;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
