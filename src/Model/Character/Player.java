/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Character;

import Model.Items.IItem;
import Model.Map.Location;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Giannis
 */
public class Player implements IPlayer, Serializable {
    
    private String name;
    private Location currentLocation;
    private HashMap<String, IItem> playerInventory = new HashMap<>();
    
    public Player() {
    }
    
    public Player(String name) {
        this.name = name;
    }

    /**
     * Enter the given room.
     * @param location
     */
    @Override
    public void enterLocation(Location location) {
        currentLocation = location;
    }

    /**
     * Gets the room in which the player is currently located.
     * @return 
     */
    @Override
    public Location getCurrentLocation() {
        return currentLocation;
    }

    /**
     * Get the name of the player.
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void setPlayerInventory(IItem item){
        playerInventory.put(item.getItemName(), item);
    }
    
    @Override
    public void removeFromPlayerInventory(IItem item){
        playerInventory.remove(item.getItemName());
    }
    
    @Override
    public HashMap<String, IItem> getPlayerInventory(){
        return playerInventory;
    }
   
}
