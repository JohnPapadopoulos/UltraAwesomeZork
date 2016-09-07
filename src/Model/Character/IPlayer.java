/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Character;

import Model.Items.IItem;
import Model.Map.Location;
import java.util.HashMap;

/**
 *
 * @author Giannis
 */
public interface IPlayer {
    
    public void enterLocation(Location location);
    public Location getCurrentLocation();
    public String getName();
    public void setPlayerInventory(IItem item);
    public void removeFromPlayerInventory(IItem item);
    public HashMap<String, IItem> getPlayerInventory();

}
