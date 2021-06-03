
package com.example.whattoeat.models;

import java.util.List;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListaCompra
{

    @SerializedName("aisles")
    @Expose
    private List<Aisle> aisles = null;
    @SerializedName("cost")
    @Expose
    private Double cost;
    @SerializedName("startDate")
    @Expose
    private Integer startDate;
    @SerializedName("endDate")
    @Expose
    private Integer endDate;




    /**
     * No args constructor for use in serialization
     * 
     */
    public ListaCompra() {
    }

    /**
     * 
     * @param cost
     * @param endDate
     * @param aisles
     * @param startDate
     */
    public ListaCompra(List<Aisle> aisles, Double cost, Integer startDate, Integer endDate) {
        super();
        this.aisles = aisles;
        this.cost = cost;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public List<Aisle> getAisles() {
        return aisles;
    }

    public void setAisles(List<Aisle> aisles) {
        this.aisles = aisles;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }


}
