package com.example.henriquecarvalho.tep_06_trabalho;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by henriquecarvalho on 2016-07-25.
 */
public class TravelAdapter extends BaseAdapter {
    private final Context context;
    private final List<Travel> travels;

    public TravelAdapter(Context context, List<Travel> travels) {
        this.context = context;
        this.travels = travels;
    }

    @Override
    public int getCount() {
        return travels != null ? travels.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return travels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Infla a view
        View view = LayoutInflater.from(context).inflate(R.layout.list_travels, parent, false);

        // Faz findViewById das views que precisa atualizar
        ImageView icon = (ImageView) view.findViewById(R.id.iconTravelImageView);
        TextView location = (TextView) view.findViewById(R.id.locationTextView);
        TextView date = (TextView) view.findViewById(R.id.dateTextView);
        TextView total = (TextView) view.findViewById(R.id.totalTextView);

        // Atualiza os valores das views
        Travel travel = travels.get(position);

        icon.setImageResource(R.drawable.ic_action_share); // colocar o icone do tipo de viagem aqui
        location.setText(travel.getLocation());
        date.setText(travel.getDate().toString());
        total.setText("R$ 100,00"); // Somar todos valores dos custos e colocar aqui

        // Retorna a view desta viagem
        return view;
    }
}
