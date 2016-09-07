/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Map;

import java.io.Serializable;


/**
 *
 * @author Giannis
 */
public class Exit implements IExit, Serializable {
    
    private String direction;
    private ILocation nextLocation;
    private boolean locked;
    
    public Exit(){
        
    }
    
    public Exit(String direction, ILocation nextLocation, boolean locked){
        this.direction = direction;
        this.nextLocation = nextLocation;
        this.locked = locked;
    }
    
    /**
     * Return the direction of the exit
     * @return direction
     */
    @Override
    public String getDirection(){
        return direction;
    }
    
    /**
     * Sets the direction of the exit
     * @param direction
     */
    @Override
    public void setDirection(String direction){
        this.direction = direction;
    }
    
    /**
     * Returns the location the exit leads to
     * @return nextLocation
     */
    @Override
    public ILocation getNextLocation(){
        return nextLocation;
    }
    
    /**
     * Sets the location the exit leads to
     * @param nextLocation
     */
    @Override
    public void setNextLocation(ILocation nextLocation){
        this.nextLocation = nextLocation;
    }
    
    /**
     *
     * @return
     */
    @Override
    public boolean getLocked(){
        return locked;
    }
    
    /**
     *
     * @param locked
     */
    @Override
    public void setLocked(boolean locked){
        this.locked = locked;
    }
}
