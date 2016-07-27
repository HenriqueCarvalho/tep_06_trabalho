package com.example.henriquecarvalho.tep_06_trabalho;

import android.app.DatePickerDialog;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class NewCostActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private static final String TAG = NewCostActivity.class.getSimpleName();
    private List<Travel> travels;
    private Cost cost;

    // UI References
    private TextView dateTextView;
    private SimpleDateFormat dateFormatter;
    private EditText valueEditText;
    private Spinner travelSpinner;
    private Spinner costSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_cost);

        MySingleton tmp = MySingleton.getInstance();
        travels = tmp.travels;

        travelSpinner = (Spinner) findViewById(R.id.travelSpinner);
        costSpinner = (Spinner) findViewById(R.id.costSpinner);
        dateTextView = (TextView) findViewById(R.id.dateTextView);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        setDateTextView();
        valueEditText = (EditText) findViewById(R.id.valueEditText);

        ArrayAdapter<String> travelAdaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getLocations());

        travelSpinner.setAdapter(travelAdaptador);
        travelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                // faz algo...
                Log.d(TAG, "onItemSelected()"+parent.getItemAtPosition(pos));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // faz algo
                Log.d(TAG, "onNothingSelected()");
            }
        });

        ArrayAdapter<String> costAdaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getTypes());

        costSpinner.setAdapter(costAdaptador);
        costSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Log.d(TAG, "onItemSelected()"+parent.getItemAtPosition(pos));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d(TAG, "onNothingSelected()");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_cost, menu);
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
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public List<String> getLocations() {
        List<String> locations = new ArrayList<String>();

        for(Travel t: travels) {
            locations.add(t.getLocation());
        }

        return locations;
    }

    public static String[] getTypes() {
        TypeCost[] types = TypeCost.values();
        String[] names = new String[types.length];

        for (int i = 0; i < types.length; i++) {
            names[i] = types[i].toString();
        }

        return names;
    }

    private void setDateTextView() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        dateTextView.setText(dateFormatter.format(c.getTime()));
    }

    private void saveData() {
        String costValue = costSpinner.getSelectedItem().toString();
        int pos = travelSpinner.getSelectedItemPosition();
        TypeCost c = TypeCost.fromString(costValue);
        String date = dateTextView.getText().toString();
        double price = 0.0;
        String strprice = valueEditText.getText().toString();

        if(strprice.isEmpty()) {
            price = 0.0;
        } else {
            price = Double.parseDouble(strprice);
        }

        if(price == 0.0 ) {
            toast("Campo preço está vazio!");
        } else {
            Cost cost = new Cost(c, date, price);
            travels.get(pos).getCosts().add(cost);
            toast("O gasto foi salvo.");
        }

        Log.d(TAG, "saveData() travelSpinner: " + travelSpinner.getSelectedItem().toString());
        Log.d(TAG, "         travelPosition: " + travelSpinner.getSelectedItemPosition());
        Log.d(TAG, "                     c: " + c.hashCode() + "/" + c.name() + "/" + c.toString());
        Log.d(TAG, "             costSpinner: " + costValue);
        Log.d(TAG, "            price: " + price);
        Log.d(TAG, "            dateTextView: " + date);

        for (Cost test: travels.get(pos).getCosts()) {
            Log.d(TAG, "costs: " + test.getType());
        }
    }

    // handle the date selected
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        // store the values selected into a Calendar instance
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, monthOfYear);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        dateTextView.setText(dateFormatter.format(c.getTime()));

        Log.d(TAG, "onDateSet()" + year + "/" + monthOfYear + "/" + dayOfMonth);
    }

    // attach to an onclick handler to show the date picker
    public void showDatePickerDialog(View view) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
