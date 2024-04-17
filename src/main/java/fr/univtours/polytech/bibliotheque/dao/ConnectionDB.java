package fr.univtours.polytech.bibliotheque.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.NamingException;

public class ConnectionDB {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/boutique";
    private static final String DB_USER = "root";
    private static final String DB_PWD = "password";

    public static Connection createConnection() throws SQLException, NamingException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        }

        return null;
    }
}