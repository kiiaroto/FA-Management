/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SR
 */
public class Database {

    protected static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    protected static final String URL = "jdbc:mysql://localhost/fa_management";
    protected static final String USER = "root";
    protected static final String PASSWORD = "root";

    public enum SortOrder {
        ASC, DESC;
    }

    static {
        // Chargement du pilote
        // Ne doit avoir lieu qu'une seule fois
        try {
            Class.forName(DRIVER_NAME).newInstance();
            System.out.println("*** Driver loaded.");
        } catch (ClassNotFoundException e) {
            System.err.println("*** ERROR: Driver " + DRIVER_NAME + " not found");
        } catch (InstantiationException e) {
            System.err.println("*** ERROR: Impossible to create an instance of " + DRIVER_NAME);
            System.err.println(e.getMessage());
        } catch (IllegalAccessException e) {
            System.err.println("*** ERROR: Impossible to create an instance of " + DRIVER_NAME);
            System.err.println(e.getMessage());
        }
    }

    /**
     * Fournit une connexion à la base de données. Ne fait pas appel à un pool de connexion, mâme si cela est envisageable plus tard (ne changerait rien à l'appel de la méthode)
     *
     * @throws java.sql.SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Réinitialise la base de données en appelant la procédure stockée produits_refresh().
     *
     * @throws SQLException
     */
    public static void reset() throws SQLException {
        Connection connection = Database.getConnection();
        CallableStatement stmt = connection.prepareCall("CALL fa_management_reset(now())");
        stmt.execute();
        stmt.close();
        connection.close();
    }
}
