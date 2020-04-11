package com.am.entity;

public class Beer extends AlcoholDrink {

    private String color;

    public Beer(String name, String country, double cost, double adv, String color) {
        super(name, country, cost, adv);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "name=" + this.getName() +
                "country=" + this.getCountry() +
                "cost=" + this.getCost() +
                "ADV=" + this.getAdv() +
                "color='" + color + '\'' +
                '}';
    }
}
