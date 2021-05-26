package com.example.whattoeat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        BottomNavigationView navigationView = findViewById(R.id.bottomNavigationView);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
               // navigateToFragment(id);
                return true;
            }
        });

        navigationView.setSelectedItemId(R.id.nav_home);

    }
    private void navigateToFragment(int itemId) {
        Fragment fragment;
        String title;

        switch (itemId) {
            default:
                    /*fragment = new InicioFragment();
                    title = "Escuela Estech";
                    break;

                case R.id.nav_home:
                    fragment = new InicioFragment();
                    title = "Escuela Estech";
                    break;

                case R.id.nav_blog:
                    fragment = new BlogFragment();
                    title = "Blog";
                    break;

                case R.id.nav_galeria:
                    fragment = new GaleriaFragment();
                    title = "Galería";
                    break;*/


        }
            /*FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.frame_layout, fragment);
            //transaction.addToBackStack(null);
            transaction.commit();
            setTitle(title);*/

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.nav_close:
                onBackPressed();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Atención");
        builder.setMessage("¿Desea salir de la aplicación?");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finishAffinity();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}