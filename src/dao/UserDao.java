/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;
import tools.PasswordEncrypter;

/**
 *
 * @author SR
 */
public class UserDao {

    public void add(User user) throws SQLException {
        Connection con = Database.getConnection();
        String sql = "INSERT INTO user(id_rank, email, name, password) VALUES"
                + "(?, ?, ?, ?)";

        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setInt(1, user.getRank());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, user.getName());
        stmt.setString(4, user.getPassword());

        stmt.executeUpdate();

        stmt.close();
        con.close();
    }

    public User findByEmail(String email) throws SQLException {

        Connection con = Database.getConnection();
        String sql = "SELECT * FROM user WHERE email = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, email);

        ResultSet rs = stmt.executeQuery();
        User user = null;

        if (rs.next()) {
            user = new User(
                    rs.getInt("id"),
                    rs.getInt("id_rank"),
                    rs.getString("email"),
                    rs.getString("name"),
                    rs.getString("password"));
        }
        stmt.close();
        con.close();
        return user;
    }

    public List<User> findAll() throws SQLException {

        List<User> userList = new ArrayList<>();
        Connection con = Database.getConnection();
        String sql = "SELECT id, id_rank, email, name FROM user ORDER BY id_rank, id " + Database.SortOrder.ASC;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            User user = new User(
                    rs.getInt("id"),
                    rs.getInt("id_rank"),
                    rs.getString("email"),
                    rs.getString("name"),
                    null);

            userList.add(user);
        }
        stmt.close();
        con.close();
        if (userList.isEmpty()) {
            return null;
        } else {
            return userList;
        }
    }

    public User updatePassword(User user, String password) throws SQLException {
        Connection con = Database.getConnection();
        String sql = "UPDATE user SET password = ? WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, password);
        stmt.setInt(2, user.getId());

        stmt.executeUpdate();

        user.setPassword(password);

        stmt.close();
        con.close();

        return user;
    }

    public void delete(User user) throws SQLException {
        Connection con = Database.getConnection();
        String sql = "DELETE FROM user WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, user.getId());

        stmt.executeUpdate();
        stmt.close();
        con.close();
    }
}
