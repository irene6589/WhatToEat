package com.example.whattoeat.MealPlanWeek;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whattoeat.R;
import com.squareup.picasso.Picasso;

public class mealplan_Adapter extends RecyclerView.Adapter<mealplan_Adapter.MealPlanHolder> {
    private Context context;
    private MealPlanWeek mealplanw;
    public mealplan_Adapter(Context context){
        this.context = context;
    }

    @Override
    public mealplan_Adapter.MealPlanHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout_mealplan, parent, false);

        return new MealPlanHolder(view);
    }
    @Override
    public void onBindViewHolder (mealplan_Adapter.MealPlanHolder holder, final int position){
        Day day = new Day();
        switch (position){
            case 0:
                holder.dia_semana.setText("Lunes");
                day = mealplanw.getWeek().getMonday();
                break;
            case 1:
                holder.dia_semana.setText("Martes");
                day = mealplanw.getWeek().getTuesday();
                break;
            case 2:
                holder.dia_semana.setText("Miércoles");
                day = mealplanw.getWeek().getWednesday();
                break;
            case 3:
                holder.dia_semana.setText("Jueves");
                day = mealplanw.getWeek().getThursday();
                break;
            case 4:
                holder.dia_semana.setText("Viernes");
                day = mealplanw.getWeek().getFriday();
                break;
            case 5:
                holder.dia_semana.setText("Sábado");
                day = mealplanw.getWeek().getSaturday();
                break;
            case 6:
                holder.dia_semana.setText("Domingo");
                day = mealplanw.getWeek().getSunday();
                break;

        }

        holder.tv_nombrea.setText(day.getMeals().get(0).getTitle());
        holder.tv_nombreb.setText(day.getMeals().get(1).getTitle());
        holder.tv_nombrec.setText(day.getMeals().get(2).getTitle());

        holder.tv_npersa.setText(Integer.toString(day.getMeals().get(0).getServings()));
        holder.tv_npersb.setText(Integer.toString(day.getMeals().get(1).getServings()));
        holder.tv_npersc.setText(Integer.toString(day.getMeals().get(2).getServings()));

        holder.tv_tiempoa.setText(Integer.toString(day.getMeals().get(0).getReadyInMinutes()));
        holder.tv_tiempob.setText(Integer.toString(day.getMeals().get(1).getReadyInMinutes()));
        holder.tv_tiempoc.setText(Integer.toString(day.getMeals().get(2).getReadyInMinutes()));

        Picasso.get().load(day.getMeals().get(0).getImageType()).into(holder.desayuno);
        Picasso.get().load(day.getMeals().get(1).getImageType()).into(holder.comida);
        Picasso.get().load(day.getMeals().get(2).getImageType()).into(holder.cena);

        holder.desayuno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        holder.comida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.cena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public int getItemCount() {
        if(mealplanw != null){
            return 7;
        }
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

public void addMealPlan(MealPlanWeek mpw){
        mealplanw = mpw;
        notifyDataSetChanged();
}
//TODO montar lista, plan semanal con llamada, itemclicklistener en imagenbutton, colores y tema

}
