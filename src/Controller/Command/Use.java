
package Controller.Command;

import Model.Items.IItem;
import Model.Messages;
import Model.Map.CurrentLocation;
import java.util.HashMap;


/**
 *
 * @author Giannis
 */
public class Use implements ICommand {
    
    private Messages msg = new Messages();
    private String command;
    private HashMap validItemNames = new HashMap();

    
    public Use() {
        
        this.command = "use";

    }
    
    
    @Override
    public String getCommand(){
        return command;
    }
    
    /**
     * @param currentLocation
     * @param secondWord
     */
    @Override
    public void action(CurrentLocation currentLocation ,String secondWord){
        validItemNames = currentLocation.getPlayer().getPlayerInventory();
        IItem tempItem = currentLocation.getPlayer().getPlayerInventory().get(secondWord);
        if(validItemNames.containsValue(tempItem)){
            tempItem.itemAction(currentLocation,secondWord);
        }
        else {
            System.out.printf("You don't have that item in your inventory.\n");
        }
        
    }
}
