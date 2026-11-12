package ies.juanbosco.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionDB {
private static final String URL = "jdbc:mysql://localhost:3306/Pokemon";
    private static final String USER = "root";
    private static final String PASSWORD = "admin123";
//creamos los parametros iniciales URL - USER - PASSWORD
    //Cada uno con sus datos que pusimos en la bdd

    public static Connection getConexionDB() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
