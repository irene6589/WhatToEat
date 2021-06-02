package com.example.whattoeat.MealPlanWeek;
import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Week implements Serializable {
    @SerializedName("monday")
    @Expose
    private Day monday;
    @SerializedName("tuesday")
    @Expose
    private Day tuesday;
    @SerializedName("wednesday")
    @Expose
    private Day wednesday;
    @SerializedName("thursday")
    @Expose
    private Day thursday;
    @SerializedName("friday")
    @Expose
    private Day friday;
    @SerializedName("saturday")
    @Expose
    private Day saturday;
    @SerializedName("sunday")
    @Expose
    private Day sunday;


    public Day getMonday() {
        return monday;
    }

    public void setMonday(Day monday) {
        this.monday = monday;
    }

    public Week withMonday(Day monday) {
        this.monday = monday;
        return this;
    }

    public Day getTuesday() {
        return tuesday;
    }

    public void setTuesday(Day tuesday) {
        this.tuesday = tuesday;
    }

    public Week withTuesday(Day tuesday) {
        this.tuesday = tuesday;
        return this;
    }

    public Day getWednesday() {
        return wednesday;
    }

    public void setWednesday(Day wednesday) {
        this.wednesday = wednesday;
    }

    public Week withWednesday(Day wednesday) {
        this.wednesday = wednesday;
        return this;
    }

    public Day getThursday() {
        return thursday;
    }

    public void setThursday(Day thursday) {
        this.thursday = thursday;
    }

    public Week withThursday(Day thursday) {
        this.thursday = thursday;
        return this;
    }

    public Day getFriday() {
        return friday;
    }

    public void setFriday(Day friday) {
        this.friday = friday;
    }

    public Week withFriday(Day friday) {
        this.friday = friday;
        return this;
    }

    public Day getSaturday() {
        return saturday;
    }

    public void setSaturday(Day saturday) {
        this.saturday = saturday;
    }

    public Week withSaturday(Day saturday) {
        this.saturday = saturday;
        return this;
    }

    public Day getSunday() {
        return sunday;
    }

    public void setSunday(Day sunday) {
        this.sunday = sunday;
    }

    public Week withSunday(Day sunday) {
        this.sunday = sunday;
        return this;
    }

}
