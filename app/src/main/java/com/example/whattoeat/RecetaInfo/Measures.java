
package com.example.whattoeat.RecetaInfo;

import java.io.Serializable;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class Measures implements Serializable
{

    @SerializedName("us")
    @Expose
    private Us us;
    @SerializedName("metric")
    @Expose
    private Metric metric;
    private final static long serialVersionUID = 5992807909680084491L;

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

}