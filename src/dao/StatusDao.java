/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Status;

/**
 *
 * @author SR
 */
public class StatusDao {
    
    public void findAll() throws SQLException {
        Connection con = Database.getConnection();
        String sql = "SELECT * FROM status ORDER BY id " + Database.SortOrder.ASC;
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            Status.getValues().put(rs.getInt("id"), rs.getString("libelle"));
        }
    }
    
}
