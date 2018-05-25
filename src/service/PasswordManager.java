/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDao;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import model.User;
import tools.PasswordEncrypter;

/**
 *
 * @author SR
 */
public class PasswordManager {

    // Put method like verify password for the connection
    // and change password & more about password
    public User verifyPassword(String email, char[] password) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
        UserDao userDao = new UserDao();
        User user = userDao.findByEmail(email);
        if (PasswordEncrypter.validatePassword(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }

    public User changePassword(User user, char[] newPassword) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
        UserDao userDao = new UserDao();
        User user2 = userDao.findByEmail(user.getEmail());
        
        if (user2.equalsWithoutPassword(user)) {
            String encryptedPassword = PasswordEncrypter.generateStorngPasswordHash(newPassword);
            System.out.println("----------" + encryptedPassword);
            user = userDao.updatePassword(user, encryptedPassword);
        }
        return user;
    }

    public void createPassword() {
        
    }
}
