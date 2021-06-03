package com.example.whattoeat.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whattoeat.R;
import com.example.whattoeat.RecipeActivity;
import com.example.whattoeat.ServiceClient.ServiceClient;
import com.example.whattoeat.models.Aisle;
import com.example.whattoeat.models.Item;
import com.example.whattoeat.models.ListaCompra;
import com.example.whattoeat.respuestaDelete;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdapterListaCompra extends RecyclerView.Adapter<AdapterListaCompra.ListaCompraHolder>{
    Item item;
    ServiceClient serviceClient;
    private List<Item> listaitem;
    private final Context context;
    private final String url = "https://spoonacular.com/recipeImages/";
    public AdapterListaCompra(Context context) {
        this.listaitem = new ArrayList<>();
        this.context = context;
    }


    @NonNull
    @Override
    public AdapterListaCompra.ListaCompraHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.holderlistacompra, parent, false);
        return new ListaCompraHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListaCompra.ListaCompraHolder holder, int position) {
       item = listaitem.get(position);

       holder.tv_nombreproducto.setText(item.getName());

       String url_final = url + item.getAisle() + "-240x150.jpg";
        Picasso.get().load(url_final).into(holder.img_comida);

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                TODO peticion borrar
                initRetrofit();
                peticionBorrar();

            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Todo intent a receta por id
                Intent intent = new Intent(context, RecipeActivity.class);
                intent.putExtra("mealplanid",item.getAisle());
                context.startActivity(intent);
            }
        });

    }
    //peticion de borrar (el delete es parte de isma)
    private void peticionBorrar(){
        Call<respuestaDelete> deletePetition = serviceClient.deleteRecipe(item.getId(), ServiceClient.KEY);
        deletePetition.enqueue(new Callback<respuestaDelete>() {
            @Override
            public void onResponse(Call<respuestaDelete> call, Response<respuestaDelete> response) {
                if(response.isSuccessful()){
                    Toast.makeText(context, "Has borrado un objeto de la lista", Toast.LENGTH_SHORT).show();
                    //lanzar otra ves el get de Borja para actualizar la lista
                    lanzarPerticion();
                }

            }

            @Override
            public void onFailure(Call<respuestaDelete> call, Throwable t) {
                Toast.makeText(context, "Ha ocurrido un error con la peticion", Toast.LENGTH_SHORT).show();

            }
        });
    }

//    iniciar retrofit para hacer peticion delete (el delete es parte de isma)
    private void initRetrofit(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(serviceClient.BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(httpClientBuilder.build()).build();
        serviceClient = retrofit.create(ServiceClient.class);
    }
    private void lanzarPerticion() {

        Call<ListaCompra> peticion = serviceClient.getlistacompra(ServiceClient.KEY);

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
                            itemList = listaitem;
                            notifyDataSetChanged();

                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<ListaCompra> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaitem.size();
    }

    public class ListaCompraHolder extends RecyclerView.ViewHolder {

        private final TextView tv_nombreproducto;
//        private final ImageView img_delete;
        private  final  ImageView img_comida;
        private final ImageButton delete;



        public ListaCompraHolder(@NonNull View itemView) {
            super(itemView);
            tv_nombreproducto = itemView.findViewById(R.id.tv_nombreproducto);
//            img_delete = itemView.findViewById(R.id.img_delete);
            img_comida = itemView.findViewById(R.id.img_comida);
            delete = itemView.findViewById(R.id.imageButton);

        }
    }

    public void setLista(List<Item> lista) {
        this.listaitem = lista;
        notifyDataSetChanged();
    }
}
