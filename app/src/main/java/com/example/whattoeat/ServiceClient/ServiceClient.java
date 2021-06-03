package com.example.whattoeat.ServiceClient;

import com.example.whattoeat.MealPlanWeek.MealPlanWeek;
import com.example.whattoeat.RecetaInfo.Comidas;
import com.example.whattoeat.RecetaInfo.Recipes;
import com.example.whattoeat.models.Item;
import com.example.whattoeat.models.ListaCompra;
import com.example.whattoeat.models.enviarPost;
import com.example.whattoeat.respuestaDelete;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceClient {
//    public String KEY ="a78e7398752a4353b2121bb5a17a3f4f";

    String BASE_URL = "https://api.spoonacular.com/";
    public static final String KEY = "9e6ee583540248368a76b7d175d22e5f";

    //Parte de Irene, llamada al mealplanner para crear el plan semanal
    @GET("mealplanner/generate")
    Call<MealPlanWeek> getMealPlanWeek(@Query("apiKey")String key);


    //Parte de Ismael, llamada para obtener informacion de una receta en funcion de la id y borrar un objeto de la lista de la compra
    @Headers({"Content-Type: application/json"})
    @DELETE("/mealplanner/api-90001-androidapiproyectappuser/shopping-list/items/{id}?hash=86eb3764359778bec3b7b38602f901a6ff4c8e94")
    Call<respuestaDelete> deleteRecipe(@Path("id")int id, @Query("apiKey")String key);

    @GET("recipes/{id}/information")
    Call<Recipes> getRecipeById(@Path("id") int id, @Query("apiKey")String key);


    //Parte de Alberto llamada al método random
    @GET("recipes/random")
    Call<Comidas> getRandom(@Query("apiKey")String key);

    @POST("mealplanner/api-90001-androidapiproyectappuser/shopping-list/items?hash=86eb3764359778bec3b7b38602f901a6ff4c8e94")
    Call<Item> enviarReceta(@Query("apiKey") String key, @Body enviarPost enviar);


    //Parte de Borja, llamada a la lista de la compra
    @GET("mealplanner/api-90001-androidapiproyectappuser/shopping-list?hash=86eb3764359778bec3b7b38602f901a6ff4c8e94")
    Call<ListaCompra> getlistacompra(@Query("apiKey")String key);

}
