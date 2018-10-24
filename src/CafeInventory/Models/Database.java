package CafeInventory.Models;

import CafeInventory.Views.View;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Database {

    Connection con = null;
    Statement st = null, st2;
    ResultSet rs = null;
    PreparedStatement pst = null;

    //String jdbc_drivers = "com.mysql.jdbc.Driver";
    String url = "jdbc:sqlite:cafe.db";

    //User login
//    String user = "root";
//    String password = "abcd";

    public Database() {

    }

    public boolean loginValid(String username, String pass) {
        boolean valid = false;
        try {
            //System.setProperty("jdbc.drivers", jdbc_drivers);

            con = DriverManager.getConnection(url);
            st = con.createStatement();

            //Example
            //TextBoxString = "select * from table;";
            String sql = "SELECT * FROM users WHERE username = ? and password = ?";

            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, pass);
            System.out.println(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                valid = true;
            } else {
                valid = false;
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

        return valid;
    }

    ArrayList output = new ArrayList();
    ArrayList line = new ArrayList();
    //Read method

    public ArrayList Read(String Table) {

        try {
            //System.setProperty("jdbc.drivers", jdbc_drivers);

            con = DriverManager.getConnection(url);
            st = con.createStatement();

            //Example
            //TextBoxString = "select * from table;";
            String query = "Select * from " + Table + ";";
            rs = st.executeQuery(query);
            while (rs.next()) {
                line.clear();
                int id = rs.getInt("CID");
                String number = rs.getString(2);
                String description = rs.getString(3);

                line.add(id);
                line.add(number);
                line.add(description);

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
    public int Create(String Table, String stringData) throws ClassNotFoundException {

        try {

            //Class.forName("com.mysql.cj.jdbc.Driver");

            //System.setProperty("jdbc.drivers", jdbc_drivers);
            con = DriverManager.getConnection(url);
            st = con.createStatement();


            /*Create table
            //example
                insertString = "INSERT into [table_name] values (.., .., ..);
             */
//            String sql = "INSERT INTO ? VALUES ( ? );";
//            pst = con.prepareStatement(sql);
//            pst.setString(1, Table);
//            pst.setString(2, stringData);
//            out = pst.executeUpdate();
            System.out.println("INSERT INTO " + Table + " VALUES " + "(" + stringData + ");");
            out = st.executeUpdate("INSERT INTO " + Table + " VALUES " + "(" + stringData + ");");
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

    public int AddItem(String name, String code, String price, String stock, String category, String unit) throws ClassNotFoundException {

        try {

            //Class.forName("com.mysql.cj.jdbc.Driver");

           // System.setProperty("jdbc.drivers", jdbc_drivers);
            con = DriverManager.getConnection(url);
            st = con.createStatement();


            /*Create table
            //example
                insertString = "INSERT into [table_name] values (.., .., ..);
             */
            String sql = "INSERT INTO Items(name, code, price, stock, category, unit) VALUES (?,?,?,?,?,?);";
            pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, code);
            pst.setString(3, price);
            pst.setString(4, stock);
            pst.setString(5, category);
            pst.setString(6, unit);
            pst.executeUpdate();
//            System.out.println("INSERT INTO " + Table + " VALUES " + "(" + stringData + ");");
//            out = st.executeUpdate("INSERT INTO " + Table + " VALUES " + "(" + stringData + ");");
//            System.out.println("Inserted values into table in database...");

        } catch (SQLException ex) {
            // Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                if (rs != null) {
                    rs.close();
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
    
     public int AddProvider(String surname, String ID, String address, String phone, String cmpName) throws ClassNotFoundException {

        try {

            //Class.forName("com.mysql.cj.jdbc.Driver");

            //System.setProperty("jdbc.drivers", jdbc_drivers);
            con = DriverManager.getConnection(url);
            st = con.createStatement();


            /*Create table
            //example
                insertString = "INSERT into [table_name] values (.., .., ..);
             */
            String sql = "INSERT INTO Providers(surname, ID, address, phone, cmpName) VALUES (?,?,?,?,?);";
            pst = con.prepareStatement(sql);
            pst.setString(1, surname);
            pst.setString(2, ID);
            pst.setString(3, address);
            pst.setString(4, phone);
            pst.setString(5, cmpName);
            pst.executeUpdate();
//            System.out.println("INSERT INTO " + Table + " VALUES " + "(" + stringData + ");");
//            out = st.executeUpdate("INSERT INTO " + Table + " VALUES " + "(" + stringData + ");");
//            System.out.println("Inserted values into table in database...");

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
     
     public int AddItemDes(String item, String description) throws ClassNotFoundException {

        try {

            //Class.forName("com.mysql.cj.jdbc.Driver");

            //System.setProperty("jdbc.drivers", jdbc_drivers);
            con = DriverManager.getConnection(url);
            st = con.createStatement();


            /*Create table
            //example
                insertString = "INSERT into [table_name] values (.., .., ..);
             */
            String sql = "INSERT INTO Itemdescription(name, description) VALUES (?,?);";
            pst = con.prepareStatement(sql);
            pst.setString(1, item);
            pst.setString(2, description);
            pst.executeUpdate();
//            System.out.println("INSERT INTO " + Table + " VALUES " + "(" + stringData + ");");
//            out = st.executeUpdate("INSERT INTO " + Table + " VALUES " + "(" + stringData + ");");
//            System.out.println("Inserted values into table in database...");

        } catch (SQLException ex) {
            // Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
//                if (st != null) {
//                    st.close();
//                }
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
    
    
    
    
    

    public void CreateTable(String Table, String stringData) throws ClassNotFoundException {

        try {

           // Class.forName("com.mysql.cj.jdbc.Driver");

           // System.setProperty("jdbc.drivers", jdbc_drivers);
            con = DriverManager.getConnection(url);
            st = con.createStatement();

            /*Create table
            //example
                insertString = "INSERT into [table_name] values (.., .., ..);
             */
//            String sql = "CREATE TABLE IF NOT EXISTS ? ?";
//            pst = con.prepareStatement(sql);
//            pst.setString(1, Table);
//            pst.setString(2, stringData);
//            out = pst.executeUpdate();
            out = st.executeUpdate("CREATE TABLE IF NOT EXISTS " + Table + " " + stringData);

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

    public void SearchName(View v, String name) {
        try {
           // System.setProperty("jdbc.drivers", jdbc_drivers);

            con = DriverManager.getConnection(url);
            st = con.createStatement();

            //Example
            //TextBoxString = "select * from table;";
            String sql = "SELECT * FROM Items WHERE name = ?";

            pst = con.prepareStatement(sql);
//            pst.setString(1, col);
            pst.setString(1, name);
            rs = pst.executeQuery();
            

            if (rs.next()) {
                System.out.println(rs.getString(1));
                v.setNameResultField(rs.getString(1));
                v.setCodeResulField(rs.getString(2));
                v.setPriceResultField(rs.getString(3));
                v.setStockResultField(rs.getString(4));
                //System.out.println(rs.getString(5));
                v.setUnitResultField(rs.getString(6));
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
    
    public void SearchCode(View v, String name) {
        try {
            //System.setProperty("jdbc.drivers", jdbc_drivers);

            con = DriverManager.getConnection(url);
            st = con.createStatement();

            //Example
            //TextBoxString = "select * from table;";
            String sql = "SELECT * FROM Items WHERE code = ?";

            pst = con.prepareStatement(sql);
//            pst.setString(1, col);
            pst.setString(1, name);
            rs = pst.executeQuery();
            

            if (rs.next()) {
                System.out.println(rs.getString(1));
                v.setNameResultField(rs.getString(1));
                v.setCodeResulField(rs.getString(2));
                v.setPriceResultField(rs.getString(3));
                v.setStockResultField(rs.getString(4));
                //System.out.println(rs.getString(5));
                v.setUnitResultField(rs.getString(6));
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


    //Delete method
//    public void Delete(String Table, String colu1, String data1) {
//
//        try {
//            System.setProperty("jdbc.drivers", jdbc_drivers);
//
//            con = DriverManager.getConnection(url, user, password);
//            st = con.createStatement();
//
//            //Delete table
//            String dropTable = "delete from " + Table + " WHERE " + colu1 + " = " + data1;
//            st.executeUpdate(dropTable);
//            System.out.println("Deleted table in database...");
//
//        } catch (SQLException ex) {
//            // Logger lgr = Logger.getLogger(Version.class.getName());
//            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (st != null) {
//                    st.close();
//                }
//                if (con != null) {
//                    con.close();
//                }
//
//            } catch (SQLException ex) {
//                // Logger lgr = Logger.getLogger(Version.class.getName());
//                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//                //lgr.log(Level.WARNING, ex.getMessage(), ex);
//            }
//        }
//    }
    
    // couldn't get a generic delete method working, delete is based on item code
    public void DeleteItem(String Table, String col, String data) {

        try {
           // System.setProperty("jdbc.drivers", jdbc_drivers);

            con = DriverManager.getConnection(url);
            st = con.createStatement();

            //Delete table
            String sql = "DELETE FROM Items WHERE code = ?";

            pst = con.prepareStatement(sql);
//            pst.setString(1, Table);
//            pst.setString(2, col);
            pst.setString(1, data);
            System.out.println(Table);
            System.out.println(col);
            System.out.println(data);
            pst.executeUpdate();

//            String dropTable = "delete from " + Table + " WHERE " + colu1 + " = " + data1;
//            st.executeUpdate(dropTable);
//            System.out.println("Deleted table in database...");
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
    
    public void DeleteDescription(String Table, String col, String data) {

        try {
            //System.setProperty("jdbc.drivers", jdbc_drivers);

            con = DriverManager.getConnection(url);
            st = con.createStatement();

            //Delete table
            String sql = "DELETE FROM itemdescription WHERE name = ?";

            pst = con.prepareStatement(sql);
//            pst.setString(1, Table);
//            pst.setString(2, col);
            pst.setString(1, data);
            System.out.println(Table);
            System.out.println(col);
            System.out.println(data);
            pst.executeUpdate();

//            String dropTable = "delete from " + Table + " WHERE " + colu1 + " = " + data1;
//            st.executeUpdate(dropTable);
//            System.out.println("Deleted table in database...");
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
    public void Update(String Table, String colu1, String data1, String colu2, String data2) {

        try {
           // System.setProperty("jdbc.drivers", jdbc_drivers);

            con = DriverManager.getConnection(url);
            st = con.createStatement();

            String updateTable = "UPDATE " + Table + " SET " + colu1 + " = " + data1 + " WHERE " + colu2 + " = " + data2 + ";";
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

    public DefaultTableModel buildTableModel() throws SQLException {

        ResultSet rs = st.executeQuery("SELECT * from Items");

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }

    public void updateInventoryTable(View v) throws SQLException {
        ResultSet s;
        try {
            //System.setProperty("jdbc.drivers", jdbc_drivers);

            con = DriverManager.getConnection(url);
            st = con.createStatement();

            String updateTable = "SELECT * FROM Items";
            s = st.executeQuery(updateTable);

            v.setInventoryTableModel(buildTableModel(s));


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
    
     public void updateProviderTable(View v) throws SQLException {
        ResultSet s;

        try {
            //System.setProperty("jdbc.drivers", jdbc_drivers);

            con = DriverManager.getConnection(url);
            st = con.createStatement();

            String updateTable = "SELECT * FROM Providers";
            s = st.executeQuery(updateTable);

            v.setProviderTableModel(buildTableModel(s));

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
    
     public void updateItemDescriptionTable(View v) throws SQLException {
        ResultSet s;

        try {
           // System.setProperty("jdbc.drivers", jdbc_drivers);

            con = DriverManager.getConnection(url);
            st = con.createStatement();

            String updateTable = "SELECT * FROM itemdescription";
            s = st.executeQuery(updateTable);

            v.setItemDescriptionTableModel(buildTableModel(s));

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

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }

    /*public static void main(String[] args) {
       Read();
       Create();
       Delete();
       Update();
    }*/
}
