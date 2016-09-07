/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Command;

import Model.Messages;
import Model.Map.CurrentLocation;
import Model.Map.ILocation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Giannis
 */
public class Go implements ICommand {
    
    private Messages msg = new Messages();
    private String command;
    private List<String> validSecondWord = new ArrayList<>(3); //the available directions
    
    public Go(){
        this.command = "go";
        validSecondWord.add("north");
        validSecondWord.add("east");
        validSecondWord.add("south");
        validSecondWord.add("west");
    }
    
    @Override
    public String getCommand(){
        return command;
    }
    
    /**
     * The method checks if secondWord is valid. If it is, the method checks if 
     * it is an available exit. If it is, the method changes and prints the 
     * current location. If it is not, the method prints an error message. If
     * secondWord is not valid, the method prints a different error message.
     * @param currentLocation
     * @param secondWord
     */
    @Override
    public void action(CurrentLocation currentLocation, String secondWord){
        if (validSecondWord.contains(secondWord)) {
            if (currentLocation.getCurrentLocation().getExitToLocation().containsKey(secondWord)){
                ILocation location = currentLocation.getCurrentLocation().getExitToLocation().get(secondWord).getNextLocation();
                boolean locked = currentLocation.getCurrentLocation().getExitToLocation().get(secondWord).getLocked();
                
                if (locked == true){
                    System.out.println("You need a key to open the door! \nDo you have a key you can use?");
                }
                else {
                    currentLocation.setCurrentLocation(location);
                    currentLocation.showCurrentLocation();
                }
            }
            else {
                msg.noDirection();
            }
        }
        else {
            msg.wrongDirection();
        }
    }
}
