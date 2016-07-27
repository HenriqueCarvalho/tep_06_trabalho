package com.example.henriquecarvalho.tep_06_trabalho;

import java.util.List;

/**
 * Created by henriquecarvalho on 2016-07-27.
 */
public class MySingleton {

    private static MySingleton ourInstance = new MySingleton();
    List<Travel> travels;


    /* Static 'instance' method */
    public static MySingleton getInstance() {
        return ourInstance;
    }

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private MySingleton() {
        travels = Travel.getTravels();
    }

}
