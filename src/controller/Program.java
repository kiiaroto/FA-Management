/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Member;
import service.MemberList;
import model.User;
import tools.PasswordEncrypter;
import view.LoginWindow;
import view.ManagementWindow;

/**
 *
 * @author SR
 */
public class Program {

    public static void main(String[] args) {

        try {

            //new RankDao().findAll();
            //new StatusDao().findAll();
            User user = new User(0, 2, "test@gmail.com", "test", PasswordEncrypter.generateStorngPasswordHash("testo".toCharArray()));

            Member member1 = new Member(1, 2, "fii foo", "Fallen Angel", "PS4", "cool boy", "156578943", LocalDate.now());
            Member member2 = new Member(2, 4, "Sam Lescasses", "Fallen Angels", "PC", "reddy", "165465123", LocalDate.now());

            MemberList memberList = new MemberList();
            memberList.addMember(member1);
            memberList.addMember(member2);
            String password = PasswordEncrypter.generateStorngPasswordHash("gktpqutlvuropasg".toCharArray());

            System.out.println(member1.getStatus());
            System.out.println(password.length() + " long AND " + password);

            System.out.println(memberList.findById(1));
            System.out.println(memberList.findByName("Sam Lescasses"));

            System.out.println(LocalDate.now());

            UserDao userDao = new UserDao();
            try {
                User user0 = new User(24, 2, "insertmail@gmail.com", "insertName", PasswordEncrypter.generateStorngPasswordHash("testpassword".toCharArray()));
                System.out.println("creation done");
                //userDao.add(user0);
                user0 = userDao.updatePassword(user0, "passwor".toCharArray());
                System.out.println("update done");
                System.out.println("user0 = " + user0);

            } catch (SQLException ex) {
                Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
            }

            new LoginWindow().setVisible(true);
            new ManagementWindow().setVisible(true);

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
