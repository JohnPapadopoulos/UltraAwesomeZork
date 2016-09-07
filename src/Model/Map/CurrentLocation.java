/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Map;

import Model.Character.IPlayer;
import java.io.Serializable;

/**
 *
 * @author Giannis
 */
public class CurrentLocation implements Serializable{
    
    private ILocation location;
    private IPlayer player;
    private String current;
    
    public IPlayer getPlayer(){
        return player;
    }
    
    public void setPlayer(IPlayer player){
        this.player = player;
    }
    
    public CurrentLocation(ILocation location, IPlayer player){
        this.location = location;
        this.player = player;
    }
    
    public ILocation getCurrentLocation(){
        return location;
    }
    
    public void setCurrentLocation(ILocation location){
        this.location = location;
    }
    
    public void showCurrentLocation(){
        current = location.getLocationName() + " " + location.getLocationDescr();
        System.out.println(current);
    }
    
}
