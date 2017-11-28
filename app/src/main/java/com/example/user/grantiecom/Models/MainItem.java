package com.example.user.grantiecom.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 11/28/2017.
 */

public class MainItem implements Parcelable{
    private String id;
    private String imgCompany;
    private String title;
    private String description;
    private String link;

    public MainItem() {
    }

    protected MainItem(Parcel in) {
        id = in.readString();
        imgCompany = in.readString();
        title = in.readString();
        description = in.readString();
        link = in.readString();
    }

    public static final Creator<MainItem> CREATOR = new Creator<MainItem>() {
        @Override
        public MainItem createFromParcel(Parcel in) {
            return new MainItem(in);
        }

        @Override
        public MainItem[] newArray(int size) {
            return new MainItem[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgCompany() {
        return imgCompany;
    }

    public void setImgCompany(String imgCompany) {
        this.imgCompany = imgCompany;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(imgCompany);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(link);
    }
}
