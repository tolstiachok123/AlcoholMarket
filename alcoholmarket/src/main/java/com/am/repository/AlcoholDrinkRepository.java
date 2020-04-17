package com.am.repository;

import com.am.entity.AlcoholDrink;
import com.am.entity.Type;
import com.am.util.db.DBUtils;

import java.sql.*;
import java.util.ArrayList;

public class AlcoholDrinkRepository {
    private final String getAlcoholDrinkQuery = "Select * from AlcoholDrinks";

    private final String addAlcoholDrinkQuery = "INSERT INTO AlcoholDrinks (type, name, country, cost, ADV, color, herbsQuantity, rawMaterial, sugarContent, additive, isItQuiet) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public ArrayList<AlcoholDrink> getAlcoholDrinksListFromDB() {
        ArrayList<AlcoholDrink> alcoholDrinks = new ArrayList<>();
        try {
            Connection connection = DBUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAlcoholDrinkQuery);
            alcoholDrinks.addAll(createAlcoholDrinks(resultSet));
            DBUtils.returnConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return alcoholDrinks;
    }

    public void addAlcoholDrinkToDB(AlcoholDrink alcoholDrink) {
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(addAlcoholDrinkQuery);
            preparedStatement.setObject(1, alcoholDrink.getType());
            preparedStatement.setString(2, alcoholDrink.getName());
            preparedStatement.setString(3, alcoholDrink.getCountry());
            preparedStatement.setDouble(4, alcoholDrink.getCost());
            preparedStatement.setDouble(5, alcoholDrink.getAdv());
            preparedStatement.setString(6, alcoholDrink.getColor());
            preparedStatement.setInt(7, alcoholDrink.getHerbsQuantity());
            preparedStatement.setString(8, alcoholDrink.getRawMaterial());
            preparedStatement.setDouble(9, alcoholDrink.getSugarContent());
            preparedStatement.setString(10, alcoholDrink.getAdditive());
            preparedStatement.setBoolean(11, alcoholDrink.getIsItQuiet());
            preparedStatement.executeUpdate();
            ResultSet resultSet =  preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                alcoholDrink.setId(resultSet.getInt(1));
            }
            DBUtils.returnConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }

    private static ArrayList<AlcoholDrink> createAlcoholDrinks(ResultSet resultSet) throws SQLException {
        ArrayList<AlcoholDrink> beers = new ArrayList<>();
        while (resultSet.next()) {
            beers.add(createAlcoholDrink(resultSet));
        }
        return beers;
    }

    private static AlcoholDrink createAlcoholDrink(ResultSet resultSet) throws SQLException{
        AlcoholDrink alcoholDrink = new AlcoholDrink();
        alcoholDrink.setType((Type) resultSet.getObject(2));
        alcoholDrink.setName(resultSet.getString(3));
        alcoholDrink.setCountry(resultSet.getString(4));
        alcoholDrink.setCost(resultSet.getDouble(5));
        alcoholDrink.setAdv(resultSet.getDouble(6));
        alcoholDrink.setColor(resultSet.getString(7));
        alcoholDrink.setHerbsQuantity(resultSet.getInt(8));
        alcoholDrink.setRawMaterial(resultSet.getString(9));
        alcoholDrink.setSugarContent(resultSet.getDouble(10));
        alcoholDrink.setAdditive(resultSet.getString(11));
        alcoholDrink.setIsItQuiet(resultSet.getBoolean(12));
        return alcoholDrink;
    }
}
