
package CafeInventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
   
    private String createTable = "", insertString = ""; 
    public String table = "";
    public String columnHeader = "";
    private Model model = new Model();
    
    //Read method
    public void Read(){
        
        Connection con = null;
        Statement st = null, st2;
        ResultSet rs = null;

        String  jdbc_drivers = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/cafeinventory";
        String user = "root";
        String password = "abcd";
        
        
            try {
                System.setProperty("jdbc.drivers", jdbc_drivers);

                con = DriverManager.getConnection(url, user, password);
                st = con.createStatement();

                //Example
                    //TextBoxString = "select * from table;";
                
                //get a string of User input from textbox
                rs = st.executeQuery(model.getreadString());
                while (rs.next()) {

                    System.out.println(rs.getString(1) + " " + rs.getString(2) );
                }

            } catch (SQLException ex) {
                //Logger lgr = Logger.getLogger(Version.class.getName());
                //lgr.log(Level.SEVERE, ex.getMessage(), ex);
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);

            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (st != null) {
                        st.close();
                    }
                    if (con != null) {
                        con.close();
                    }

                } catch (SQLException ex) {
                    // Logger lgr = Logger.getLogger(Version.class.getName());
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                    //lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
            }
             
    }

    //Create method
    public void Create(){
        
        Connection con = null;
        Statement st = null, st2;
        ResultSet rs = null;

        String  jdbc_drivers = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/stuff";
        String user = "ahsia";
        String password = "abcd";
 
                
            try {
                System.setProperty("jdbc.drivers", jdbc_drivers);
                con = DriverManager.getConnection(url, user, password);
                st = con.createStatement();

                /*Create table
            //example
                createTable = "CREATE TABLE corvette"  +
                        "(Vetted_id INT(11) NOT NULL AUTO_INCREMENT, " +
                        " Body_Style CHAR(12), " +
                        " PRIMARY KEY (Vetted_id))";
                */

                if(!table.isEmpty()){
                    //createTable = get string from a textbox from View class
                    st.executeUpdate(createTable);
                    System.out.println("Created table in database...");
                }

            } catch (SQLException ex) {
                // Logger lgr = Logger.getLogger(Version.class.getName());
                //lgr.log(Level.SEVERE, ex.getMessage(), ex);
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);

            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (st != null) {
                        st.close();
                    }
                    if (con != null) {
                        con.close();
                    }

                } catch (SQLException ex) {
                    // Logger lgr = Logger.getLogger(Version.class.getName());
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                    //lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
            }
        
    }
    
    //Delete method
    public void Delete(){
        Connection con = null;
        Statement st = null, st2;
        ResultSet rs = null;

        String  jdbc_drivers = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/stuff";
        String user = "ahsia";
        String password = "abcd";
        

                //Example
                String dropTable="DROP TABLE IF EXISTS " + table;

            try {
                System.setProperty("jdbc.drivers", jdbc_drivers);

                con = DriverManager.getConnection(url, user, password);
                st = con.createStatement();

                //Delete table
                if(!table.isEmpty()){
                    //dropTable = get String from textbox from View class
                    st.executeUpdate(dropTable);
                    System.out.println("Deleted table in database...");
                }

            } catch (SQLException ex) {
                // Logger lgr = Logger.getLogger(Version.class.getName());
                //lgr.log(Level.SEVERE, ex.getMessage(), ex);
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);

            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (st != null) {
                        st.close();
                    }
                    if (con != null) {
                        con.close();
                    }

                } catch (SQLException ex) {
                    // Logger lgr = Logger.getLogger(Version.class.getName());
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                    //lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
            }
    }
    
    
    //Update method
    public void Update(){
        Connection con = null;
        Statement st = null, st2;
        ResultSet rs = null;

        String  jdbc_drivers = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/stuff";
        String user = "ahsia";
        String password = "abcd";
       

                //Example
                String updateTable = "UPDATE pet SET NULL = 'Hello' WHERE id = 3;";
                
            try {
                System.setProperty("jdbc.drivers", jdbc_drivers);

                con = DriverManager.getConnection(url, user, password);
                st = con.createStatement();

                //Delete table
                if(!table.isEmpty()){
                    //updateTable = get String from a textbox from View class
                    st.executeUpdate(updateTable);
                    System.out.println("Updated table in database...");
                }

            } catch (SQLException ex) {
                // Logger lgr = Logger.getLogger(Version.class.getName());
                //lgr.log(Level.SEVERE, ex.getMessage(), ex);
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);

            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (st != null) {
                        st.close();
                    }
                    if (con != null) {
                        con.close();
                    }

                } catch (SQLException ex) {
                    // Logger lgr = Logger.getLogger(Version.class.getName());
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                    //lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
            }
    }
    
    /*public static void main(String[] args) {
       Read();
       Create();
       Delete();
       Update();
    }*/
    
}


