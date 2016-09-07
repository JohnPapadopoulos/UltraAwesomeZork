/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Command;

import Model.Items.IItem;
import Model.Map.CurrentLocation;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Giannis
 */
public class Look implements ICommand {
    
    private String command;
    
    public Look(){
        command = "look";
    }
    
    /**
     * returns the given command
     * @return
     */
    @Override
    public String getCommand(){
        return command;
    }
    
    /**
     *
     * @param currentLocation
     * @param word
     */
    @Override
    public void action(CurrentLocation currentLocation ,String word){
        
        System.out.println("\nYou carefully looking around the room and you can see: ");
        HashMap<String, IItem> itemsList = currentLocation.getCurrentLocation().getItemToLocation();
        
        int counter = 0;
        for (Map.Entry<String, IItem> entry : itemsList.entrySet()) {
            System.out.printf(" -"+entry.getValue().getItemName()+"\n");
            counter++;
        }
        
        if (counter > 0){
            System.out.println("Some of these items can be very usefull...\n");
        }
        else {
            System.out.println("There are no items here!");
        }
    }
    
}
