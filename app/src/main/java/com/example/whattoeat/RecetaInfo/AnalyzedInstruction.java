
package com.example.whattoeat.RecetaInfo;

import java.io.Serializable;
import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class AnalyzedInstruction implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("steps")
    @Expose
    private List<Step> steps = null;
    private final static long serialVersionUID = 9195002277277317503L;

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

}
