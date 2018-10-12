
package CafeInventory;

public class Model {

    String readString;
    
    //Constructor
    public Model(){
        
    }
    
    //String from View textbox to read a table on database
    public void setreadString(String readString){
        this.readString = readString;
    }
    public String getreadString(){
        return readString;
    }
    
}

