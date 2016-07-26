package com.example.henriquecarvalho.tep_06_trabalho;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by henriquecarvalho on 2016-07-25.
 */
public class Travel {

    private String location;
    private Trip type;
    private String date;
    private List<Cost> cots;


    public Travel(String location, Trip typeOftravel, String date) {
        this.location = location;
        this.type = typeOftravel;
        this.date = date;
    }

    public Travel(String location, Trip typeOftravel, String date, List<Cost> costs) {
        this.location = location;
        this.type = typeOftravel;
        this.date = date;
        this.cots = costs;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Trip getType() {
        return type;
    }

    public void setType(Trip typeOftravel) {
        this.type = typeOftravel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Cost> getCots() {
        return cots;
    }

    public void setCots(List<Cost> cots) {
        this.cots = cots;
    }

    public static List<Travel> getTravels() {
        // Travels
        List<Travel> travels = new ArrayList<Travel>();

        // store the values selected into a Calendar instance
        /*final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2016);
        c.set(Calendar.MONTH, 5);
        c.set(Calendar.DAY_OF_MONTH, 5);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        dateFormatter.format(c.getTime());*/

        /*travels.add(new Travel(1, "Vancouver", Trip.BUSINNESS, dateFormatter));
        travels.add(new Travel(2, "New York", Trip.BUSINNESS, dateFormatter));
        travels.add(new Travel(3, "Toronto", Trip.BUSINNESS, dateFormatter));
        travels.add(new Travel(4, "Whistler", Trip.LEISURE, dateFormatter));*/

        // Costs
        List<Cost> costs = new ArrayList<Cost>();
        costs.add(new Cost(TypeCost.FOOD, "10-12-2016", 80.00 ));
        costs.add(new Cost(TypeCost.HOST, "10-12-2016", 150.00 ));
        costs.add(new Cost(TypeCost.TRANSPORT, "10-12-2016", 120.00 ));
        costs.add(new Cost(TypeCost.OTHERS, "10-12-2016", 200.00 ));

        travels.add(new Travel("Vancouver", Trip.BUSINNESS, "10-12-2016", costs));
        travels.add(new Travel("New York", Trip.BUSINNESS, "10-12-2016", costs));
        travels.add(new Travel("Toronto", Trip.BUSINNESS, "10-12-2016", costs));
        travels.add(new Travel("Whistler", Trip.LEISURE, "10-12-2016", costs));

        return travels;
    }
}
