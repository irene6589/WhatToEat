package com.example.whattoeat.RecipeInfoFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.whattoeat.R;

public class RecipeMaterialsFragment extends Fragment {

    /*
     *
     *Hecho por Francisco Ismael Martinez Alonso
     *
     */

    TextView materialsTV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View materialsView = inflater.inflate(R.layout.utensilios_fragment,container,false);

        materialsTV = materialsView.findViewById(R.id.materialsTV);

        return  materialsView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        pillar el bundle y poner los datos
        Bundle bundle = this.getArguments();
        if(bundle != null){
//            TODO poner clave
            Recipes recipes = bundle.getParcelable("");
//            hacer un string con los equipment que necesita la receta
            String equipamiento = "";
//          bucle for anidado para obtener todos los equipamientos necesarios
            for(int i = 0; i < recipes.getAnalyzedInstructions().length; i++){

//                equipomiento = equipomiento + recipes.getAnalyzedInstructions().getSteps().getEquipment();
                for(int o = 0; o < recipes.getAnalyzedInstructions().getSteps(); o++){

                    for(int u = 0; u < recipes.getAnalyzedInstructions().getSteps().getEquipment(); u++){
//                        TODO poner un salto de linea donde pone salto de linea
                        equipamiento = equipamiento + " salto de linea " + recipes.getAnalyzedInstructions(i).getSteps(o).getEquipment(u);
                    }
                }

            }
            materialsTV.setText(equipamiento);
        }

    }
}