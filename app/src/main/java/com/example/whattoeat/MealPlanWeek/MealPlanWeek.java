package com.example.whattoeat.MealPlanWeek;
import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MealPlanWeek implements Serializable {

    @SerializedName("week")
    @Expose
    private Week week;


    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public MealPlanWeek withWeek(Week week) {
        this.week = week;
        return this;
    }

}
