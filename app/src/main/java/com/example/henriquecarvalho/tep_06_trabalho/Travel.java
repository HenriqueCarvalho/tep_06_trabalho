package com.example.henriquecarvalho.tep_06_trabalho;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by henriquecarvalho on 2016-07-25.
 */
public class Travel {

    private int id;
    private String location;
    private Trip typeOftravel;
    private SimpleDateFormat date;

    public Travel(int id, String location, Trip typeOftravel, SimpleDateFormat date) {
        this.id = id;
        this.location = location;
        this.typeOftravel = typeOftravel;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Trip getTypeOftravel() {
        return typeOftravel;
    }

    public void setTypeOftravel(Trip typeOftravel) {
        this.typeOftravel = typeOftravel;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }

    public static List<Travel> getTravels() {
        // Travels
        List<Travel> travels = new ArrayList<Travel>();

        // store the values selected into a Calendar instance
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2016);
        c.set(Calendar.MONTH, 5);
        c.set(Calendar.DAY_OF_MONTH, 5);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        dateFormatter.format(c.getTime());

        travels.add(new Travel(1, "Vancouver", Trip.BUSINNESS, dateFormatter));
        travels.add(new Travel(2, "New York", Trip.BUSINNESS, dateFormatter));
        travels.add(new Travel(3, "Toronto", Trip.BUSINNESS, dateFormatter));
        travels.add(new Travel(4, "Whistler", Trip.LEISURE, dateFormatter));

        return travels;
    }
}
