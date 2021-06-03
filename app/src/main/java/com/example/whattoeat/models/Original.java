
package com.example.whattoeat.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Original implements Parcelable
{

    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("unit")
    @Expose
    private String unit;



    /**
     * No args constructor for use in serialization
     * 
     */
    public Original() {
    }

    /**
     * 
     * @param amount
     * @param unit
     */
    public Original(Double amount, String unit) {
        super();
        this.amount = amount;
        this.unit = unit;
    }

    protected Original(Parcel in) {
        if (in.readByte() == 0) {
            amount = null;
        } else {
            amount = in.readDouble();
        }
        unit = in.readString();
    }

    public static final Creator<Original> CREATOR = new Creator<Original>() {
        @Override
        public Original createFromParcel(Parcel in) {
            return new Original(in);
        }

        @Override
        public Original[] newArray(int size) {
            return new Original[size];
        }
    };

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
        dest.writeString(unit);
    }
}
