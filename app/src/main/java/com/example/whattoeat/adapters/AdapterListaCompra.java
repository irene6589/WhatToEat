package com.example.whattoeat.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whattoeat.R;
import com.example.whattoeat.models.Item;
import com.example.whattoeat.models.ListaCompra;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterListaCompra extends RecyclerView.Adapter<AdapterListaCompra.ListaCompraHolder>{

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
       Item item = listaitem.get(position);

       holder.tv_nombreproducto.setText(item.getName());

       String url_final = url + item.getAisle() + "-240x150.jpg";
        Picasso.get().load(url_final).into(holder.img_comida);

    }

    @Override
    public int getItemCount() {
        return listaitem.size();
    }

    public class ListaCompraHolder extends RecyclerView.ViewHolder {

        private final TextView tv_nombreproducto;
        private final ImageView img_delete;
        private  final  ImageView img_comida;



        public ListaCompraHolder(@NonNull View itemView) {
            super(itemView);
            tv_nombreproducto = itemView.findViewById(R.id.tv_nombreproducto);
            img_delete = itemView.findViewById(R.id.img_delete);
            img_comida = itemView.findViewById(R.id.img_comida);
        }
    }

    public void setLista(List<Item> lista) {
        this.listaitem = lista;
        notifyDataSetChanged();
    }
}
