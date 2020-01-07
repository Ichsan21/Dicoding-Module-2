package com.rizky92.madedicodingsubmission1;

import android.os.Parcel;
import android.os.Parcelable;

// Ini POJO (Plain Old Java Object) pakai parcelable

public class Movies implements Parcelable {
    private String title, desc, date, length, rating, url;
    private int foto;

    private Movies(Parcel in) {
        title = in.readString();
        desc = in.readString();
        date = in.readString();
        rating = in.readString();
        length = in.readString();
        url = in.readString();
        foto = in.readInt();
    }

    public Movies() {
        // required for declaring Movies as new object
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(desc);
        parcel.writeString(date);
        parcel.writeString(rating);
        parcel.writeString(length);
        parcel.writeString(url);
        parcel.writeInt(foto);
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        @Override
        public Movies[] newArray(int i) {
            return new Movies[i];
        }
    };
}
