package com.am.entity;

public class AlcoholDrink {

    private Type type;
    private String name;
    private String country;
    private double cost;
    private double adv;
    private String color;
    private int herbsQuantity;
    private String rawMaterial;
    private double sugarContent;
    private String additive;
    private String isItQuiet;
    private int id;

    public AlcoholDrink() {
    }

    public AlcoholDrink(Type type, String name, String country, double cost, double adv, String color, int herbsQuantity, String rawMaterial, double sugarContent, String additive, String isItQuiet) {
        this.type = type;
        this.name = name;
        this.country = country;
        this.cost = cost;
        this.adv = adv;
        this.color = color;
        this.herbsQuantity = herbsQuantity;
        this.rawMaterial = rawMaterial;
        this.sugarContent = sugarContent;
        this.additive = additive;
        this.isItQuiet = isItQuiet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHerbsQuantity() {
        return herbsQuantity;
    }

    public void setHerbsQuantity(int herbsQuantity) {
        this.herbsQuantity = herbsQuantity;
    }

    public String getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(String rawMaterial) {
        this.rawMaterial = rawMaterial;
    }

    public double getSugarContent() {
        return sugarContent;
    }

    public void setSugarContent(double sugarContent) {
        this.sugarContent = sugarContent;
    }

    public String getAdditive() {
        return additive;
    }

    public void setAdditive(String additive) {
        this.additive = additive;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getIsItQuiet() {
        return isItQuiet;
    }

    public void setIsItQuiet(String isItQuiet) {
        this.isItQuiet = isItQuiet;
    }
}
