package com.example.whattoeat.ServiceClient;

import com.example.whattoeat.MealPlanWeek.MealPlanWeek;
import com.example.whattoeat.RecetaInfo.Comidas;
import com.example.whattoeat.RecetaInfo.Recipes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceClient {

    String BASE_URL = "https://api.spoonacular.com/";
    public static final String KEY = "9e6ee583540248368a76b7d175d22e5f";

    //Parte de Irene, llamada al mealplanner para crear el plan semanal
    @GET("mealplanner/generate")
    Call<MealPlanWeek> getMealPlanWeek();



    //Parte de Ismael, llamada para obtener informacion de una receta en funcion de la id
    @GET("recipes/{id}/information")
    Call<Recipes> getRecipeById(@Path("id") int id);


    //Parte de Alberto llamada al método random
    @GET("recipes/random")
    Call<Comidas> getRandom(@Query("apiKey")String key);

}
