package CafeInventory;

/* Name: Anthony Hsia, Grandy Nguyen, Hao Nguyen
 * Class: CSC 4380
 * Title: Project 2 - Coffee Inventory
 * Date: October 10, 2018
 */


public class Main {

    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller control = new Controller(view,model);
        view.setVisible(true);
    }
    
}
