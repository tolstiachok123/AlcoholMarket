package com.am.entity;

public class Liqueur extends AlcoholDrink{

    private double sugarContent;

    public Liqueur(String name, String country, double cost, double adv, double sugarContent) {
        super(name, country, cost, adv);
        this.sugarContent = sugarContent;
    }

    public Liqueur() {
    }

    public double getSugarContent() {
        return sugarContent;
    }

    public void setSugarContent(double sugarContent) {
        this.sugarContent = sugarContent;
    }

    @Override
    public String toString() {
        return "Liqueur{" +
                "name=" + this.getName() +
                "country=" + this.getCountry() +
                "cost=" + this.getCost() +
                "ADV=" + this.getAdv() +
                "sugarContent=" + sugarContent +
                '}';
    }
}