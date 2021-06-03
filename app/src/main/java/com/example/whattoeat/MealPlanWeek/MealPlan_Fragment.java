package com.example.whattoeat.MealPlanWeek;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whattoeat.R;
import com.example.whattoeat.ServiceClient.ServiceClient;

import org.jetbrains.annotations.NotNull;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MealPlan_Fragment extends Fragment {
    private RecyclerView rv_Menu;
    private ServiceClient ServiceClient;
    private mealplan_Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle mealplanF) {
        View view = inflater.inflate(R.layout.fragment_menu_meal, container, false);
        adapter = new mealplan_Adapter(getContext());
        rv_Menu = view.findViewById(R.id.rv_menu);
        rv_Menu.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rv_Menu.setAdapter(adapter);
        iniciarRetrofit();
        lanzarPerticion();
        return view;
    }

    private void iniciarRetrofit(){
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ServiceClient.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClientBuilder.build())
                    .build();
            ServiceClient = retrofit.create(ServiceClient.class);
        }
    private void lanzarPerticion() {

            Call<MealPlanWeek> call = ServiceClient.getMealPlanWeek(ServiceClient.KEY);
            call.enqueue(new Callback<MealPlanWeek>() {
                @Override
                public void onResponse(@NotNull Call<MealPlanWeek> call, @NotNull Response<MealPlanWeek> response) {
                    if (response.isSuccessful()) {
                        MealPlanWeek mealplan = response.body();
                        adapter.addMealPlan(mealplan);
                    }
                }

                @Override
                public void onFailure(@NotNull Call<MealPlanWeek> call, @NotNull Throwable t) {

                }
            });
        }
}



