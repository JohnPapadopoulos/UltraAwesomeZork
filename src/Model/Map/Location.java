package Model.Map;

import Model.Items.IItem;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 *
 * @author Giannis
 */
public class Location implements ILocation, Serializable {
    
    private String locationName;
    private String locationDescr;
    private HashMap<String, IExit> mapExit = new HashMap<>();
    private HashMap<String, IItem> mapItem = new HashMap<>();

    public Location() {

    }

    /**
     * Full constructor
     *
     * @param locationName
     * @param locationDescr
     */
    public Location(String locationName, String locationDescr) {

        this.locationName = locationName;
        this.locationDescr = locationDescr;
    }

    /**
     * sets the name of the location
     *
     * @param locationName
     */
    @Override
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * returns the name of the location
     *
     * @return
     */
    @Override
    public String getLocationName() {
        return locationName;
    }

    /**
     * sets the description of the location
     *
     * @param locationDescr
     */
    @Override
    public void setLocationDescr(String locationDescr) {
        this.locationDescr = locationDescr;
    }

    /**
     * Returns the description of the location
     *
     * @return
     */
    @Override
    public String getLocationDescr() {
        return locationDescr;
    }
    
    /**
     * Assigns an exit to the location
     * @param exit
     */
    @Override
    public void setExitToLocation(IExit exit){
        mapExit.put(exit.getDirection(), exit);
    }
    
    /**
     * Returns the exits to other locations
     * @return mapExit
     */
    @Override
    public HashMap<String, IExit> getExitToLocation(){
        return mapExit;
    }
    
    /**
     *
     * @param item
     */
    @Override
    public void setItemToLocation(IItem item){
        mapItem.put(item.getItemName(), item);
    }
    
    /**
     *
     * @param item
     */
    @Override
    public void removeItemFromLocation(IItem item){
        mapItem.remove(item.getItemName());
    }
    
    /**
     *
     * @return
     */
    @Override
    public HashMap<String, IItem> getItemToLocation(){
        return mapItem;
    }
    
    public void getItems(HashMap<String, IItem> items){
        int counter = 0;
        for (Entry<String, IItem> entry : mapItem.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            System.out.println(counter + "key, " + key + " value " + value );
        }
    }
    
    
}