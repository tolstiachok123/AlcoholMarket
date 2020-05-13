package com.am.repository;

import com.am.entity.AlcoholDrink;
import com.am.service.JdbcTemplateService;
import com.am.util.db.AlcoholDrinkMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.ArrayList;

@Component
public class AlcoholDrinkRepository{

    private static JdbcTemplate jdbcTemplateObject = JdbcTemplateService.templateCreation();

    private final String getAlcoholDrinkQuery = "SELECT * from AlcoholDrinks";
    private final String getAlcoholDrinkByOneParameterQuery = "SELECT * FROM AlcoholDrinks WHERE ? = ?";
    private final String addAlcoholDrinkQuery = "INSERT INTO AlcoholDrinks (type, name, country, cost, ADV, color, herbsQuantity, rawMaterial, sugarContent, additive, isItQuiet) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public ArrayList<AlcoholDrink> getAllAlcoholDrinksList() {
        ArrayList<AlcoholDrink> alcoholDrinks = (ArrayList<AlcoholDrink>) jdbcTemplateObject.query(getAlcoholDrinkQuery, new AlcoholDrinkMapper());
        return alcoholDrinks;
    }

    public ArrayList<AlcoholDrink> getAlcoholDrinksListByOneParameter(String columnName, String value) {
        String sqlQuery = getAlcoholDrinkByOneParameterQuery.replace("?", columnName).replace("?", value);
        ArrayList<AlcoholDrink> alcoholDrinks = (ArrayList<AlcoholDrink>) jdbcTemplateObject.query(sqlQuery, new AlcoholDrinkMapper());
        return alcoholDrinks;
    }

    public void saveRecord(String type, String name, String country, double cost, double ADV, String color, int herbsQuantity, String rawMaterial, double sugarContent, String additive, boolean isItQuiet){
        Object[] params = new Object[] { type, name, country, cost, ADV, color, herbsQuantity, rawMaterial, sugarContent, additive, isItQuiet };
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.DOUBLE, Types.DOUBLE, Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.DOUBLE, Types.VARCHAR, Types.BOOLEAN };
        jdbcTemplateObject.update(addAlcoholDrinkQuery, params, types);
    }
}
