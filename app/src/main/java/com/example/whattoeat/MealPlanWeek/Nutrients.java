package com.example.whattoeat.MealPlanWeek;
import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nutrients implements Serializable {

    @SerializedName("calories")
    @Expose
    private double calories;
    @SerializedName("protein")
    @Expose
    private double protein;
    @SerializedName("fat")
    @Expose
    private double fat;
    @SerializedName("carbohydrates")
    @Expose
    private double carbohydrates;

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public Nutrients withCalories(double calories) {
        this.calories = calories;
        return this;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public Nutrients withProtein(double protein) {
        this.protein = protein;
        return this;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public Nutrients withFat(double fat) {
        this.fat = fat;
        return this;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Nutrients withCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
        return this;
    }

}
