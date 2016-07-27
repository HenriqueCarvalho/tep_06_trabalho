package com.example.henriquecarvalho.tep_06_trabalho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

public class MyCostsActivity extends AppCompatActivity {

    private static final String TAG = MyCostsActivity.class.getSimpleName();

    private int id = 0;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_costs);

        // ListView
        listView = (ListView) findViewById(R.id.listView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int position = extras.getInt("position");
            // If you want to get string
            //String someVariable = extras.getString("someVariable");

            List<Travel> travels = Travel.getTravels();
            List<Cost> costs = travels.get(position).getCosts();

            Log.d(TAG, "onCreate()"+position);

            for (Cost c: costs ) {
                Log.d(TAG, "onCreate()"+c.getType().toString());
            }

            listView.setAdapter(new CostAdapter(this, costs));

            // listView.setOnItemClickListener(this);

        }
    }
}
