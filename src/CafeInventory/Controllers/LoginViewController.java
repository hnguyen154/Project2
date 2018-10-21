/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CafeInventory.Controllers;

import CafeInventory.Views.LoginView;
import CafeInventory.Models.Model;
import CafeInventory.Models.Database;
import CafeInventory.Views.View;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ludia
 */
public class LoginViewController {

    public void init(LoginView view, Model model) {
        view.setVisible(true);

        view.addLoginActionListener((ActionEvent evt) -> {
            Database db = new Database();
            if (db.loginValid(view.getUsername(), view.getPassword())) {
                JOptionPane.showMessageDialog(view, "Login Successful");
                view.setVisible(false);
                try {
                    new ViewController().init(new View(), model, db);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else {
                JOptionPane.showMessageDialog(view, "Wrong username or password");
            }
        });

        view.addResetActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                view.setUsername(" "); // Workaround due to username box being awt
                view.setUsername("");
                view.setPassword("");
            }
        });

        view.addExitActionListener(
                (ActionEvent evt) -> {
                    System.exit(0);
                }
        );

    }

}
