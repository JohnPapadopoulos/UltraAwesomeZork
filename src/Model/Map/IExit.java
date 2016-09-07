/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Map;

import Model.Map.ILocation;

/**
 *
 * @author Giannis
 */
public interface IExit {
    
    public String getDirection();
    public void setDirection(String direction);
    public ILocation getNextLocation();
    public void setNextLocation(ILocation nextLocation);
    public boolean getLocked();
    public void setLocked(boolean locked);
}
