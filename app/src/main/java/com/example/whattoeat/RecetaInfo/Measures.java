
package com.example.whattoeat.RecetaInfo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class Measures implements Serializable, Parcelable
{

    @SerializedName("us")
    @Expose
    private Us us;
    @SerializedName("metric")
    @Expose
    private Metric metric;
    private final static long serialVersionUID = 5992807909680084491L;

    protected Measures(Parcel in) {
        us = in.readParcelable(Us.class.getClassLoader());
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

    public Us getUs() {
        return us;
    }

    public void setUs(Us us) {
        this.us = us;
    }

    public Metric getMetric() {
        return metric;
    }
    //    TODO preguntar a Sergio porque esto da error, no puede acceder al recurso y no se porque ni como arreglarlo
    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(us, flags);
    }
}