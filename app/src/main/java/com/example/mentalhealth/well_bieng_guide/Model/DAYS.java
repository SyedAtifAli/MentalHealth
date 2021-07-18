package com.example.mentalhealth.well_bieng_guide.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class DAYS implements Parcelable {

    String Day;
    String title;
    String course;

    public DAYS(String Day, String title, String course){
        this.Day= Day;
        this.title = title;
        this.course =course;
    }

    protected DAYS(Parcel in) {
        Day = in.readString();
        title = in.readString();
        course = in.readString();
    }

    public static final Creator<DAYS> CREATOR = new Creator<DAYS>() {
        @Override
        public DAYS createFromParcel(Parcel in) {
            return new DAYS(in);
        }

        @Override
        public DAYS[] newArray(int size) {
            return new DAYS[size];
        }
    };

    public String getDay() {
        return Day;
    }

    public String getTitle() {
        return title;
    }

    public String getCourse() {
        return course;
    }

    public void setDay(String day) {
        Day = day;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Day);
        dest.writeString(title);
        dest.writeString(course);
    }
}
