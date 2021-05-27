package com.example.whattoeat.ServiceClient;

import com.example.whattoeat.MealPlanWeek.MealPlanWeek;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServiceClient {

    String BASE_URL = "https://api.spoonacular.com/";

    //Parte de Irene, llamada al mealplanner para crear el plan semanal
    @GET("mealplanner/generate")
    Call<MealPlanWeek> getMealPlanWeek();



    //Parte de Ismael, llamada para obtener informacion de una receta en funcion de la id
    @GET("recipes/{id}/information")
    Call<Recipes> getRecipeById(@Path("id") int id);

}
