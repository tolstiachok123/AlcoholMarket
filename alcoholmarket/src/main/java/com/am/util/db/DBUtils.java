package com.am.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;

public class DBUtils {

    private final static String url = "jdbc:mysql://localhost:3306/AlcoholMarket";
    private final static String user = "";
    private final static String password = "";

    private final static ArrayBlockingQueue<Connection> connections = new ArrayBlockingQueue<Connection>(7);

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            for (int i = 0; i < 7; i++) {
                try {
                    connections.add(getConnection());
                } catch (SQLException e) {
                    System.out.println(e.getStackTrace());
                }
            }
        } catch (ClassNotFoundException e) {
                System.out.println(e.getStackTrace());
        }
    }

    public static void returnConnection(Connection newConnection) {
       connections.offer(newConnection);
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static Connection connection() {
        return connections.peek();
    }
}
