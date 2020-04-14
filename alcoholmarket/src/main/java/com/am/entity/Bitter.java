package com.am.entity;

public class Bitter extends AlcoholDrink {

    private int herbsQuantity;

    public Bitter(String name, String country, double cost, double adv, int herbsQuantity) {
        super(name, country, cost, adv);
        this.herbsQuantity = herbsQuantity;
    }

    public Bitter() {
    }

    public int getHerbsQuantity() {
        return herbsQuantity;
    }

    public void setHerbsQuantity(int herbsQuantity) {
        this.herbsQuantity = herbsQuantity;
    }

    @Override
    public String toString() {
        return "Bitter{" +
                "name=" + this.getName() +
                "country=" + this.getCountry() +
                "cost=" + this.getCost() +
                "ADV=" + this.getAdv() +
                "herbsQuantity=" + herbsQuantity +
                '}';
    }
}
