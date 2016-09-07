package Controller.Command;

import Model.Items.IItem;
import Model.Map.CurrentLocation;
import Model.Messages;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Giannis
 */
public class Inventory implements ICommand {
    
    Messages msg = new Messages();
    private String command;
    
    public Inventory(){
        this.command = "inventory";
    }
    
    @Override
    public String getCommand(){
        return command;
    }
    
    @Override
    public void action(CurrentLocation currentLocation ,String secondWord){
        
        HashMap<String, IItem> itemsList = currentLocation.getPlayer().getPlayerInventory();
        
        System.out.printf("\tItems in your Inventory.\n");
        int counter = 0;
        for (Map.Entry<String, IItem> entry : itemsList.entrySet()) {
            System.out.printf(" -"+entry.getValue().getItemName()+"\n");
            counter++;
            
        }
        if (counter == 0){
            msg.emptyInventory();
        }
      
    }
}
