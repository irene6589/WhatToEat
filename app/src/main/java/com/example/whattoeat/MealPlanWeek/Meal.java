package com.example.whattoeat.MealPlanWeek;
import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meal implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("imageType")
    @Expose
    private String imageType;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("readyInMinutes")
    @Expose
    private int readyInMinutes;
    @SerializedName("servings")
    @Expose
    private int servings;
    @SerializedName("sourceUrl")
    @Expose
    private String sourceUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Meal withId(int id) {
        this.id = id;
        return this;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public Meal withImageType(String imageType) {
        this.imageType = imageType;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Meal withTitle(String title) {
        this.title = title;
        return this;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(int readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public Meal withReadyInMinutes(int readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
        return this;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public Meal withServings(int servings) {
        this.servings = servings;
        return this;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public Meal withSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
        return this;
    }

}


