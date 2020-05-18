package com.am.dao;

import com.am.model.AlcoholDrink;

import java.util.ArrayList;

public interface AlcoholDrinkDao {

    ArrayList<AlcoholDrink> findAllAlcoholDrinks();

    ArrayList<AlcoholDrink> getAlcoholDrinksListByOneParameter(String columnName, String value);

    void saveRecord(String type, String name, String country, double cost, double ADV, String color, int herbsQuantity, String rawMaterial, double sugarContent, String additive, boolean isItQuiet);
}
