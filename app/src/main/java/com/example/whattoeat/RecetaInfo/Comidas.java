package com.example.whattoeat.RecetaInfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comidas {

    @SerializedName("recipes")
    @Expose
    private List<Recipes> recipes = null;


    public Comidas() {
    }


    public Comidas(List<Recipes> recipes) {
        super();
        this.recipes = recipes;
    }

    public List<Recipes> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipes> recipes) {
        this.recipes = recipes;
    }

}