package com.am.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlcoholDrink {

    private String type;
    private String name;
    private String country;
    private double cost;
    private double adv;
    private String color;
    private int herbsQuantity;
    private String rawMaterial;
    private double sugarContent;
    private String additive;
    private boolean isItQuiet;
    private int id;

    public void setIsItQuiet(boolean itQuiet) {
        isItQuiet = itQuiet;
    }

}
