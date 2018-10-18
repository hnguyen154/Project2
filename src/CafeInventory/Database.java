
package CafeInventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    
    Connection con = null;
    Statement st = null, st2;
    ResultSet rs = null;

    String  jdbc_drivers = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/cafe";

    //User login
    String user = "root";
    String password = "abcd";
    
    public Database(){
        
    }
    
    ArrayList output = new ArrayList();
    ArrayList line = new ArrayList();
    //Read method
    public ArrayList Read(String Table){
        
            try {
                System.setProperty("jdbc.drivers", jdbc_drivers);

                con = DriverManager.getConnection(url, user, password);
                st = con.createStatement();

                //Example
                    //TextBoxString = "select * from table;";
                
                String query = "Select * from " + Table + ";";
                rs = st.executeQuery(query);
                while (rs.next()) {
                    line.clear();
                    int id=rs.getInt("CID");
                    String number = rs.getString(2);
                    String description = rs.getString(3);
                    
                    line.add(id);line.add(number);line.add(description);
                    
                    output.add(line);
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
             
            return output;
    }

    
    int out = 0;
    //Create method
    public int Create(String Table, String stringData){
 
                
            try {
                System.setProperty("jdbc.drivers", jdbc_drivers);
                con = DriverManager.getConnection(url, user, password);
                st = con.createStatement();

                /*Create table
            //example
                insertString = "INSERT into [table_name] values (.., .., ..);
                */

                out = st.executeUpdate("insert into " + Table + " values " + "("+ stringData + ");");
                System.out.println("Inserted values into table in database...");
                

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
        return out;
    }
    
    //Delete method
    public void Delete(String Table, String colu1, String data1){
        
            try {
                System.setProperty("jdbc.drivers", jdbc_drivers);

                con = DriverManager.getConnection(url, user, password);
                st = con.createStatement();

                //Delete table
                String dropTable="delete from " + Table + " WHERE " + colu1 + " = " + data1;
                st.executeUpdate(dropTable);
                System.out.println("Deleted table in database...");
                

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
    public void Update(String Table, String colu1, String data1, String colu2, String data2){
          
                
            try {
                System.setProperty("jdbc.drivers", jdbc_drivers);

                con = DriverManager.getConnection(url, user, password);
                st = con.createStatement();


                String updateTable = "UPDATE " + Table +" SET " + colu1 + " = " + data1 + " WHERE " + colu2 + " = " + data2 + ";";
                st.executeUpdate(updateTable);
                System.out.println("Updated table in database...");
                

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


