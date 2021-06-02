package com.example.whattoeat.ServiceClient;

import com.example.whattoeat.MealPlanWeek.MealPlanWeek;
import com.example.whattoeat.RecetaInfo.Recipes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceClient {
    public String KEY ="a78e7398752a4353b2121bb5a17a3f4f";

    String BASE_URL = "https://api.spoonacular.com/";
//    public static final String KEY = "9e6ee583540248368a76b7d175d22e5f";

    //Parte de Irene, llamada al mealplanner para crear el plan semanal
    @GET("mealplanner/generate")
    Call<MealPlanWeek> getMealPlanWeek(@Query("apiKey")String key);



    //Parte de Ismael, llamada para obtener informacion de una receta en funcion de la id
    @GET("recipes/{id}/information")
    Call<Recipes> getRecipeById(@Path("id") int id, @Query("apiKey")String key);

}
