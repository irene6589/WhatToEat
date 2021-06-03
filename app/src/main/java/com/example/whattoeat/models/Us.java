
package com.example.whattoeat.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Us implements Parcelable
{

    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("unit")
    @Expose
    private String unit;

    protected Us(android.os.Parcel in) {
        this.amount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.unit = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Us() {
    }

    /**
     * 
     * @param amount
     * @param unit
     */
    public Us(Double amount, String unit) {
        super();
        this.amount = amount;
        this.unit = unit;
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
