/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Member;

/**
 *
 * @author SR
 */
public class MemberDao {
    
    public void add(Member member) throws SQLException {
        
        Connection con = Database.getConnection();
        String sql = "INSERT INTO member(id_status, name, free_company, plateform, comment, lodestone_number, join_date) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, member.getStatus());
        stmt.setString(2, member.getName());
        stmt.setString(3, member.getFc());
        stmt.setString(4, member.getPlateform());
        stmt.setString(5, member.getComment());
        stmt.setString(6, member.getLodestoneNumber());
        stmt.setTimestamp(7, Timestamp.valueOf(member.getJoinDate().atTime(0, 0)));
        
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }
    
    public List<Member> findAll() throws SQLException {
        Connection con = Database.getConnection();
        String sql = "SELECT * FROM member ORDER BY id_status, id " + Database.SortOrder.ASC;
        Statement stmt = con.createStatement();
        
        ResultSet rs = stmt.executeQuery(sql);
        
        List<Member> memberList = new ArrayList<>();
        
        while (rs.next()) {
            Member member = new Member(
                    rs.getInt("id"),
                    rs.getInt("id_status"),
                    rs.getString("name"),
                    rs.getString("free_company"),
                    rs.getString("plateform"),
                    rs.getString("comment"),
                    rs.getString("lodestone_number"),
                    rs.getTimestamp("join_date").toLocalDateTime().toLocalDate());
            
            memberList.add(member);
        }
        
        stmt.close();
        con.close();
        
        if (memberList.isEmpty()) {
            return null;
        } else {
            return memberList;
        }
    }
    
    public void update(Member member) throws SQLException {
        
        Connection con = Database.getConnection();
        String sql = "UPDATE member SET id_status = ?, name = ?, free_company = ?, plateform = ?, comment = ?, lodestone_number = ? WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, member.getStatus());
        stmt.setString(2, member.getName());
        stmt.setString(3, member.getFc());
        stmt.setString(4, member.getPlateform());
        stmt.setString(5, member.getComment());
        stmt.setString(6, member.getLodestoneNumber());
        stmt.setInt(7, member.getId());
        
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }
    
    public void delete(Member member) throws SQLException {
        Connection con = Database.getConnection();
        String sql = "DELETE FROM member WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, member.getId());
        
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }
}
