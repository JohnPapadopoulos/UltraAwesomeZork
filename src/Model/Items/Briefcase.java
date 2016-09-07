package Model.Items;

import Model.Map.CurrentLocation;
import java.io.Serializable;
import static java.lang.System.out;


public class Briefcase implements IItem, Serializable{
    private String itemName;
    private String itemDescription;
    
    public Briefcase(String name, String description){
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
        
        if (currentLocation.getPlayer().getPlayerInventory().containsKey(word)){
            switch (word) {
                case "black briefcase":
                    IItem item1 = new Readable("closed letter","This letter is still closed. Maybe you have to open it to see what is inside.");
                    IItem item3 = new Readable("post note","Its a simple post note. its seems to be folded in half.");
                    IItem item2 = new Key ("key to guest room","This key got a label that says \"To Guest Room\"");
                    out.print(" -You opened the black briefcase. Inside it you can see a letters and an odd key.\n");
                    currentLocation.getCurrentLocation().setItemToLocation(item1);
                    currentLocation.getCurrentLocation().setItemToLocation(item2);
                    currentLocation.getCurrentLocation().setItemToLocation(item3);
                    currentLocation.getPlayer().getPlayerInventory().remove(word);
                    out.print(" -Black briefcase has been removed from your inventory.\n");
                    out.print(" -" + item1.getItemName() + ", " +item2.getItemName() + " and " +item3.getItemName() + " are now on the table.\n");
                    break;
                case "metal briefcase":
                    if (currentLocation.getPlayer().getPlayerInventory().containsKey("post note") 
                            && currentLocation.getPlayer().getPlayerInventory().get("post note").getItemDescription().contains("\"PWD")){

                        IItem item4 = new Readable ("shreded letter","Its a shreded piece of paper, but it seems like all the pieces are here and you can easily combine them.");
                        IItem item5 = new Key ("east secret passage key","Its a key with a lable \"Master's\" on it.");
                        out.print(" -You used the password on the post note you found to opened the black briefcase. \n"
                                + "Inside you can see a shreded letter and a key with a lable \"Master's\" on it. \n"
                                + "On the bottom of the briefcase you see a lot of money. I dont think a servant can make all of these.\n ");
                        currentLocation.getCurrentLocation().setItemToLocation(item4);
                        currentLocation.getCurrentLocation().setItemToLocation(item5);
                        currentLocation.getPlayer().getPlayerInventory().remove(word);
                        out.print("-Black briefcase has been removed from your inventory.\n");
                        out.print(" -" + item4.getItemName() + " and " +item5.getItemName() + " are now on the table.\n");
                        
                    }
                    else{
                        out.print(" -This briefcase is password protected from opening. You have to find the password 1st.\n");
                    }   break;
            }
        }
        else{
            out.print(" -This briefcase cannot be opened!\n");
        }
    }
}
    
