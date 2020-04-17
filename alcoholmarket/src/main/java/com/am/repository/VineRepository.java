package com.am.repository;

import com.am.entity.AlcoholDrink;
import com.am.util.db.DBUtils;

import java.sql.*;
import java.util.ArrayList;

public class VineRepository {

    private final String getTinctureQuery = "Select * from Vine";

    private final String addTinctureQuery = "INSERT INTO Vine (name, country, cost, ADV, color, type, isItQuiet) VALUES (?, ?, ?, ?, ?, ?, ?)";

    public ArrayList<AlcoholDrink> getAlcoholDrinksListFromDB() {
        ArrayList<AlcoholDrink> vines = new ArrayList<AlcoholDrink>();
        try {
            Connection connection = DBUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getTinctureQuery);
            vines.addAll(createTinctures(resultSet));
            DBUtils.returnConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vines;
    }

    public void addAlcoholDrinkToDB(Vine vine) {
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(addTinctureQuery);
            preparedStatement.setString(1, vine.getName());
            preparedStatement.setString(2, vine.getCountry());
            preparedStatement.setDouble(3, vine.getCost());
            preparedStatement.setDouble(4, vine.getAdv());
            preparedStatement.setString(5, vine.getColor());
            preparedStatement.setString(5, vine.getType());
            preparedStatement.setString(5, vine.getIsItQuiet());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                vine.setId(resultSet.getInt(1));
            }
            DBUtils.returnConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }

    private static ArrayList<Vine> createTinctures(ResultSet resultSet) throws SQLException {
        ArrayList<Vine> vines = new ArrayList<Vine>();
        while (resultSet.next()) {
            vines.add(createTincture(resultSet));
        }
        return vines;
    }

    private static Vine createTincture(ResultSet resultSet) throws SQLException {
        Vine vine = new Vine();
        vine.setName(resultSet.getString(2));
        vine.setCountry(resultSet.getString(3));
        vine.setCost(resultSet.getDouble(4));
        vine.setAdv(resultSet.getDouble(5));
        vine.setColor(resultSet.getString(6));
        vine.setType(resultSet.getString(6));
        vine.setIsItQuiet(resultSet.getString(6));
        return vine;
    }
}



