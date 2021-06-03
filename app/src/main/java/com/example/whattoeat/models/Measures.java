
package com.example.whattoeat.models;


import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Measures implements Parcelable
{

    @SerializedName("original")
    @Expose
    private Original original;
    @SerializedName("metric")
    @Expose
    private Metric metric;
    @SerializedName("us")
    @Expose
    private Us us;

    protected Measures(android.os.Parcel in) {
        this.original = ((Original) in.readValue((Original.class.getClassLoader())));
        this.metric = ((Metric) in.readValue((Metric.class.getClassLoader())));
        this.us = ((Us) in.readValue((Us.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Measures() {
    }

    /**
     * 
     * @param original
     * @param metric
     * @param us
     */
    public Measures(Original original, Metric metric, Us us) {
        super();
        this.original = original;
        this.metric = metric;
        this.us = us;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(original, flags);
        dest.writeParcelable(metric, flags);
        dest.writeParcelable(us, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Measures> CREATOR = new Creator<Measures>() {
        @Override
        public Measures createFromParcel(Parcel in) {
            return new Measures(in);
        }

        @Override
        public Measures[] newArray(int size) {
            return new Measures[size];
        }
    };

    public Original getOriginal() {
        return original;
    }

    public void setOriginal(Original original) {
        this.original = original;
    }

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    public Us getUs() {
        return us;
    }

    public void setUs(Us us) {
        this.us = us;
    }


}
