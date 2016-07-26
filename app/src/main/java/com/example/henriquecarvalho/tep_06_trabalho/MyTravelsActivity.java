package com.example.henriquecarvalho.tep_06_trabalho;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MyTravelsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = MyTravelsActivity.class.getSimpleName();

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_travels);

       // ActionBar actionBar = getSupportActionBar();
       // actionBar.setDisplayHomeAsUpEnabled(true);

        // ListView
        listView = (ListView) findViewById(R.id.listview);
        List<Travel> travels = Travel.getTravels();

        listView.setAdapter(new TravelAdapter(this, travels));
        listView.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Travel travel = (Travel) parent.getAdapter().getItem(position);

        //Toast.makeText(this, "Travel: " + travel.getLocation(), Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onItemClick()"+position);


        Intent intent = new Intent(this, MyCostsActivity.class);
        intent.putExtra("position", position);
        //startActivityForResult(intent, 1);
        startActivity(intent);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
