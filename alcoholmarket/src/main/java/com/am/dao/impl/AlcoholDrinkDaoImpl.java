package com.am.dao.impl;

import com.am.dao.AlcoholDrinkDao;
import com.am.model.AlcoholDrink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.ArrayList;

@Component
public class AlcoholDrinkDaoImpl implements AlcoholDrinkDao {

    private final String getAlcoholDrinkQuery = "SELECT * from AlcoholDrinks";
    private final String getAlcoholDrinkByOneParameterQuery = "SELECT * FROM AlcoholDrinks WHERE ? = ?";
    private final String addAlcoholDrinkQuery = "INSERT INTO AlcoholDrinks (type, name, country, cost, ADV, color, herbsQuantity, rawMaterial, sugarContent, additive, isItQuiet) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ArrayList<AlcoholDrink> findAllAlcoholDrinks() {
        ArrayList<AlcoholDrink> alcoholDrinks = (ArrayList<AlcoholDrink>) jdbcTemplate.query(getAlcoholDrinkQuery, new AlcoholDrinkMapper());
        return alcoholDrinks;
    }

    @Override
    public ArrayList<AlcoholDrink> getAlcoholDrinksListByOneParameter(String columnName, String value) {
        String sqlQuery = getAlcoholDrinkByOneParameterQuery.replace("?", columnName).replace("?", value);
        ArrayList<AlcoholDrink> alcoholDrinks = (ArrayList<AlcoholDrink>) jdbcTemplate.query(sqlQuery, new AlcoholDrinkMapper());
        return alcoholDrinks;
    }

    @Override
    public void saveRecord(String type, String name, String country, double cost, double ADV, String color, int herbsQuantity, String rawMaterial, double sugarContent, String additive, boolean isItQuiet){
        Object[] params = new Object[] { type, name, country, cost, ADV, color, herbsQuantity, rawMaterial, sugarContent, additive, isItQuiet };
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.DOUBLE, Types.DOUBLE, Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.DOUBLE, Types.VARCHAR, Types.BOOLEAN };
        jdbcTemplate.update(addAlcoholDrinkQuery, params, types);
    }
}
