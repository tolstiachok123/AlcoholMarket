package com.am.entity;

public class Vine extends AlcoholDrink {

    private String color;
    private String type;
    private String isItQuiet;

    public Vine(String name, String country, double cost, double adv, String color, String type, String isItQuiet) {
        super(name, country, cost, adv);
        this.color = color;
        this.type = type;
        this.isItQuiet = isItQuiet;
    }

    public Vine() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsItQuiet() {
        return isItQuiet;
    }

    public void setIsItQuiet(String isItQuiet) {
        this.isItQuiet = isItQuiet;
    }

    @Override
    public String toString() {
        return "Vine{" +
                "name=" + this.getName() +
                "country=" + this.getCountry() +
                "cost=" + this.getCost() +
                "ADV=" + this.getAdv() +
                "color='" + color + '\'' +
                ", type='" + type + '\'' +
                ", isItQuiet='" + isItQuiet + '\'' +
                '}';
    }
}
