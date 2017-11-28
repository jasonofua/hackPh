package com.example.user.grantiecom.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class UserProfile implements Parcelable{

    private String id;
    private String name;
    private String phone;
    private String imgUrl;

    public UserProfile() {
    }

    //    public UserProfile(String id, String name, String phone, String imgUrl) {
//        this.id = id;
//        this.name = name;
//        this.phone = phone;
//        this.imgUrl = imgUrl;
//    }

    protected UserProfile(Parcel in) {
        id = in.readString();
        name = in.readString();
        phone = in.readString();
        imgUrl = in.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public static final Creator<UserProfile> CREATOR = new Creator<UserProfile>() {
        @Override
        public UserProfile createFromParcel(Parcel in) {
            return new UserProfile(in);
        }

        @Override
        public UserProfile[] newArray(int size) {
            return new UserProfile[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(phone);
        parcel.writeString(imgUrl);
    }
}
