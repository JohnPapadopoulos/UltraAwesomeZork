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
public interface ICommand {
    
    public String getCommand();
    public void action(CurrentLocation currentLocation ,String secondWord);
}
