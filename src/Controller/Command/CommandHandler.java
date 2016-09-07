/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Command;

import Model.Map.CurrentLocation;
import java.util.HashMap;

/**
 *
 * @author Giannis
 */
public class CommandHandler {
    
    private HashMap<String, ICommand> mapCommand = new HashMap<>();
    
    public void register (ICommand command){
        mapCommand.put(command.getCommand(), command);
    }
    
    public void handle(String firstWord, String secondWord, CurrentLocation currentLocation){
        if (mapCommand.containsKey(firstWord)){
            mapCommand.get(firstWord).action(currentLocation, secondWord);
        }
        else if (firstWord.equalsIgnoreCase("save") || firstWord.equalsIgnoreCase("load") || firstWord.equalsIgnoreCase("exit")){
            
        }
        else {
            System.out.println("Please type a valid command!");
        }
    }
}
