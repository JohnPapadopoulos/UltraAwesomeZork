/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Command;

import Model.Map.CurrentLocation;

/**
 *
 * @author Giannis
 */
public class ExitGame implements ICommand {
    
    private String command;
    
    public ExitGame(){
        command = "exit";
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
     * If the user types "exit", it prints a thank you message and closes the game
     * @param currentLocation
     * @param word
     */
    @Override
    public void action (CurrentLocation currentLocation, String word){
        System.out.println("Thank you for playing. We hope you had fun!");
        System.exit(0);
    }
}
