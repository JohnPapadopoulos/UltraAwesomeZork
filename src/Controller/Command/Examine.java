package Controller.Command;


import Model.Items.IItem;
import Model.Map.CurrentLocation;
import Model.Messages;
import java.util.HashMap;



public class Examine implements ICommand {
    
    private Messages msg = new Messages();
    private String command;
    HashMap validItemNames =  new HashMap();

    
    public Examine() {
        this.command = "examine";
    }
    
    
    @Override
    public String getCommand(){
        return command;
    }
    
    @Override
    public void action(CurrentLocation currentLocation ,String secondWord){
        validItemNames = currentLocation.getPlayer().getPlayerInventory();
        IItem tempItem = currentLocation.getPlayer().getPlayerInventory().get(secondWord);
        if (validItemNames.containsValue(tempItem)) {
            
            IItem item = currentLocation.getPlayer().getPlayerInventory().get(secondWord);
            System.out.println("You carefully examine the "+item.getItemName()+"...");
            System.out.println(" -"+item.getItemDescription());
        }
        else{
            msg.notInInventory();
        }
    }
}
