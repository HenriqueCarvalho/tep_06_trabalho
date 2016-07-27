package com.example.henriquecarvalho.tep_06_trabalho;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MyTravelsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = MyTravelsActivity.class.getSimpleName();

    private ListView listView;
    private TravelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_travels);

       // ActionBar actionBar = getSupportActionBar();
       // actionBar.setDisplayHomeAsUpEnabled(true);

        // ListView
        listView = (ListView) findViewById(R.id.listview);
        List<Travel> travels = Travel.getTravels();

        // Pass results to TravelAdapter Class
        adapter = new TravelAdapter(this, travels);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_my_travels, menu);
        MenuItem searchViewItem = menu.findItem(R.id.action_search);

        // Search
        final SearchView searchViewAndroidActionBar = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchViewAndroidActionBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d(TAG, "onQueryTextSubmit()"+query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                Log.d(TAG, "onQueryTextChange()"+newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Travel travel = (Travel) parent.getAdapter().getItem(position);

        //Toast.makeText(this, "Travel: " + travel.getLocation(), Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onItemClick()"+position);

        Intent intent = new Intent(this, MyCostsActivity.class);
        intent.putExtra("position", position);
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
