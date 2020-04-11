package com.am.entity;

public abstract class AlcoholDrink {

    private String name;
    private String country;
    private double cost;
    private double adv;

    public AlcoholDrink(String name, String country, double cost, double adv) {
        this.name = name;
        this.country = country;
        this.cost = cost;
        this.adv = adv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getAdv() {
        return adv;
    }

    public void setAdv(double adv) {
        this.adv = adv;
    }
}
