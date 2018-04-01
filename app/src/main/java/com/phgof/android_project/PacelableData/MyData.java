package com.phgof.android_project.PacelableData;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Ph.GOF on 4/1/2018.
 */

public class MyData implements Parcelable {
    int x=1;
    String names;

    protected MyData(Parcel in) {
        x = in.readInt();
        names = in.readString();

    }

    public static final Creator<MyData> CREATOR = new Creator<MyData>() {
        @Override
        public MyData createFromParcel(Parcel in) {
            return new MyData(in);
        }

        @Override
        public MyData[] newArray(int size) {
            return new MyData[size];
        }
    };
    public void setNames(String names){
            this.names = names;
    }
    public MyData(String newname) {
        this.names = newname;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(x);
        dest.writeString(names);
     }
}
