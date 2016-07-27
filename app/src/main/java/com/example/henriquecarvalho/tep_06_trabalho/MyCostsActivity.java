package com.example.henriquecarvalho.tep_06_trabalho;

import android.content.DialogInterface;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MyCostsActivity extends AppCompatActivity {

    private static final String TAG = MyCostsActivity.class.getSimpleName();

    private int id = 0;
    private ListView listView;
    private CostAdapter adapter;

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

            adapter = new CostAdapter(this, costs);

            listView.setAdapter(adapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_my_costs, menu);
        MenuItem deleteViewItem = menu.findItem(R.id.action_delete);

        return super.onCreateOptionsMenu(menu);
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
            case R.id.action_delete:
                if(adapter.seletedItens.isEmpty()) {
                    Toast.makeText(this, "Não possui gastos selecionados!", Toast.LENGTH_SHORT).show();
                } else {
                    alertMessage();
                }
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void alertMessage() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE: // Yes button clicked
                        adapter.removeSelectedItens();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE: // No button clicked
                        // do nothing
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Você deseja deletar os gastos selecionados?")
                .setPositiveButton("Sim", dialogClickListener)
                .setNegativeButton("Não", dialogClickListener).show();
    }

}