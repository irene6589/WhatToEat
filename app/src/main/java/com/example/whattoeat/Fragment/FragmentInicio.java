package com.example.whattoeat.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.whattoeat.R;
import com.example.whattoeat.RecetaInfo.Comidas;
import com.example.whattoeat.RecetaInfo.Recipes;
import com.example.whattoeat.RecipeInfoFragments.RecipeInfoFragment;
import com.example.whattoeat.RecipeInfoFragments.RecipeMaterialsFragment;
import com.example.whattoeat.RecipeInfoFragments.RecipePreparationFragment;
import com.example.whattoeat.ServiceClient.ServiceClient;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/*
 *
 * Hecho por Alberto Izquierdo Orozco
 *
 */

public class FragmentInicio extends Fragment {

    private ServiceClient webServiceClient;
    private TextView recipePlatesTV, recipeNameTV, recipeMinutesTV;
    private ImageView recipeImage;
    private SwipeRefreshLayout swipere;
    private TabLayout tabLayout;
    Comidas recipeData;
    Recipes pasarReceta;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.recipe_with_id_info, container, false);

        recipePlatesTV = root.findViewById(R.id.recipePlatesTV);
        recipeNameTV = root.findViewById(R.id.recipeNameTV);
        recipeMinutesTV = root.findViewById(R.id.recipeMinutesTV);
        recipeImage = root.findViewById(R.id.recipeImage);

        tabLayout = root.findViewById(R.id.tabLayout);


        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        TabLayout.Tab tab2 = tabLayout.getTabAt(1);


        swipere = root.findViewById(R.id.swipere);
        swipere.setColorSchemeResources(R.color.white);
        swipere.setProgressBackgroundColorSchemeResource(R.color.black);



        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        inicioRetrofit();
        obtenerDatos();


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int id = tab.getPosition();
                navigateToFragment(id);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int id = tab.getPosition();
                Log.d("TABS", "Tab " + (id + 1) + " desmarcado");

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

                int id = tab.getPosition();
                Toast.makeText(getContext(), "Tab " + (id + 1) + " reelegido", Toast.LENGTH_SHORT).show();

            }
        });




        swipere.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                simularCarga();
                obtenerDatos();
            }
        });

    }
    private void navigateToFragment(int itemId) {
//        TabLayout.Tab tabPulsado = tabLayout.getTabAt(itemId);
//        String title = String.valueOf(tabPulsado.getText());

        Fragment fragment = new Fragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("idReceta", pasarReceta);


        switch (itemId) {
            default:
                fragment = new RecipeInfoFragment();
                fragment.setArguments(bundle);
                break;

            case 1:
                fragment = new RecipeMaterialsFragment();
                fragment.setArguments(bundle);
                break;

            case 2:
                fragment = new RecipePreparationFragment();
                fragment.setArguments(bundle);
                break;
        }


        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.recipeFrameLayout, fragment);
        transaction.commit();


    }



    private void simularCarga(){
        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                swipere.setRefreshing(false);
            }
        }, 700);

    }
    private void obtenerDatos(){


        Call<Comidas> peticion = webServiceClient.getRandom(ServiceClient.KEY);
        peticion.enqueue(new Callback<Comidas>() {
            @Override
            public void onResponse(Call<Comidas> call, Response<Comidas> response) {
                if (response.isSuccessful()){
                    int code = response.code();
                    if(response.body() != null){

                        recipeData = response.body();


                        Bundle bundle = new Bundle();
                        pasarReceta = recipeData.getRecipes().get(0);
                        bundle.putParcelable("KeyComidas", recipeData);

                        navigateToFragment(0);


                        recipePlatesTV.setText("Personas:" + response.body().getRecipes().get(0).getServings());
                        recipeNameTV.setText(String.valueOf(response.body().getRecipes().get(0).getTitle()));
                        recipeMinutesTV.setText("Minutos: "+ String.valueOf(response.body().getRecipes().get(0).getReadyInMinutes()));
                        String imagencomida = response.body().getRecipes().get(0).getImage();
                        if(imagencomida != null){
                            Picasso.get().load(imagencomida).into(recipeImage);
                        }
                    }else{
                        showErrorMessage();
                    }
                }else{
                    showErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<Comidas> call, Throwable t) {
                Log.d("RETROFIT", "Error: " + t.getMessage());
            }
        });

    }
    private void inicioRetrofit() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServiceClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();
        webServiceClient = retrofit.create(ServiceClient.class);
    }
    private void showErrorMessage() {
        Toast.makeText(getContext(), "Ha ocurrido un error desconocido. Por favor, vuelve a intentarlo más tarde.", Toast.LENGTH_SHORT).show();
    }




}
