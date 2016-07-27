package com.example.henriquecarvalho.tep_06_trabalho;
/**
 * Created by henriquecarvalho on 2016-07-25.
 */
public enum TypeCost {

    FOOD ("Alimentação"),
    HOST ("Hospedagem"),
    TRANSPORT ("Transporte"),
    OTHERS ("Outros");

    private final String name;

    private TypeCost(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
