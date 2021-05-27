package com.example.whattoeat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class mealplan_Adapter extends RecyclerView.Adapter<mealplan_Adapter.MealPlanHolder> {
    private Context context;

    mealplan_Adapter(Context context){
        this.context = context;
    }

    @Override
    public mealplan_Adapter.MealPlanHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_menu_meal, parent, false);
        return new MealPlanHolder(view);
    }
    @Override
    public void onBindViewHolder (mealplan_Adapter.MealPlanHolder holder, final int position){

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MealPlanHolder extends RecyclerView.ViewHolder{
        private TextView dia_semana;
        private TextView tv_nombrea;
        private TextView tv_nombreb;
        private TextView tv_nombrec;
        private TextView tv_npersa;
        private TextView tv_npersb;
        private TextView tv_npersc;
        private TextView tv_tiempoa;
        private TextView tv_tiempob;
        private TextView tv_tiempoc;

        private ImageButton desayuno;
        private ImageButton comida;
        private ImageButton cena;
        private CardView cardView;

        public MealPlanHolder(View itemView){
            super(itemView);
             dia_semana = itemView.findViewById(R.id.dia_semana);
             tv_nombrea = itemView.findViewById(R.id.tv_nombre_a);
             tv_nombreb = itemView.findViewById(R.id.tv_nombreb);
             tv_nombrec = itemView.findViewById(R.id.tv_nombrec);
             tv_npersa = itemView.findViewById(R.id.tv_npersa);
             tv_npersb = itemView.findViewById(R.id.tv_npersb);
             tv_npersc = itemView.findViewById(R.id.tv_npersc);
             tv_tiempoa = itemView.findViewById(R.id.tv_tiempoa);
             tv_tiempob = itemView.findViewById(R.id.tv_tiempob);
             tv_tiempoc = itemView.findViewById(R.id.tv_tiempoc);
             desayuno = itemView.findViewById(R.id.desayuno);
             comida = itemView.findViewById(R.id.comida);
             cena = itemView.findViewById(R.id.cena);
             cardView =itemView.findViewById(R.id.cv_meal);
        }
    }

//TODO montar lista, plan semanal con llamada, itemclicklistener en imagenbutton, colores y tema

}
