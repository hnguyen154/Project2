package CafeInventory;

import CafeInventory.Controllers.LoginViewController;
import CafeInventory.Views.LoginView;
import CafeInventory.Models.Model;
import CafeInventory.Models.Database;

/* Name: Anthony Hsia, Grandy Nguyen, Hao Nguyen
 * Class: CSC 4380
 * Title: Project 2 - Coffee Inventory
 * Date: October 10, 2018
 */


public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        LoginView view = new LoginView();
        Model model = new Model();
        new LoginViewController().init(view, model);
        view.setTitle("Coffee Inventory");

        databaseSetup();

    }


    public static void databaseSetup() throws ClassNotFoundException {
        Database db = new Database();

        db.CreateTable("Users", "(username VARCHAR(255), password VARCHAR(255))");
        db.CreateTable("Items", "(name VARCHAR(255), code VARCHAR(255), price VARCHAR(255), stock VARCHAR(255), category VARCHAR(255), unit VARCHAR(255))");
        db.CreateTable("Providers", "(surname VARCHAR(255), ID VARCHAR(255), address VARCHAR(255), phone VARCHAR(255), cmpName VARCHAR(255))");
        db.CreateTable("ItemDescription", "(name VARCHAR(255), description VARCHAR(255))");
        db.Create("Users(username, password)", "\"admin\", \"1234\"");



    }

}
