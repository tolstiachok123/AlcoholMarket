package com.am.service;

import com.am.entity.AlcoholDrink;
import com.am.repository.AlcoholDrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class AlcoholDrinkService implements IAlcoholDrinkService {

    @Autowired
    private AlcoholDrinkRepository alcoholDrinkRepository;

    @Override
    public ArrayList<AlcoholDrink> getList() {
        return alcoholDrinkRepository.getAllAlcoholDrinksList();
    }

    @Override
    public void addAlcoholDrink(String type, String name, String country, double cost, double ADV, String color, int herbsQuantity, String rawMaterial, double sugarContent, String additive, boolean isItQuiet) {
        alcoholDrinkRepository.saveRecord(type, name, country, cost, ADV, color, herbsQuantity, rawMaterial, sugarContent, additive, isItQuiet);
    }
}
