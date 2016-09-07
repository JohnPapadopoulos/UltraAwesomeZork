package Model;

import java.io.Serializable;

public class Messages implements Serializable {
    
    private String msg = "";
    
    public void Message(){  
    }
    
    /**
     * Line separator 
    */    
    public void lineSeparator(){
        msg = "--------------------------------------------------\n\n";
        System.out.printf(msg);
    }
    
    /**
    * Welcome message 
    */
    public void welcomeMessage(){
        msg =   "\tHello,\n"
                + "and welcome to the Ultra Awesome Zork.\n"
                + "--------------------------------------------------\n\n"
                + "Please type NEW to start a new game or LOAD to load the last one saved! : ";
        System.out.printf(msg);
    }
    
    /*
    * Senario description message
    */
    public void scenarioDescription(){
        msg =  "In this game, you will play a role of the detective,\n"
               +"who will try and solve a murder of a Adolf Richman's wife.\n"
               +"\nBut first things first, what is your name? \n";
        System.out.printf(msg);
    }
    
    public void firstLocation(){
        msg = "So, your adventure starts here: you are in the ";
        System.out.println(msg);
    }
    
    /*
    * Help message 
    */
    public void availableCommands(){
        
        msg = "\nYour available commands are: \n"
              +"\tNavigation Commands\n"
              +"\"go\tnorth\"\tto move your character north.\n"
              +"\"go\tsouth\"\tto move your character south.\n"
              +"\"go\teast\"\tto move your character east.\n"
              +"\"go\twest\"\tto move your character west.\n"
              +"\tItem Managment Commands\n"
              +"\"inventory\"\tto see what's in your inventory.\n"
              +"\"look\"\t\tto look for items in the room.\n"
              +"\"pick\"\t\tto pick an item from the room you are.\n"
              +"\"toss\"\t\tto drop an item to the room you are.\n"
              +"\"examine\"\tto see what the item does.\n"
              +"\tGeneral Commands\n"
              +"\"exit\"\t\tto exit the game.\n"
              +"\"help\"\t\tto show you a list of availble commands.\n";
        System.out.printf(msg);
    }
    
    /*
    * Print the next move question on screen
    */
    public void nextMoveQ(){
        msg = "What you wanna do?\n";
        System.out.printf(msg);
    } 
    
    /*
    * Print the next move question on screen
    */
    public void noDirection(){
        msg = "Uh! There is nothing in that location.";
        System.out.printf(msg);
    }
     
    /*
    * Print the next move question on screen
    */
    public void wrongDirection(){
        msg = "You can go north, south, east and west! Please try again!";
        System.out.printf(msg);
    }
    
    public void emptyInventory(){
        msg = "Your inventory is empty!/n/n";
        System.out.printf(msg);
    }
    
    public void notInInventory(){
        msg = "There's no such in your invertory.\n\n";
        System.out.printf(msg);
    }
}