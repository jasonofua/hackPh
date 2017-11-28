package com.example.user.grantiecom.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 11/28/2017.
 */

public class Feeds implements Parcelable {

    private String name;
    private String question;
    private String title;

    public Feeds() {
    }

    protected Feeds(Parcel in) {
        name = in.readString();
        question = in.readString();
        title = in.readString();
    }

    public static final Creator<Feeds> CREATOR = new Creator<Feeds>() {
        @Override
        public Feeds createFromParcel(Parcel in) {
            return new Feeds(in);
        }

        @Override
        public Feeds[] newArray(int size) {
            return new Feeds[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(question);
        parcel.writeString(title);
    }
}
