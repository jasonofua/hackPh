package com.example.user.grantiecom.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 11/28/2017.
 */

public class FeaturedItem implements Parcelable {
    private String id;
    private String title;
    private String description;
    private String link;
    private String imgUser;

    public FeaturedItem() {
    }

    protected FeaturedItem(Parcel in) {
        id = in.readString();
        title = in.readString();
        description = in.readString();
        link = in.readString();
        imgUser = in.readString();
    }

    public static final Creator<FeaturedItem> CREATOR = new Creator<FeaturedItem>() {
        @Override
        public FeaturedItem createFromParcel(Parcel in) {
            return new FeaturedItem(in);
        }

        @Override
        public FeaturedItem[] newArray(int size) {
            return new FeaturedItem[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getImgUser() {
        return imgUser;
    }

    public void setImgUser(String imgUser) {
        this.imgUser = imgUser;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(link);
        parcel.writeString(imgUser);
    }
}
