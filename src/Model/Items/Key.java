/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Items;

import Model.Map.CurrentLocation;
import Model.Map.ILocation;
import java.io.Serializable;

/**
 *
 * @author Giannis
 */
public class Key implements IItem, Serializable {
    private String itemName;
    private String itemDescription;
    
    public Key(String name, String description){
        this.itemName = name;
        this.itemDescription = description;
    }

    @Override
    public String getItemName(){
        return itemName; 
    }

    @Override
    public String getItemDescription(){
        return itemDescription;
    }

    @Override
    public void setItemDescription(String desrc){
        this.itemDescription = desrc;
    }

    @Override
    public void setItemName(String name){
        this.itemName = name;
    }
    
    /**
     *
     * @param currentLocation
     * @param word
     */
    @Override
    public void itemAction(CurrentLocation currentLocation, String word) {
        if (currentLocation.getPlayer().getPlayerInventory().containsKey(word)){
            switch (word) {
                case "strange key":
                    if (currentLocation.getCurrentLocation().getLocationName().equalsIgnoreCase("library")){
                        currentLocation.getCurrentLocation().getExitToLocation().get("west").setLocked(false);
                        ILocation location = currentLocation.getCurrentLocation().getExitToLocation().get("west").getNextLocation();
                        location.getExitToLocation().get("east").setLocked(false);
                        System.out.println("The door that leads to the Secret Room is now unlocked!");
                    }
                    else {
                        System.out.println("There is nothing to unlock with that key here!");
                    }
                    break;
                case "west secret passage key":
                    if (currentLocation.getCurrentLocation().getLocationName().equalsIgnoreCase("Mr & Ms Richman's Room")){
                        currentLocation.getCurrentLocation().getExitToLocation().get("west").setLocked(false);
                        ILocation location = currentLocation.getCurrentLocation().getExitToLocation().get("west").getNextLocation();
                        location.getExitToLocation().get("east").setLocked(false);
                        System.out.println("The door that leads to the Secret Passage is now unlocked!");
                    }
                    else if (currentLocation.getCurrentLocation().getLocationName().equalsIgnoreCase("Left Secret Passage")){
                        currentLocation.getCurrentLocation().getExitToLocation().get("east").setLocked(false);
                        ILocation location = currentLocation.getCurrentLocation().getExitToLocation().get("east").getNextLocation();
                        location.getExitToLocation().get("west").setLocked(false);
                        System.out.println("The door that leads to Mr & Ms Richman's Room is now unlocked!");
                    }
                    else {
                        System.out.println("There is nothing to unlock with that key here!");
                    }
                    break;
                case "east secret passage key":
                    if (currentLocation.getCurrentLocation().getLocationName().equalsIgnoreCase("Mr & Ms Richman's Room")){
                        currentLocation.getCurrentLocation().getExitToLocation().get("east").setLocked(false);
                        ILocation location = currentLocation.getCurrentLocation().getExitToLocation().get("east").getNextLocation();
                        location.getExitToLocation().get("west").setLocked(false);
                        System.out.println("The door that leads to the Secret Passage is now unlocked!");
                    }
                    else if (currentLocation.getCurrentLocation().getLocationName().equalsIgnoreCase("Right Secret Passage")){
                        currentLocation.getCurrentLocation().getExitToLocation().get("west").setLocked(false);
                        ILocation location = currentLocation.getCurrentLocation().getExitToLocation().get("west").getNextLocation();
                        location.getExitToLocation().get("east").setLocked(false);
                        System.out.println("The door that leads to Mr & Ms Richman's Room is now unlocked!");
                    }
                    else {
                        System.out.println("There is nothing to unlock with that key here!");
                    }
                    break;
                case "basement key":
                    if (currentLocation.getCurrentLocation().getLocationName().equalsIgnoreCase("kitchen")){
                        currentLocation.getCurrentLocation().getExitToLocation().get("east").setLocked(false);
                        ILocation location = currentLocation.getCurrentLocation().getExitToLocation().get("east").getNextLocation();
                        location.getExitToLocation().get("west").setLocked(false);
                        System.out.println("The door that leads to the Secret Room is now unlocked!");
                    }
                    else {
                        System.out.println("There is nothing to unlock with that key here!");
                    }
                    break;
            }
        }
    }
}
