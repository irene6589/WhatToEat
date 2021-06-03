package com.example.whattoeat;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.whattoeat.adapters.AdapterListaCompra;
import com.example.whattoeat.models.Aisle;
import com.example.whattoeat.models.Item;
import com.example.whattoeat.models.ListaCompra;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaActivity extends Fragment {

    private RecyclerView recyclerView;
    private AdapterListaCompra adapter;
    private WebServiceClient webServiceClient;
    private StaggeredGridLayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listacomprafragment, container, false);
        //Cambiar
        recyclerView = view.findViewById(R.id.rv_listacompra);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Linear layout mane adaptador...
        setupView();
        initRetrofit();
        lanzarPerticion();
    }
    private void setupView() {
        adapter = new AdapterListaCompra(getContext());
        layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    private void initRetrofit() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WebServiceClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();
        webServiceClient = retrofit.create(WebServiceClient.class);
    }
    private void lanzarPerticion() {

        Call<ListaCompra> peticion = webServiceClient.getlistacompra(WebServiceClient.KEY);

        peticion.enqueue(new Callback<ListaCompra>() {
            @Override
            public void onResponse(Call<ListaCompra> call, Response<ListaCompra> response) {
                if (response.isSuccessful()) {
                    ListaCompra listaCompra = response.body();
                    List<Item> itemList = new ArrayList<>();
                    for(int i = 0; i < listaCompra.getAisles().size() ; i++){
                        Aisle aisle = listaCompra.getAisles().get(i);
                        for (int j = 0; j < aisle.getItems().size(); j++){
                            Item item = aisle.getItems().get(j);
                                itemList.add(item);
                        }
                    }
                    adapter.setLista(itemList);
                } else {
                    showErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<ListaCompra> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
            }
        });

    }

    // Metodo: Mensaje de error
    private void showErrorMessage() {
        Toast.makeText(getContext(), "Ha ocurrido un error desconocido. Por favor, vuelve a intentarlo más tarde.", Toast.LENGTH_SHORT).show();
    }
}


