
package com.example.whattoeat.RecetaInfo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class Us implements Serializable, Parcelable
{

    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("unitShort")
    @Expose
    private String unitShort;
    @SerializedName("unitLong")
    @Expose
    private String unitLong;
    private final static long serialVersionUID = 1859054212849337557L;

    protected Us(Parcel in) {
        if (in.readByte() == 0) {
            amount = null;
        } else {
            amount = in.readDouble();
        }
        unitShort = in.readString();
        unitLong = in.readString();
    }

    public static final Creator<Us> CREATOR = new Creator<Us>() {
        @Override
        public Us createFromParcel(Parcel in) {
            return new Us(in);
        }

        @Override
        public Us[] newArray(int size) {
            return new Us[size];
        }
    };

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUnitShort() {
        return unitShort;
    }

    public void setUnitShort(String unitShort) {
        this.unitShort = unitShort;
    }

    public String getUnitLong() {
        return unitLong;
    }

    public void setUnitLong(String unitLong) {
        this.unitLong = unitLong;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (amount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(amount);
        }
        dest.writeString(unitShort);
        dest.writeString(unitLong);
    }
}