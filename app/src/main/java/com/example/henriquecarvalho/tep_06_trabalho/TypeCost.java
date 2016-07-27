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

    public static TypeCost fromString(String text) {
        if (text != null) {
            for (TypeCost b : TypeCost.values()) {
                if (text.equalsIgnoreCase(b.name)) {
                    return b;
                }
            }
        }
        return null;
    }
}
