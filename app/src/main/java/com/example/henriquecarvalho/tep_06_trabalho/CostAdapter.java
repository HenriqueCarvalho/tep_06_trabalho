package com.example.henriquecarvalho.tep_06_trabalho;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by henriquecarvalho on 2016-07-26.
 */
public class CostAdapter extends BaseAdapter {

    private static final String TAG = CostAdapter.class.getSimpleName();
    private final Context context;
    private final List<Cost> costs;
    final List<Cost> seletedItens;


    public CostAdapter(Context context, List<Cost> costs) {
        this.context = context;
        this.costs = costs;
        this.seletedItens = new ArrayList<Cost>();
    }

    @Override
    public int getCount() {
        return costs != null ? costs.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return costs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void removeSelectedItens() {

        for (int i = 0; i < seletedItens.size(); i++) {
            costs.remove(seletedItens.get(i));
        }

        // Clear the selected itens
        seletedItens.clear();

        // Update the UI
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        // Infla a view
        View view = LayoutInflater.from(context).inflate(R.layout.list_costs, parent, false);

        final int pos = position;

        // Faz findViewById das views que precisa atualizar
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkBox);

        checkBox.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                CheckBox cb = (CheckBox) view ;
                if (cb.isChecked()) {
                    seletedItens.add(costs.get(position));
                    Log.d(TAG, "onClick()"+seletedItens.toString());
                } else {
                    if (seletedItens.contains(costs.get(position))) {
                        seletedItens.remove(costs.get(position));
                        Log.d(TAG, "remove()"+seletedItens.toString());
                    }
                }
            }
        });

        TextView typeOfCost = (TextView) view.findViewById(R.id.typeOfCostTextView);
        TextView date = (TextView) view.findViewById(R.id.dateTextView);
        TextView price = (TextView) view.findViewById(R.id.priceTextView);

        // Atualiza os valores das views
        Cost cost = costs.get(position);

        //icon.setImageResource(R.drawable.ic_action_share); // colocar o icone do tipo de viagem aqui
        typeOfCost.setText(cost.getType().toString());
        date.setText("10/10/2016");
        price.setText("R$ 100,00");

        // Retorna a view deste gasto
        return view;
    }


}
