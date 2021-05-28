package com.example.whattoeat.MealPlanWeek;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Day implements Serializable {

        @SerializedName("meals")
        @Expose
        private List<Meal> meals = null;
        @SerializedName("nutrients")
        @Expose
        private Nutrients nutrients;


        public List<Meal> getMeals() {
            return meals;
        }

        public void setMeals(List<Meal> meals) {
            this.meals = meals;
        }

        public Day withMeals(List<Meal> meals) {
            this.meals = meals;
            return this;
        }

        public Nutrients getNutrients() {
            return nutrients;
        }

        public void setNutrients(Nutrients nutrients) {
            this.nutrients = nutrients;
        }

        public Day withNutrients(Nutrients nutrients) {
            this.nutrients = nutrients;
            return this;
        }

    }


