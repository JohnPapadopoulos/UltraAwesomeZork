package Model.Items;

import Model.Map.CurrentLocation;
import java.io.Serializable;
import static java.lang.System.out;


public class Lantern implements IItem, Serializable{
    private String itemName;
    private String itemDescription;
    
    public Lantern(String name, String description){
        this.itemName = name;
        this.itemDescription = description;
    }

    @Override
    public String getItemName(){
        return itemName; 
    }
    
    @Override
    public String getItemDescription(){
        return itemDescription;
    }
    
    @Override
    public void setItemDescription(String desrc){
        this.itemDescription = desrc;
    }
    
    @Override
    public void setItemName(String name){
        this.itemName = name;
    }
    
    @Override
    public void itemAction (CurrentLocation currentLocation, String word){
        switch (currentLocation.getCurrentLocation().getLocationName()) {
            case "Basement":
                out.printf("You succesfully lit the lantern...\n");
                currentLocation.getCurrentLocation().setLocationDescr("The room is full of light and now you can see clearly.");
                out.printf(currentLocation.getCurrentLocation().getLocationDescr() + "\n");
                break;
            case "Dark Room":
                System.out.printf("You try to light up the old lantern.\nNow you can see clearly what's inside this room.");
                currentLocation.getCurrentLocation().setLocationName("Library's Secret Room");
                currentLocation.getCurrentLocation().setLocationDescr("It's a secret room, all can see here is abunch if old "
                        + "( probably very \nrare and expencive ) paintings and statues.");
                System.out.printf(currentLocation.getCurrentLocation().getLocationDescr());
                break;
            case "Left Secret Passage":
                System.out.printf("You try to light up the old lantern\nNow you can see clearly what's inside this room.");
                currentLocation.getCurrentLocation().setLocationDescr("Now the room is full of light.\n You can see clearly "
                        + "that this passage leads from Mr and Ms Richman's room to the guest room. But why?");
                System.out.printf(currentLocation.getCurrentLocation().getLocationDescr());
                break;
            case "Right Secret Passage":
                System.out.printf("You try to light up the old lantern\nNow you can see clearly what's inside this room.");
                currentLocation.getCurrentLocation().setLocationDescr("Now the room is full of light.\n You can see clearly "
                        + "that this passage leads from Mr and Ms Richman's room to the servant's room. But why?");
                System.out.printf(currentLocation.getCurrentLocation().getLocationDescr());
                break;
            default:
                out.print("You lit the lantern, but nothing happened...\n");
                break;
        }
    }
    
}
