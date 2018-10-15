/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CafeInventory;

import java.awt.event.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Ludia
 */
public class Controller {
    
    public void init(LoginView view, Model model) {
        view.setVisible(true);
        
        view.addBtnLoginActionListener((ActionEvent evt) -> {
            String username = view.getUsernameField();
            String password = view.getPasswordField();
            JOptionPane.showMessageDialog(view, "username = " + username +
                    "\n password = " + password + "\n will implement after database is setup");
            
        });
        
        view.addBtnResetActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                view.setUsernameField("");
                view.setPasswordField("");
                
            }
        });
    
    view.addBtnExitActionListener ( 
        (ActionEvent evt) -> {
            System.exit(0);
    }

);

    }

}
