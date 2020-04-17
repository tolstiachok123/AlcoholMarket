package com.am.repository;

import com.am.entity.AlcoholDrink;
import com.am.util.db.DBUtils;

import java.sql.*;
import java.util.ArrayList;

public class TinctureRepository {

    private final String getTinctureQuery = "Select * from Tinctures";

    private final String addTinctureQuery = "INSERT INTO Tinctures (name, country, cost, ADV, additive) VALUES (?, ?, ?, ?, ?)";

    public ArrayList<AlcoholDrink> getAlcoholDrinksListFromDB() {
        ArrayList<AlcoholDrink> tinctures = new ArrayList<AlcoholDrink>();
        try {
            Connection connection = DBUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getTinctureQuery);
            tinctures.addAll(createTinctures(resultSet));
            DBUtils.returnConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tinctures;
    }

    public void addAlcoholDrinkToDB(Tincture tincture) {
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(addTinctureQuery);
            preparedStatement.setString(1, tincture.getName());
            preparedStatement.setString(2, tincture.getCountry());
            preparedStatement.setDouble(3, tincture.getCost());
            preparedStatement.setDouble(4, tincture.getAdv());
            preparedStatement.setString(5, tincture.getAdditive());
            preparedStatement.executeUpdate();
            ResultSet resultSet =  preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                tincture.setId(resultSet.getInt(1));
            }
            DBUtils.returnConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }

    private static ArrayList<Tincture> createTinctures(ResultSet resultSet) throws SQLException {
        ArrayList<Tincture> tinctures = new ArrayList<Tincture>();
        while (resultSet.next()) {
            tinctures.add(createTincture(resultSet));
        }
        return tinctures;
    }

    private static Tincture createTincture(ResultSet resultSet) throws SQLException{
        Tincture tincture = new Tincture();
        tincture.setName(resultSet.getString(2));
        tincture.setCountry(resultSet.getString(3));
        tincture.setCost(resultSet.getDouble(4));
        tincture.setAdv(resultSet.getDouble(5));
        tincture.setAdditive(resultSet.getString(6));
        return tincture;
    }
}


