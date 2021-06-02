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
import com.example.whattoeat.RecetaInfo.ExtendedIngredient;

import java.util.List;

public class RecipePreparationFragment extends Fragment {

    /*
     *
     *Hecho por Francisco Ismael Martinez Alonso
     *
     */

    TextView ingredientsTV;
    TextView instructionsTV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View preparationView = inflater.inflate(R.layout.preparation_fragment,container,false);

        ingredientsTV = preparationView.findViewById(R.id.ingredientsTV);
        instructionsTV = preparationView.findViewById(R.id.instructionsTV);

        return preparationView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //pillar el bundle con los datos
        Bundle bundle = this.getArguments();
        if(bundle != null){
            //hacer un bucle para rellenar un string con los igredientes

//            TODO poner clave
            Recipes recipe = bundle.getParcelable("idReceta");
           String allIngredients = "";
           //Bucle para pillar todos los ingredientes y meterlos en un array
            for (int i = 0; i < recipe.getAnalyzedInstructions().get(0).getSteps().size(); i++){
//                TODO pillar steps > ingredients > name
                for(int j = 0; j<recipe.getAnalyzedInstructions().get(0).getSteps().get(i).getIngredients().size(); j++){
                    //TODO meter salto de linea
                    allIngredients = allIngredients + recipe.getAnalyzedInstructions().get(0).getSteps().get(i).getIngredients().get(j).getName();
                    allIngredients += "\n";
                }

                //allIngredients = allIngredients +"salto de linea"+ recipe.getExtendedIngredients().get(i).getName();
            }


//            hacer un array para poner todos los pasos en un string
            //String allSteps = "";
//            for(int i = 0; i < recipe.getAnalyzedInstructions().getSteps().getStep().length; i++){
//                //                TODO poner un salto de linea donde pone salto de linea
//                allSteps = allSteps + "salto de linea" + recipe.getAnalyzedInstructions().getSteps().get(i).getStep();
//            }
            //allSteps = recipe.getInstructions();

            ingredientsTV.setText(allIngredients);
            instructionsTV.setText(recipe.getInstructions());

        }



    }
}
