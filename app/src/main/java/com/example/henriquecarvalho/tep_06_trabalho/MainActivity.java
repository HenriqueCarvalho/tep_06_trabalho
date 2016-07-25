package com.example.henriquecarvalho.tep_06_trabalho;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle("Minhas Viagens test");

        // No material design setLog não funciona
        //actionBar.setLogo(R.drawable.ic_action_share);

        actionBar.setHomeAsUpIndicator(R.drawable.ic_action_share);
        actionBar.setDisplayHomeAsUpEnabled(true);
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

    public void myTravelsActivityTextViewClicked(View view){
        Intent intent = new Intent(this, MyTravelsActivity.class);
        startActivity(intent);
    }
}