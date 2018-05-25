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
import model.Rank;

/**
 *
 * @author SR
 */
public class RankDao {
    
    public void findAll() throws SQLException {
        Connection con = Database.getConnection();
        String sql = "SELECT * FROM rank ORDER BY id " + Database.SortOrder.ASC;
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            Rank.getValues().put(rs.getInt("id"), rs.getString("libelle"));
        }
    }
    
}
