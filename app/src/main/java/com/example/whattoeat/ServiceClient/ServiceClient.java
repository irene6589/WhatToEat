package com.example.whattoeat.ServiceClient;

import com.example.whattoeat.MealPlanWeek.MealPlanWeek;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceClient {

    String BASE_URL = "https://api.spoonacular.com/";

    //Parte de Irene, llamada al mealplanner para crear el plan semanal
    @GET("mealplanner/generate")
    Call<MealPlanWeek> getMealPlanWeek();


}
