/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CafeInventory.Controllers;

import CafeInventory.Models.Database;
import CafeInventory.Models.Model;
import CafeInventory.Views.LoginView;
import CafeInventory.Views.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ludia
 */
public class ViewController {

    public void init(View view, Model model, Database db) throws SQLException {
        view.setVisible(true);
        view.setTitle("Coffee Inventory");

        // Initial db view
        db.updateInventoryTable(view);
        db.updateProviderTable(view);
        db.updateItemDescriptionTable(view);
        
        view.addLogOutListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                view.setVisible(false);
                LoginView v = new LoginView();
                new LoginViewController().init(v, model);
            }

        });

        view.addDeleteItemBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                db.DeleteItem("Items", "code", view.getCodeAddField());
                db.DeleteDescription("ItemDescription", "name", view.getNameAddField());
                try {
                    db.updateInventoryTable(view);
                    db.updateItemDescriptionTable(view);
                    JOptionPane.showMessageDialog(view, "Item deleted successfully.");
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        view.addUpdateBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                try {
                    db.AddItem(view.getNameAddField(), view.getCodeAddField(), view.getPriceAddField(), view.getStockAddField(), view.getCategoryField(), view.getUnitField());
                    db.AddItemDes(view.getNameAddField(), view.getItemDescriptionField());
                    db.updateInventoryTable(view);
                    db.updateItemDescriptionTable(view);
                    JOptionPane.showMessageDialog(view, "Item added successfully.");

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        view.addResetBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // workaround due to textboxes being awt
                view.setNameAddField(" ");
                view.setNameAddField("");
                view.setStockAddField("");
                view.setStockAddField(" ");
                view.setPriceAddField(" ");
                view.setPriceAddField("");
                view.setCodeAddField(" ");
                view.setCodeAddField("");
                view.setCategoryField();
                view.setUnitField();
            }

        });

        view.addSearchBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // workaround due to textboxes being awt
                if(model.getSearchName()) {
                    db.SearchName(view, view.getNameField());
                }
                else {
                    db.SearchCode(view, view.getItemCodeField());
                }
            }
        });

        view.addNameFieldListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                
            }

            @Override
            public void focusGained(FocusEvent e) {
                view.setItemCodeField("");
                model.setSearchName(true);
            }

        });
        
        view.addItemCodeFieldListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                
            }

            @Override
            public void focusGained(FocusEvent e) {
                view.setNameField("");
                model.setSearchName(false);
            }

        });
        
        view.addResetCustomerBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // workaround due to textboxes being awt
                view.setAgentNameField(" ");
                view.setAgentNameField("");
                view.setIDField(" ");
                view.setIDField("");
                view.setAddressField(" ");
                view.setAddressField("");
                view.setCompanyNameField(" ");
                view.setCompanyNameField("");
                view.setPhoneNumberField(" ");
                view.setPhoneNumberField("");

            }

        });

        view.addAddCustomerBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                try {
                    db.AddProvider(view.getAgentNameField(), view.getIDField(), view.getAddressField(), view.getCompanyNameField(), view.getPhoneNumberField());
                    db.updateProviderTable(view);
                    JOptionPane.showMessageDialog(view, "Provider added successfully.");

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }
}
