package com.example.whattoeat;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class RecipeActivity extends AppCompatActivity {

    private ImageView recipeImage;
    private TextView recipeNameTV, recipeMinutesTV, recipePlatesTV;
    private FloatingActionButton exitButton, addShopListButton;
    private TabLayout tabLayout;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recipeImage = findViewById(R.id.recipeImage);
        recipeNameTV = findViewById(R.id.recipeNameTV);
        recipeMinutesTV = findViewById(R.id.recipeMinutesTV);
        recipePlatesTV = findViewById(R.id.recipePlatesTV);
        exitButton = findViewById(R.id.floatingActionButtonExit);
        addShopListButton = findViewById(R.id.floatingActionButtonAddToShopList);
        tabLayout = findViewById(R.id.tabLayout);
        frameLayout = findViewById(R.id.recipeFrameLayout);


    }
}
