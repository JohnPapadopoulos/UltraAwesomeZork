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


/**
 *
 * @author Giannis
 */
public class Toss implements ICommand {

    private Messages msg = new Messages();
    private String command;
    private HashMap validItemNames =  new HashMap();
    
    public Toss() {
        this.command = "toss";
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
            currentLocation.getCurrentLocation().setItemToLocation(item);
            currentLocation.getPlayer().removeFromPlayerInventory(item);
            System.out.println(" -You just tossed a " + item.getItemName() + "!");
        }
        else{
            System.out.println(" -There is no such item here!");
        }
    }
}
