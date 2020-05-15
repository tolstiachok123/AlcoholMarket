package com.am.service;

import com.am.entity.AlcoholDrink;
import com.am.repository.AlcoholDrinkRepository;

import java.util.ArrayList;

public class AlcoholDrinkService implements IAlcoholDrinkService {

    private AlcoholDrinkRepository alcoholDrinkRepository;

    public AlcoholDrinkService(AlcoholDrinkRepository alcoholDrinkRepository) {
        this.alcoholDrinkRepository = alcoholDrinkRepository;
    }

    @Override
    public ArrayList<AlcoholDrink> getList() {
        return alcoholDrinkRepository.getAlcoholDrinksListFromDB();
    }

    @Override
    public void addAlcoholDrink(AlcoholDrink newAlcohol) {
        alcoholDrinkRepository.addAlcoholDrinkToDB(newAlcohol);
    }
}
