package com.am.repository;

import com.am.entity.AlcoholDrink;
import com.am.entity.Bitter;
import com.am.util.db.DBUtils;

import java.sql.*;
import java.util.ArrayList;

public class BitterRepository {

    private final String getBitterQuery = "Select * from Bitters";

    private final String addBitterQuery = "INSERT INTO Bitters (name, country, cost, ADV, herbsQuantity) VALUES (?, ?, ?, ?, ?)";

    public ArrayList<AlcoholDrink> getAlcoholDrinksListFromDB() {
        ArrayList<AlcoholDrink> bitters = new ArrayList<AlcoholDrink>();
        try {
            Connection connection = DBUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getBitterQuery);
            bitters.addAll(createBitters(resultSet));
            DBUtils.returnConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bitters;
    }

    public void addAlcoholDrinkToDB(Bitter bitter) {
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(addBitterQuery);
            preparedStatement.setString(1, bitter.getName());
            preparedStatement.setString(2, bitter.getCountry());
            preparedStatement.setDouble(3, bitter.getCost());
            preparedStatement.setDouble(4, bitter.getAdv());
            preparedStatement.setInt(5, bitter.getHerbsQuantity());
            preparedStatement.executeUpdate();
            ResultSet resultSet =  preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                bitter.setId(resultSet.getInt(1));
            }
            DBUtils.returnConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }

    private static ArrayList<Bitter> createBitters(ResultSet resultSet) throws SQLException {
        ArrayList<Bitter> bitters = new ArrayList<Bitter>();
        while (resultSet.next()) {
            bitters.add(createBeer(resultSet));
        }
        return bitters;
    }

    private static Bitter createBeer(ResultSet resultSet) throws SQLException{
        Bitter bitter = new Bitter();
        bitter.setName(resultSet.getString(2));
        bitter.setCountry(resultSet.getString(3));
        bitter.setCost(resultSet.getDouble(4));
        bitter.setAdv(resultSet.getDouble(5));
        bitter.setHerbsQuantity(resultSet.getInt(6));
        return bitter;
    }
}

