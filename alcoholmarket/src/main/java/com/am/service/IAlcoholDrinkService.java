package com.am.service;

import com.am.entity.AlcoholDrink;

import java.util.ArrayList;

public interface IAlcoholDrinkService {

    ArrayList<AlcoholDrink> getList();

    void addAlcoholDrink(String type, String name, String country, double cost, double ADV, String color, int herbsQuantity, String rawMaterial, double sugarContent, String additive, boolean isItQuiet);

   // void delAlcohol(Alcohol dellAlcohol);
}
