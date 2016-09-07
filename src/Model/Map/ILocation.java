/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Map;

import Model.Items.IItem;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Giannis
 */
public interface ILocation {
    
    public void setLocationName(String locationName);
    public String getLocationName();
    public void setLocationDescr(String locationDescr);
    public String getLocationDescr();
    public void setExitToLocation(IExit exit);
    public HashMap<String, IExit> getExitToLocation();
    public void setItemToLocation(IItem item);
    public void removeItemFromLocation(IItem item);
    public HashMap<String, IItem> getItemToLocation();

}
