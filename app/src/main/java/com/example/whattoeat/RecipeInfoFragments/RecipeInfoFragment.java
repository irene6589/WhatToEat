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

public class RecipeInfoFragment extends Fragment {
    /*
    *
    * Hecho por Francisco Ismael Martinez Alonso
    *
    */


    TextView recipeSummaryTV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View infoView = inflater.inflate(R.layout.info_fragment,container,false);
        recipeSummaryTV = infoView.findViewById(R.id.recipeSummaryTV);
        return infoView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        pillar el bundle con los datos
        Bundle bundle = this.getArguments();
        if(bundle != null){
//            TODO poner la key del bundle
            Recipes recipes = bundle.getParcelable("");
            recipeSummaryTV.setText(recipes.getSummary());
        }
    }
}
