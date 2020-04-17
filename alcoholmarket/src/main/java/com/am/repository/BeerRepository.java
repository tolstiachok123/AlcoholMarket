package com.am.repository;

import com.am.entity.AlcoholDrink;
import com.am.util.db.DBUtils;

import java.sql.*;
import java.util.ArrayList;

public class BeerRepository {

    private final String getBeerQuery = "Select * from Beer";

    private final String addBeerQuery = "INSERT INTO Beer (name, country, cost, ADV, color) VALUES (?, ?, ?, ?, ?)";

    public ArrayList<AlcoholDrink> getAlcoholDrinksListFromDB() {
        ArrayList<AlcoholDrink> beers = new ArrayList<>();
        try {
            Connection connection = DBUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getBeerQuery);
            beers.addAll(createBeers(resultSet));
            DBUtils.returnConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return beers;
    }

    public void addAlcoholDrinkToDB(Beer beer) {
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(addBeerQuery);
            preparedStatement.setString(1, beer.getName());
            preparedStatement.setString(2, beer.getCountry());
            preparedStatement.setDouble(3, beer.getCost());
            preparedStatement.setDouble(4, beer.getAdv());
            preparedStatement.setString(5, beer.getColor());
            preparedStatement.executeUpdate();
            ResultSet resultSet =  preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                beer.setId(resultSet.getInt(1));
            }
            DBUtils.returnConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }

    private static ArrayList<Beer> createBeers(ResultSet resultSet) throws SQLException {
        ArrayList<Beer> beers = new ArrayList<Beer>();
        while (resultSet.next()) {
            beers.add(createBeer(resultSet));
        }
        return beers;
    }

    private static Beer createBeer(ResultSet resultSet) throws SQLException{
        Beer beer = new Beer();
        beer.setName(resultSet.getString(2));
        beer.setCountry(resultSet.getString(3));
        beer.setCost(resultSet.getDouble(4));
        beer.setAdv(resultSet.getDouble(5));
        beer.setColor(resultSet.getString(6));
        return beer;
    }
}

