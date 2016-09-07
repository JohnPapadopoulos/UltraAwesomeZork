/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Command;

import Model.Items.IItem;
import Model.Map.CurrentLocation;
import Model.Messages;
import java.util.HashMap;


public class Pick implements ICommand {
    
    private Messages msg = new Messages();
    private String command;
    private HashMap validItemNames =  new HashMap();


    
    public Pick() {
        this.command = "pick";
    }
    
    @Override
    public String getCommand(){
        return command;
    }
    
    @Override
    public void action(CurrentLocation currentLocation ,String secondWord){
        validItemNames = currentLocation.getCurrentLocation().getItemToLocation();
        IItem tempItem = currentLocation.getCurrentLocation().getItemToLocation().get(secondWord);
        if (validItemNames.containsKey(secondWord)) {
            IItem item = currentLocation.getCurrentLocation().getItemToLocation().get(secondWord);
            currentLocation.getCurrentLocation().removeItemFromLocation(item);
            currentLocation.getPlayer().setPlayerInventory(item);
            System.out.println(" -You just picked a " + item.getItemName() + "!");
        }
        else{
            System.out.println(" -There is no such item here!");
        }
    }
}
