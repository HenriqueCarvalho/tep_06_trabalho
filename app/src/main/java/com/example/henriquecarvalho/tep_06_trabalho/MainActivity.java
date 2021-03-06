package com.example.henriquecarvalho.tep_06_trabalho;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle("Minhas Viagens test");

        // No material design setLog não funciona
        actionBar.setLogo(R.drawable.ic_action_share);

        //actionBar.setHomeAsUpIndicator(R.drawable.logo);
        //actionBar.setDisplayHomeAsUpEnabled(true);

        MySingleton tmp = MySingleton.getInstance();

        Log.d(TAG, "onCreate()");
    }

   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla o menu com os botões da action bar
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void newTravelTextViewClicked(View view){
        Intent intent = new Intent(this, NewTravelActivity.class);
        startActivity(intent);
    }

    public void newCostTextViewClicked(View view){
        Intent intent = new Intent(this, NewCostActivity.class);
        startActivity(intent);
    }

    public void myTravelsActivityTextViewClicked(View view){
        Intent intent = new Intent(this, MyTravelsActivity.class);
        startActivity(intent);
    }
}