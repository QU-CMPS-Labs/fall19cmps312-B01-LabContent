package com.cmps312.listrecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Country implements Parcelable {

    private String name;
    private int flag;
    private String capital;

    public Country(String name, int flag, String capital) {
        this.name = name;
        this.flag = flag;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return name;
    }

    public static ArrayList<Country> getCountries(){
        ArrayList<Country> countries = new ArrayList<>();

        countries.add(new Country("Qatar", R.drawable.qatar_flag, "Doha"));
        countries.add(new Country("UK", R.drawable.uk_flag, "London"));
        countries.add(new Country("Germany", R.drawable.germany_flag, "Berlin")); countries.add(new Country("Qatar", R.drawable.qatar_flag, "Doha"));
        countries.add(new Country("UK", R.drawable.uk_flag, "London"));
        countries.add(new Country("Germany", R.drawable.germany_flag, "Berlin"));
        countries.add(new Country("Qatar", R.drawable.qatar_flag, "Doha"));
        countries.add(new Country("UK", R.drawable.uk_flag, "London"));
        countries.add(new Country("Germany", R.drawable.germany_flag, "Berlin"));

        return countries;

    }

   
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.flag);
        dest.writeString(this.capital);
    }

    protected Country(Parcel in) {
        this.name = in.readString();
        this.flag = in.readInt();
        this.capital = in.readString();
    }

    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel source) {
            return new Country(source);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };
}
