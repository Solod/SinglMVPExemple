package com.solodilov.evgen.singlmvpexemple;

import android.os.Parcel;
import android.os.Parcelable;

class Person implements Parcelable {

    private String mName;
    private int mAge;
    private int mCount;

    Person(String name, int age) {
        mName = name;
        mAge = age;
    }

    private Person(Parcel in) {
        mName = in.readString();
        mAge = in.readInt();
        mCount = in.readInt();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeInt(mAge);
        dest.writeInt(mCount);
    }

    @Override
    public String toString() {
        String s = "Person name: " + mName + ", age: " + mAge + ", count: " + mCount;
        LogUtil.info(this, s);
        return s;
    }

    void incrementation() {
        mCount++;
    }
}
