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
import com.example.whattoeat.RecetaInfo.Recipes;

import static android.os.Build.VERSION_CODES.O;

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

            Recipes recipe = bundle.getParcelable("idReceta");
//            hacer un string con los equipment que necesita la receta
            String equipamiento = "";
//          bucle for anidado para obtener todos los equipamientos necesarios
//            for(int i = 0; i < recipes.getAnalyzedInstructions().size(); i++){
//
////                equipomiento = equipomiento + recipes.getAnalyzedInstructions().getSteps().getEquipment();
//                for(int j = 0; j < recipes.getAnalyzedInstructions().get(i).getSteps().size(); j++){
//
//                    for(int u = 0; u < recipes.getAnalyzedInstructions().get(i).getSteps().get(j).getEquipment().size(); u++){

//                        equipamiento = equipamiento + recipes.getAnalyzedInstructions().get(i).getSteps().get(j).getEquipment().get(u);
//                    }
//                }
//
//            }
            for (int i = 0; i < recipe.getAnalyzedInstructions().get(0).getSteps().size(); i++){

                for(int j = 0; j<recipe.getAnalyzedInstructions().get(0).getSteps().get(i).getEquipment().size(); j++){

                    equipamiento = equipamiento + recipe.getAnalyzedInstructions().get(0).getSteps().get(i).getEquipment().get(j).getName();
                    equipamiento += "\n";
                }

                //allIngredients = allIngredients +"salto de linea"+ recipe.getExtendedIngredients().get(i).getName();
            }
            materialsTV.setText(equipamiento);
        }

    }
}
