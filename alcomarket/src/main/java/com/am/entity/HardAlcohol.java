package com.am.entity;

public class HardAlcohol extends AlcoholDrink{

    private String rawMaterial;

    public HardAlcohol(String name, String country, double cost, double adv, String rawMaterial) {
        super(name, country, cost, adv);
        this.rawMaterial = rawMaterial;
    }

    public String getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(String rawMaterial) {
        this.rawMaterial = rawMaterial;
    }

    @Override
    public String toString() {
        return "HardAlcohol{" +
                "name=" + this.getName() +
                "country=" + this.getCountry() +
                "cost=" + this.getCost() +
                "ADV=" + this.getAdv() +
                "rawMaterial='" + rawMaterial + '\'' +
                '}';
    }
}
