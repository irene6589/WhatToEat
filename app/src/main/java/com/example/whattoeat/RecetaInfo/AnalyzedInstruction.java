
package com.example.whattoeat.RecetaInfo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class AnalyzedInstruction implements Serializable, Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("steps")
    @Expose
    private List<Step> steps = null;
    private final static long serialVersionUID = 9195002277277317503L;

    protected AnalyzedInstruction(Parcel in) {
        name = in.readString();
        steps = in.createTypedArrayList(Step.CREATOR);
    }

    public static final Creator<AnalyzedInstruction> CREATOR = new Creator<AnalyzedInstruction>() {
        @Override
        public AnalyzedInstruction createFromParcel(Parcel in) {
            return new AnalyzedInstruction(in);
        }

        @Override
        public AnalyzedInstruction[] newArray(int size) {
            return new AnalyzedInstruction[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeTypedList(steps);
    }
}
