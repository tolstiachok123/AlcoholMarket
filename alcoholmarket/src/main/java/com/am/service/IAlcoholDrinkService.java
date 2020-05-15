package com.am.service;

import com.am.entity.AlcoholDrink;

import java.util.ArrayList;

public interface IAlcoholDrinkService {

    ArrayList<AlcoholDrink> getList();

    void addAlcoholDrink(AlcoholDrink newAlcohol);

   // void delAlcohol(Alcohol dellAlcohol);
}
