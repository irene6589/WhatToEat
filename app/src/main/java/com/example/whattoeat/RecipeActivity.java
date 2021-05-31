package com.example.whattoeat;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.whattoeat.RecetaInfo.Comidas;
import com.example.whattoeat.RecetaInfo.Recipes;
import com.example.whattoeat.RecipeInfoFragments.RecipeInfoFragment;
import com.example.whattoeat.RecipeInfoFragments.RecipeMaterialsFragment;
import com.example.whattoeat.RecipeInfoFragments.RecipePreparationFragment;
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
////            TODO sustituir la key de la id por la que ponga Irene
            recipeId = bundle.getInt("");
        }else {
////            ponemos una id de una receta de la api como ejemplo
            recipeId = 660447;
        }
        setView();
        initRetrofit();
        loadPetition();

//        TODO el tabSelectedListener peta por:
//         Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'void com.google.android.material.tabs.TabLayout.addOnTabSelectedListener(com.google.android.material.tabs.TabLayout$OnTabSelectedListener)' on a null object reference
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            Fragment fragment;
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                int tabPosition = tab.getPosition();
//                Fragment fragmentRecetaPorId = new RecipeInfoFragment();
//                switch (tabPosition){
//                    case 1:
//                          fragmentRecetaPorId = new RecipeInfoFragment();
////                         navigateToFragment(fragmentInfo);
//                        break;
//                    case 2:
//                        fragmentRecetaPorId = new RecipeMaterialsFragment();
//
//
//                        break;
//                    case 3:
//                        fragmentRecetaPorId = new RecipePreparationFragment();
//
//                        break;
//                    default:
//
//                        break;
//                }
//                FragmentManager fm = getSupportFragmentManager();
//                FragmentTransaction transaction = fm.beginTransaction();
//                transaction.replace(R.id.recipeFrameLayout, fragmentRecetaPorId);
//                transaction.commit();
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });

    }

    private void setView(){
        recipeImage = findViewById(R.id.recipeImage);
        //TODO la app peta porque dice que el recipeNameTV = null y no se porque
        recipeNameTV = findViewById(R.id.recipeNameTV);
        recipeMinutesTV = findViewById(R.id.recipeMinutesTV);
        recipePlatesTV = findViewById(R.id.recipePlatesTV);
        exitButton = findViewById(R.id.floatingActionButtonExit);
        addShopListButton = findViewById(R.id.floatingActionButtonAddToShopList);
        tabLayout = findViewById(R.id.tabLayout);
        frameLayout = findViewById(R.id.recipeFrameLayout);


    }

    private void initRetrofit(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(webServiceClient.BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(httpClientBuilder.build()).build();
        webServiceClient = retrofit.create(ServiceClient.class);
    }

    private void loadPetition(){
        Call<Recipes> recipeInfoPetition = webServiceClient.getRecipeById(recipeId,ServiceClient.KEY);
        recipeInfoPetition.enqueue(new Callback<Recipes>() {
            @Override
            public void onResponse(Call<Recipes> call, Response<Recipes> response) {
                if(response.isSuccessful()){
                    if(response.body() != null){
                        Recipes recipeDataPorId = response.body();

                        recipeNameTV.setText(response.body().getTitle());
//                        recipeMinutesTV.setText(recipeDataPorId.getReadyInMinutes().toString());
//                        recipePlatesTV.setText(recipeDataPorId.getServings().toString());

//                    setupView(recipeDataPorId);
                    }else{
                        Toast.makeText(RecipeActivity.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Recipes> call, Throwable t) {
                Toast.makeText(RecipeActivity.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
            }
        });

//        recipeInfoPetition.enqueue(new Callback<Comidas>() {
//            @Override
//            public void onResponse(Call<Comidas> call, Response<Comidas> response) {
//                if(response.isSuccessful()){
//                    if(response.body() != null){
//                        Comidas recipeDataPorId = response.body();
//
//                        recipeNameTV.setText(response.body().getRecipes().get(0).getTitle());
////                        recipeMinutesTV.setText(recipeDataPorId.getReadyInMinutes().toString());
////                        recipePlatesTV.setText(recipeDataPorId.getServings().toString());
//
////                    setupView(recipeDataPorId);
//                    }else{
//                        Toast.makeText(RecipeActivity.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//
////            @Override
////            public void onFailure(Call<Comidas> call, Throwable t) {
////
////            }
//
//            @Override
//            public void onFailure(Call<Comidas> call, Throwable t) {
//                Toast.makeText(RecipeActivity.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
//            }
//        });


    }

    private void setupView(Recipes recipeData){

        recipeNameTV.setText(recipeData.getTitle());
        recipeMinutesTV.setText(recipeData.getReadyInMinutes().toString());
        recipePlatesTV.setText(recipeData.getServings().toString());
//       TODO poner la imagen con el picasso


    }

    //TODO terminar este metodo
    private void navigateToFragment(){

    }


}
