package CafeInventory.Models;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model {

    Database db = new Database();
    String readString, 
            insertString, insertdataString, 
            deleteString, deleteColString, deleteDataString,
            updateString, updateCol1String, updateData1String, updateCol2String, updateData2String;
    int out;
    
    boolean searchName = true;
    
    //Constructor
    public Model(){
        
    }
    
    public void setSearchName(boolean b) {
        searchName = b;
    }
    
    public boolean getSearchName() {
        return searchName;
    }
    
    
    
  /*  
    //String to read a table on database
    public void setreadString(String readString){
        this.readString = readString;
    }
    public ArrayList getreadString(){
        return db.Read(readString);
    }
    
    
    //String to "Create" (insert) a table on database
    public void setinsertString(String insertString, String insertdataString){
        this.insertString = insertString;
        this.insertdataString = insertdataString;
    }
    public int getinsertString(){
        try {
            return db.Create(insertString, insertdataString);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    //String to delete a row from a table on database
    public void setdeleteString(String deleteString, String deleteColString, String deleteDataString){
        this.deleteString = deleteString;
        this.deleteColString = deleteColString;
        this.deleteDataString = deleteDataString;
    }
    public void getdeleteString(){
        db.DeleteItem(deleteString, deleteColString, deleteDataString);
    }
    
    //String to update a table on database
    public void setupdateString(String updateString, String updateCol1String, String updateData1String, String updateCol2String, String updateData2String){
        this.updateString = updateString;
        this.updateCol1String = updateCol1String;
        this.updateData1String = updateData1String;
        this.updateCol2String = updateCol2String;
        this.updateData2String = updateData2String;
    }
    public void getupdateString(){
        db.Update(updateString, updateCol1String, updateData1String, updateCol2String, updateData2String);
    }
    */
    
    
}