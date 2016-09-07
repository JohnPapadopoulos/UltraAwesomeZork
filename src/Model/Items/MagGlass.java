/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Items;

import Model.Map.CurrentLocation;
import Model.Messages;
import java.io.Serializable;
import java.util.Scanner;

public class MagGlass implements IItem, Serializable{
    private String itemName;
    private String itemDescription;
    private Messages msg = new Messages();
    
    public MagGlass(String name, String description){

        this.itemName = name;
        this.itemDescription = description;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public String getItemDescription() {
        return itemDescription;
    }

    @Override
    public void setItemDescription(String desrc) {
        this.itemDescription = desrc;
    }

    @Override
    public void setItemName(String name) {
        this.itemName = name;
    }
    
    @Override
    public void itemAction (CurrentLocation currentLocation, String word){
        
        System.out.printf(" -On what you want to use the Magnigying Glass?: ");
        Scanner cn = new Scanner(System.in);
        String itemName = cn.nextLine();
        IItem item2 = currentLocation.getPlayer().getPlayerInventory().get(itemName);

        //Items that can be used by magnifying glass
        if(item2.getItemName().equals("unreadable letter")){
            item2.setItemDescription("The letter says: \t\nThe butler tried multiple times to kill Ms Richman and if someone find this letter then certainly he succeeded. \t\nSo here comes the phrase \"The Butler did it\"\n" );
            item2.setItemName("readable letter");
            System.out.printf(" -Finaly you can red the letter and its amazing what is written in it. \n"+ item2.getItemDescription());
        }
        else if (!currentLocation.getPlayer().getPlayerInventory().containsValue(word)) {
            msg.notInInventory();
        }
    }
}



