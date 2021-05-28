package com.example.whattoeat;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.whattoeat.ServiceClient.ServiceClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeActivity extends AppCompatActivity {

    /*
    *
    * Hecho por Francisco Ismael Martinez Alonso
    * Mostrar los datos de una receta en funcion de su id
    *
    * */

    private ImageView recipeImage;
    private TextView recipeNameTV, recipeMinutesTV, recipePlatesTV;
    private FloatingActionButton exitButton, addShopListButton;
    private TabLayout tabLayout;
    private FrameLayout frameLayout;

    private ServiceClient webServiceClient;

    int recipeId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        TODO hacer que pille el bundle con la id de la receta que se envia desde el holder del mealplan de irene
        Bundle bundle = getIntent().getExtras();
//        TODO sustituir la key del bundle por la que ponga Irene
        if(bundle != null && bundle.containsKey("")){
//            TODO sustituir la key de la id por la que ponga Irene
            recipeId = bundle.getInt("");
        }else {
//            ponemos una id de una receta de la api como ejemplo
            recipeId = 660447;
        }



        recipeImage = findViewById(R.id.recipeImage);
        recipeNameTV = findViewById(R.id.recipeNameTV);
        recipeMinutesTV = findViewById(R.id.recipeMinutesTV);
        recipePlatesTV = findViewById(R.id.recipePlatesTV);
        exitButton = findViewById(R.id.floatingActionButtonExit);
        addShopListButton = findViewById(R.id.floatingActionButtonAddToShopList);
        tabLayout = findViewById(R.id.tabLayout);
        frameLayout = findViewById(R.id.recipeFrameLayout);

        initRetrofit();
        loadPetition();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabPosition = tab.getPosition();
                switch (tabPosition){
                    case 1:
//                        fragment RecipeInfoFragment

                        break;
                    case 2:
//                        fragment RecipeMaterialsFragment

                        break;
                    case 3:
//                      fragment RecipePreparationFragment

                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
    private void initRetrofit(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(webServiceClient.BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(httpClientBuilder.build()).build();
        webServiceClient = retrofit.create(ServiceClient.class);
    }

    private void loadPetition(){
        Call<Recipes> recipeInfoPetition = webServiceClient.getRecipeById(recipeId);
        recipeInfoPetition.enqueue(new Callback<Recipes>() {
            @Override
            public void onResponse(Call<Recipes> call, Response<Recipes> response) {
                if(response.body() != null){
                    setupView(response.body());
                }else{
                    Toast.makeText(RecipeActivity.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Recipes> call, Throwable t) {
                Toast.makeText(RecipeActivity.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupView(Recipes recipeData){

        recipeNameTV.setText(recipeData.getTitle());
        recipeMinutesTV.setText(recipeData.getReadyInMinutes().toString);
        recipePlatesTV.setText(recipeData.getServings().toString);
//       TODO poner la imagen con el picasso

    }

    //TODO terminar este metodo
    private void navigateToFragment(){

    }


}
