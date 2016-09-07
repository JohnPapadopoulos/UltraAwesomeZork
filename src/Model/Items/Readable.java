package Model.Items;

import Model.Map.CurrentLocation;
import java.io.Serializable;
import static java.lang.System.out;

public class Readable implements IItem, Serializable{

    private String itemName;
    private String itemDescription;
    
    public Readable(String name, String description){
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
    public void itemAction(CurrentLocation currentLocation, String word) {
        if (currentLocation.getPlayer().getPlayerInventory().containsKey(word)){
            IItem item1 = currentLocation.getPlayer().getPlayerInventory().get(word);
            switch (item1.getItemName()) {
                case "post note":
                    IItem item3 = currentLocation.getPlayer().getPlayerInventory().get(word);
                    item3.setItemDescription("Its a simple post note. On it is written some strange numbers \"PWD 85879-2937663-9675\"");
                    out.print(" -You unfolded the post note and it revealed some strange numbers try to examine it.\n");
                    break;
                case "shreded letter":
                    IItem item2 = currentLocation.getPlayer().getPlayerInventory().get(word);
                    item2.setItemName("combined letter");
                    item2.setItemDescription("Its a contract letter that says \"The money that we agreed are in the metal briefcase. You must do it TODAY! Finish it OR!...\"");
                    out.print(" -You carefulle combined all the pieces together and you can see what was written in it.\n -The letter says:\n");
                    currentLocation.getPlayer().getPlayerInventory().remove(word);
                    currentLocation.getPlayer().setPlayerInventory(item1);
                    out.print(" -" +item2.getItemDescription());
                    out.print(" -" +item2.getItemName()+ " has been added to your invrntory./n");
                    break;
                default:
                    out.print(" -Its a simple letter. Maybe you should try to examine it...");
                    break;
            }
        }
        
    }
    
}
