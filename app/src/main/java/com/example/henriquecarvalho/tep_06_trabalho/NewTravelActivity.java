package com.example.henriquecarvalho.tep_06_trabalho;

import android.app.DatePickerDialog;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class NewTravelActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private static final String TAG = NewTravelActivity.class.getSimpleName();
    private List<Travel> travels;

    //UI References
    private EditText locationEditText;
    private TextView datePickertxtView;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_travel);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Singleton
        MySingleton tmp = MySingleton.getInstance();
        travels = tmp.travels;

        // UI
        locationEditText = (EditText) findViewById(R.id.locationEditText) ;
        datePickertxtView = (TextView) findViewById(R.id.datePickerTextView);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        setDatePickertxtView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_travel, menu);
        return true;
    }

    @Override
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
            case R.id.action_done:
                saveData();
                toast("A viagem foi salva.");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radioLeisureButton:
                if (checked)
                    Log.d(TAG, "onRadioButtonClicked() radio Leisure Button was clicked");
                break;
            case R.id.radioBusinessButton:
                if (checked)
                    Log.d(TAG, "onRadioButtonClicked() radio Business Button was clicked");
                break;
        }
    }


    private void setDatePickertxtView() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        datePickertxtView.setText(dateFormatter.format(c.getTime()));
    }

    // handle the date selected
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        // store the values selected into a Calendar instance
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, monthOfYear);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        datePickertxtView.setText(dateFormatter.format(c.getTime()));

        Log.d(TAG, "onDateSet()" + year + "/" + monthOfYear + "/" + dayOfMonth);
    }

    // attach to an onclick handler to show the date picker
    public void showDatePickerDialog(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    private void saveData() {

        String location = locationEditText.getText().toString();
        Trip trip = Trip.BUSINNESS;
        String date = datePickertxtView.getText().toString();

        Travel travel = new Travel(location,trip,date);

        travels.add(travel);
    }

}
