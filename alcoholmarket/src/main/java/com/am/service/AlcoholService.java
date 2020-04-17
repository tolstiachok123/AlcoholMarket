package com.am.service;

import com.am.entity.AlcoholDrink;
import com.am.repository.AlcoholRepository;

import java.util.ArrayList;
import java.util.List;

public class AlcoholService implements IAlcoholService{
    private AlcoholRepository alcoholRepository;

    public AlcoholService(AlcoholRepository alcoholRepository) {
        alcoholRepository = new AlcoholRepository();
        this.alcoholRepository = alcoholRepository;
    }

    @java.lang.Override
    public ArrayList<AlcoholDrink> getList() {
        return alcoholRepository.getAlcoholDrinksListFromDB();
    }

    @java.lang.Override
    public void addAlcoholDrink(AlcoholDrink newAlcohol) {
        alcoholRepository.createAlcohol(newAlcohol);
    }

//    @java.lang.Override
//    public void delAlcohol(AlcoholDrink dellAlcohol) {
//        alcoholRepository.
//
//    }
}
