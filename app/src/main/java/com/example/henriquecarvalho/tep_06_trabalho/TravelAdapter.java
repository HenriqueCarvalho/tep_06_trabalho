package com.example.henriquecarvalho.tep_06_trabalho;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by henriquecarvalho on 2016-07-25.
 */
public class TravelAdapter extends BaseAdapter implements Filterable {
    private final Context context;
    private List<Travel> travels;
    private Filter travelFilter;
    private List<Travel> oTravels;

    public TravelAdapter(Context context, List<Travel> travels) {
        this.context = context;
        this.travels = travels;
        this.oTravels = travels;
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

        if(travel.getType() == Trip.BUSINNESS) {
            icon.setImageResource(R.drawable.negocios);

        } else {
            icon.setImageResource(R.drawable.lazer);
        }

        location.setText(travel.getLocation());
        date.setText(travel.getDate());
        total.setText("R$"+Double.toString(travel.getTotal())); // Somar todos valores dos custos e colocar aqui

        // Retorna a view desta viagem
        return view;
    }

    public void resetData() {
        travels = oTravels;
    }

    @Override
    public Filter getFilter() {
        if (travelFilter == null)
            travelFilter = new TravelFilter();

        return travelFilter;
    }

    /* for more information about Filter implementation:
     * https://github.com/survivingwithandroid/Surviving-with-android/blob/master/
     * ListView_Filter_Tutorial/src/com/survivingwithandroid/listview/SimpleList/PlanetAdapter.java
     */

    public class TravelFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            // We implement here the filter logic
            if (constraint == null || constraint.length() == 0) {

                // No filter implemented we return all the list
                results.values = oTravels;
                results.count = oTravels.size();
            } else {
                // We perform filtering operation
                List<Travel> nTravelList = new ArrayList<Travel>();

                for (Travel p : travels) {
                    if (p.getLocation().toUpperCase().startsWith(constraint.toString().toUpperCase()))
                        nTravelList.add(p);
                }

                results.values = nTravelList;
                results.count = nTravelList.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint,Filter.FilterResults results) {
            // Now we have to inform the adapter about the new list filtered
            if (results.count == 0)
                notifyDataSetInvalidated();
            else {
                travels = (List<Travel>) results.values;
                notifyDataSetChanged();
            }
        }

    }



}