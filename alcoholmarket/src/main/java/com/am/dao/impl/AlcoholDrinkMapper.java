package com.am.dao.impl;

import com.am.model.AlcoholDrink;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AlcoholDrinkMapper implements RowMapper<AlcoholDrink> {

    @Override
    public AlcoholDrink mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        AlcoholDrink alcoholDrink = new AlcoholDrink();
        alcoholDrink.setId(resultSet.getInt("id"));
        alcoholDrink.setName(resultSet.getString("name"));
        alcoholDrink.setIsItQuiet(resultSet.getBoolean("isItQuiet"));
        alcoholDrink.setAdditive(resultSet.getString("additive"));
        alcoholDrink.setType(resultSet.getString("type"));
        alcoholDrink.setRawMaterial(resultSet.getString("rawMaterial"));
        alcoholDrink.setSugarContent(resultSet.getInt("sugarContent"));
        alcoholDrink.setHerbsQuantity(resultSet.getInt("herbsQuantity"));
        alcoholDrink.setAdv(resultSet.getDouble("adv"));
        alcoholDrink.setColor(resultSet.getString("color"));
        alcoholDrink.setColor(resultSet.getString("country"));
        alcoholDrink.setCost(resultSet.getDouble("cost"));
        return alcoholDrink;
    }
}
