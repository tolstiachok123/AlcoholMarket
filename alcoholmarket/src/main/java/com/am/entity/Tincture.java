package com.am.entity;

public class Tincture extends AlcoholDrink {

    private String additive;

    public Tincture(String name, String country, double cost, double adv, String additive) {
        super(name, country, cost, adv);
        this.additive = additive;
    }

    public Tincture() {
    }

    public String getAdditive() {
        return additive;
    }

    public void setAdditive(String additive) {
        this.additive = additive;
    }

    @Override
    public String toString() {
        return "Tincture{" +
                "name=" + this.getName() +
                "country=" + this.getCountry() +
                "cost=" + this.getCost() +
                "ADV=" + this.getAdv() +
                "additive='" + additive + '\'' +
                '}';
    }
}
