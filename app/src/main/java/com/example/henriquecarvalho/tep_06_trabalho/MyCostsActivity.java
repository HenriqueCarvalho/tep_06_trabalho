package com.example.henriquecarvalho.tep_06_trabalho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MyCostsActivity extends AppCompatActivity {

    private static final String TAG = MyCostsActivity.class.getSimpleName();
    private TextView myCostsTextView;
    private int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_costs);

        myCostsTextView = (TextView) findViewById(R.id.myCostsTextView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int position = extras.getInt("position");

            // If you want to get string
            // String someVariable = extras.getString("someVariable");

            myCostsTextView.setText(Integer.toString(position));

            Log.d(TAG, "onCreate()"+position);
        }
    }
}
