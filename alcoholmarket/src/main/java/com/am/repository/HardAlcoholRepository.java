package com.am.repository;

import com.am.entity.AlcoholDrink;
import com.am.util.db.DBUtils;

import java.sql.*;
import java.util.ArrayList;

public class HardAlcoholRepository {

    private final String getHardAlcoholQuery = "Select * from HardAlcohol";

    private final String addHardAlcoholQuery = "INSERT INTO HardAlcohol (name, country, cost, ADV, rawMaterial) VALUES (?, ?, ?, ?, ?)";

    public ArrayList<AlcoholDrink> getAlcoholDrinksListFromDB() {
        ArrayList<AlcoholDrink> hardAlcohols = new ArrayList<AlcoholDrink>();
        try {
            Connection connection = DBUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getHardAlcoholQuery);
            hardAlcohols.addAll(createHardAlcohols(resultSet));
            DBUtils.returnConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hardAlcohols;
    }

    public void addAlcoholDrinkToDB(HardAlcohol hardAlcohol) {
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(addHardAlcoholQuery);
            preparedStatement.setString(1, hardAlcohol.getName());
            preparedStatement.setString(2, hardAlcohol.getCountry());
            preparedStatement.setDouble(3, hardAlcohol.getCost());
            preparedStatement.setDouble(4, hardAlcohol.getAdv());
            preparedStatement.setString(5, hardAlcohol.getRawMaterial());
            preparedStatement.executeUpdate();
            ResultSet resultSet =  preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                hardAlcohol.setId(resultSet.getInt(1));
            }
            DBUtils.returnConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }

    private static ArrayList<HardAlcohol> createHardAlcohols(ResultSet resultSet) throws SQLException {
        ArrayList<HardAlcohol> hardAlcohols = new ArrayList<HardAlcohol>();
        while (resultSet.next()) {
            hardAlcohols.add(createHardAlcohol(resultSet));
        }
        return hardAlcohols;
    }

    private static HardAlcohol createHardAlcohol(ResultSet resultSet) throws SQLException{
        HardAlcohol bitter = new HardAlcohol();
        bitter.setName(resultSet.getString(2));
        bitter.setCountry(resultSet.getString(3));
        bitter.setCost(resultSet.getDouble(4));
        bitter.setAdv(resultSet.getDouble(5));
        bitter.setRawMaterial(resultSet.getString(6));
        return bitter;
    }
}


