
package com.example.whattoeat.RecetaInfo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Comidas implements Parcelable {
    @SerializedName("recipes")
    @Expose
    private List<Recipes> recipes = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Comidas() {
    }

    /**
     *
     * @param recipes
     */
    public Comidas(List<Recipes> recipes) {
        super();
        this.recipes = recipes;
    }

    protected Comidas(Parcel in) {
        recipes = in.createTypedArrayList(Recipes.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(recipes);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Comidas> CREATOR = new Creator<Comidas>() {
        @Override
        public Comidas createFromParcel(Parcel in) {
            return new Comidas(in);
        }

        @Override
        public Comidas[] newArray(int size) {
            return new Comidas[size];
        }
    };

    public List<Recipes> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipes> recipes) {
        this.recipes = recipes;
    }

    public static Creator<Comidas> getCREATOR() {
        return CREATOR;
    }
}
