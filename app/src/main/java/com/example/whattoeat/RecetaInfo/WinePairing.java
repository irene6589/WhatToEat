
package com.example.whattoeat.RecetaInfo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
//import javax.annotation.Generated;

//@Generated("jsonschema2pojo")
public class WinePairing implements Serializable, Parcelable
{

    private final static long serialVersionUID = 590818141788545713L;

    protected WinePairing(Parcel in) {
    }

    public static final Creator<WinePairing> CREATOR = new Creator<WinePairing>() {
        @Override
        public WinePairing createFromParcel(Parcel in) {
            return new WinePairing(in);
        }

        @Override
        public WinePairing[] newArray(int size) {
            return new WinePairing[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}