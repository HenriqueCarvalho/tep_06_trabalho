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
    private List<Cost> costs;


    public Travel(String location, Trip typeOftravel, String date) {
        this.location = location;
        this.type = typeOftravel;
        this.date = date;
        this.costs = new ArrayList();
    }

    public Travel(String location, Trip typeOftravel, String date, List<Cost> costs) {
        this.location = location;
        this.type = typeOftravel;
        this.date = date;
        this.costs = costs;
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

    public List<Cost> getCosts() {
        return costs;
    }

    public void getCosts(List<Cost> costs) {
        this.costs = costs;
    }

    public double getTotal() {
        double total = 0.0;

        for(Cost c: costs){
            total += c.getPrice();
        }

        return total;
    }

    public String toString(){
        String str = "";

        str = "Localização:" + location + "\n";
        str += "Tipo de viagem:" + type.toString() + "\n";
        str += "data:" + date + "\n\n";
        str += "gastos:" + date + "\n";

        /*for(Cost c: costs){
            str += "data:" + date + "\n";
        }*/

        return str;
    }

    public static List<Travel> getTravels() {
        // Travels
        List<Travel> travels = new ArrayList<Travel>();

        // Costs
        List<Cost> costs1 = new ArrayList<Cost>();
        costs1.add(new Cost(TypeCost.FOOD, "10-12-2016", 80.00 ));

        List<Cost> costs2 = new ArrayList<Cost>();
        costs2.add(new Cost(TypeCost.FOOD, "10-12-2016", 80.00 ));
        costs2.add(new Cost(TypeCost.HOST, "10-12-2016", 150.00 ));

        List<Cost> costs3 = new ArrayList<Cost>();
        costs3.add(new Cost(TypeCost.FOOD, "10-12-2016", 80.00 ));
        costs3.add(new Cost(TypeCost.HOST, "10-12-2016", 150.00 ));
        costs3.add(new Cost(TypeCost.OTHERS, "10-12-2016", 200.00 ));

        List<Cost> costs4 = new ArrayList<Cost>();
        costs4.add(new Cost(TypeCost.FOOD, "10-12-2016", 80.00 ));
        costs4.add(new Cost(TypeCost.HOST, "10-12-2016", 150.00 ));
        costs4.add(new Cost(TypeCost.TRANSPORT, "10-12-2016", 50.00 ));
        costs4.add(new Cost(TypeCost.OTHERS, "10-12-2016", 200.00 ));

        travels.add(new Travel("Vancouver", Trip.BUSINNESS, "10-12-2016", costs1));
        travels.add(new Travel("New York", Trip.BUSINNESS, "10-12-2016", costs2));
        travels.add(new Travel("Toronto", Trip.BUSINNESS, "10-12-2016", costs3));
        travels.add(new Travel("Whistler", Trip.LEISURE, "10-12-2016", costs4));

        return travels;
    }
}
