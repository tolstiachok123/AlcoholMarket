package com.am.repository;

import com.am.entity.AlcoholDrink;
import com.am.util.db.DBUtils;

import java.sql.*;
import java.util.ArrayList;

public class LiqueurRepository {

    private final String getLiqueurQuery = "Select * from Liqueurs";

    private final String addLiqueurQuery = "INSERT INTO Liqueurs (name, country, cost, ADV, sugarContent) VALUES (?, ?, ?, ?, ?)";

    public ArrayList<AlcoholDrink> getAlcoholDrinksListFromDB() {
        ArrayList<AlcoholDrink> liqueurs = new ArrayList<AlcoholDrink>();
        try {
            Connection connection = DBUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getLiqueurQuery);
            liqueurs.addAll(createLiqueurs(resultSet));
            DBUtils.returnConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return liqueurs;
    }

    public void addAlcoholDrinkToDB(Liqueur liqueur) {
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(addLiqueurQuery);
            preparedStatement.setString(1, liqueur.getName());
            preparedStatement.setString(2, liqueur.getCountry());
            preparedStatement.setDouble(3, liqueur.getCost());
            preparedStatement.setDouble(4, liqueur.getAdv());
            preparedStatement.setDouble(5, liqueur.getSugarContent());
            preparedStatement.executeUpdate();
            ResultSet resultSet =  preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                liqueur.setId(resultSet.getInt(1));
            }
            DBUtils.returnConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }

    private static ArrayList<Liqueur> createLiqueurs(ResultSet resultSet) throws SQLException {
        ArrayList<Liqueur> liqueurs = new ArrayList<Liqueur>();
        while (resultSet.next()) {
            liqueurs.add(createLiqueur(resultSet));
        }
        return liqueurs;
    }

    private static Liqueur createLiqueur(ResultSet resultSet) throws SQLException{
        Liqueur liqueur = new Liqueur();
        liqueur.setName(resultSet.getString(2));
        liqueur.setCountry(resultSet.getString(3));
        liqueur.setCost(resultSet.getDouble(4));
        liqueur.setAdv(resultSet.getDouble(5));
        liqueur.setSugarContent(resultSet.getDouble(6));
        return liqueur;
    }
}
