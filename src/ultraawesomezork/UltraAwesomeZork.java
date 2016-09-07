package ultraawesomezork;

import Model.DataStore;
import Model.Messages;
import Controller.Command.*;
import Controller.KeyboardInputHandler;
import Model.Map.ILocation;
import Model.Map.Location;
import Model.Character.IPlayer;
import Model.Character.Player;
import Model.Items.Briefcase;
import Model.Items.IItem;
import Model.Items.Key;
import Model.Items.Knife;
import Model.Items.Lantern;
import Model.Items.MagGlass;
import Model.Items.Readable;
import Model.Map.CurrentLocation;
import Model.Map.Exit;
import Model.Map.IExit;
import java.io.IOException;
import java.util.Scanner;


public class UltraAwesomeZork {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        System.out.print(String.format("\033[2J")); //Clears the screen on console
        
        IPlayer player = new Player(); //Set player
        Messages msg = new Messages(); //Set msg for         
        
        //The available locations of the game
        ILocation mainHall = new Location( "Main Hall", "This is main hall's description"); 
        ILocation kitchen = new Location( "Kitchen", "");
        ILocation diningRoom = new Location( "Dining Room", "");
        ILocation livingRoom = new Location( "Living Room", "");
        ILocation library = new Location( "Library", "");
        ILocation secretRoom = new Location( "Dark Room", "a dark room, you cant see anything is this pich black.");
        ILocation hall = new Location( "Hall", "This is hall's description");
        ILocation guestRoom = new Location( "Guest Room", "");
        ILocation richRoom = new Location( "Mr & Ms Richman's Room", "");
        ILocation servantRoom = new Location( "Servant's Room", "");
        ILocation basement = new Location( "Basement", "a dark room, you cant see anything is this pich black."); 
        ILocation leftSecretPassage = new Location( "Left Secret Passage", "You entered a dark plase. Where is this passage heading?");
        ILocation rightSecretPassage = new Location( "Right Secret Passage", "You entered a dark plase. Where is this passage heading?");
        
        //The exits to other locations
        IExit northOfMainHall = new Exit ("north",hall, false);
        IExit westOfMainHall = new Exit ("west",livingRoom, false);
        IExit eastOfMainHall = new Exit ("east",diningRoom, false);
        
        IExit eastOfLivingRoom = new Exit ("east",mainHall, false);
        IExit northOfLivingRoom = new Exit ("north",library, false);
        
        IExit westOfLibrady = new Exit ("west",secretRoom, true);
        IExit southOfLibrady = new Exit ("south",livingRoom, false);
        
        IExit eastOfSecretRoom = new Exit ("east",library, true);
        
        IExit northOfDiningRoom = new Exit ("north",kitchen, false);
        IExit westOfDiningRoom = new Exit ("west",mainHall, false);
        
        IExit northOfKitchen = new Exit ("north",servantRoom, false);
        IExit westOfKitchen = new Exit ("west",hall, false);
        IExit eastOfKitchen = new Exit ("east",basement, true);
        IExit southOfKitchen = new Exit ("south",diningRoom, false);
        
        IExit northOfServantRoom = new Exit ("north",rightSecretPassage, false);
        IExit southOfServantRoom = new Exit ("south",kitchen, false);
        
        IExit westOfRightPassage = new Exit ("west",richRoom, true);
        IExit southOfRightPassage = new Exit ("south",servantRoom, false);
        
        IExit eastOfRichRoom = new Exit ("east",rightSecretPassage, true);
        IExit southOfRichRoom = new Exit ("south",hall, false);
        IExit westOfRichRoom = new Exit ("west",leftSecretPassage, true);
        
        IExit eastOfLeftPassage = new Exit ("east",richRoom, true);
        IExit southOfLeftPassage = new Exit ("south",guestRoom, false);
        
        IExit northOfGuestRoom = new Exit ("north",leftSecretPassage, false);
        IExit eastOfGuestRoom = new Exit ("east",hall, false);
        
        IExit northOfHall = new Exit ("north",richRoom, false);
        IExit westOfHall = new Exit ("west",guestRoom, false);
        IExit eastOfHall = new Exit ("east",kitchen, false);
        IExit southOfHall = new Exit ("south",mainHall, false);
        
        IExit westOfBasement = new Exit ("west",kitchen, true);
        
        basement.setExitToLocation(westOfBasement);

        mainHall.setExitToLocation(northOfMainHall);
        mainHall.setExitToLocation(eastOfMainHall);
        mainHall.setExitToLocation(westOfMainHall);
        
        livingRoom.setExitToLocation(eastOfLivingRoom);
        livingRoom.setExitToLocation(northOfLivingRoom);
        
        library.setExitToLocation(westOfLibrady);
        library.setExitToLocation(southOfLibrady);
        
        secretRoom.setExitToLocation(eastOfSecretRoom);
        
        diningRoom.setExitToLocation(northOfDiningRoom);
        diningRoom.setExitToLocation(westOfDiningRoom);
        
        kitchen.setExitToLocation(northOfKitchen);
        kitchen.setExitToLocation(eastOfKitchen);
        kitchen.setExitToLocation(westOfKitchen);
        kitchen.setExitToLocation(southOfKitchen);
        
        servantRoom.setExitToLocation(northOfServantRoom);
        servantRoom.setExitToLocation(southOfServantRoom);
        
        rightSecretPassage.setExitToLocation(westOfRightPassage);
        rightSecretPassage.setExitToLocation(southOfRightPassage);
        
        leftSecretPassage.setExitToLocation(eastOfLeftPassage);
        leftSecretPassage.setExitToLocation(southOfLeftPassage);
        
        richRoom.setExitToLocation(westOfRichRoom);
        richRoom.setExitToLocation(eastOfRichRoom);
        richRoom.setExitToLocation(southOfRichRoom);
        
        guestRoom.setExitToLocation(northOfGuestRoom);
        guestRoom.setExitToLocation(eastOfGuestRoom);
        
        hall.setExitToLocation(northOfHall);
        hall.setExitToLocation(eastOfHall);
        hall.setExitToLocation(westOfHall);
        hall.setExitToLocation(southOfHall);
        
        //Game's items
        //Keys
        IItem libSecretRoomKey = new Key("strange key","It's a strange key with a label \"PWD 85879-2937663-9675\". Perhaps it opens a secret room or something");
        IItem leftSecretPassageKey = new Key("east secret passage key","It's key to a secret passage, but where?");
        IItem rightSecretPassageKey = new Key("west secret passage key","It's key to a secret passage, but where?");
        IItem basementKey = new Key("basement key","This key has a label \"Basement\" on it.");
        //Usable Items
        IItem magGlass = new MagGlass("magnifying glass","This Item magnifyies.");
        IItem urLetter = new Readable("unreadable letter","Its a letter. Maybe you can see what is inside.") {};
        IItem lantern = new Lantern("lantern","This is an old lanter, can be used to light up a dark place.");
        IItem knife = new Knife("knife","Its a knife, can be used as a weapon too.");
        IItem blackBriefcase = new Briefcase("black briefcase","It's a black briefcase, looks like brand new and as you shake it you notice that the are some items in it.");
        IItem metalBriefcase = new Briefcase("metal briefcase","It's a metal briefcase used usualy to keep something safe.");   
                
        player.setPlayerInventory(lantern);
        player.setPlayerInventory(magGlass);
        player.setPlayerInventory(urLetter);
        
        servantRoom.setItemToLocation(metalBriefcase);
        mainHall.setItemToLocation(blackBriefcase);
        mainHall.setItemToLocation(magGlass);
        richRoom.setItemToLocation(libSecretRoomKey);
        richRoom.setItemToLocation(leftSecretPassageKey);
        richRoom.setItemToLocation(rightSecretPassageKey);
        kitchen.setItemToLocation(basementKey);
        kitchen.setItemToLocation(knife);
        //mainHall.setItemToLocation(GBletter); 
        
        //initialize CurrentLocation
        CurrentLocation currentLocation = new CurrentLocation(mainHall, player);
        DataStore ds = new DataStore(currentLocation);
        
        //The supported commands
        ICommand go = new Go();
        ICommand exit = new ExitGame();
        ICommand help = new Help(player,currentLocation);
        ICommand look = new Look();
        ICommand pick = new Pick();
        ICommand toss = new Toss();
        ICommand examine = new Examine();
        ICommand inventory = new Inventory();
        ICommand use = new Use();

        CommandHandler commandHandler = new CommandHandler();
        
        //register commands
        commandHandler.register(go);
        commandHandler.register(exit);
        commandHandler.register(help);
        commandHandler.register(look);
        commandHandler.register(pick);
        commandHandler.register(toss);
        commandHandler.register(examine);
        commandHandler.register(inventory);
        commandHandler.register(use);
        
        Scanner scan = new Scanner(System.in);
        
        msg.welcomeMessage(); //Wellcome Message
        String playerChoice = scan.nextLine();
        
        boolean game = false;
        
        while (game == false){
            if (playerChoice.equalsIgnoreCase("load")){
                game = true;
                currentLocation = ds.Load(); //loads the last saved game
                currentLocation.showCurrentLocation();
               
            }
            else if (playerChoice.equalsIgnoreCase("new")){
                game = true;
                msg.scenarioDescription();
                Scanner newName = new Scanner(System.in);
                String playerName = newName.nextLine();
                player = new Player(playerName);
                currentLocation.setPlayer(player);
                
                //Senario Description Message
                System.out.printf("Ok "+player.getName() +",\n\n");
                msg.firstLocation();
                currentLocation.showCurrentLocation(); 
                System.out.printf("\n");
                
            }
            else {
                System.out.println("Please type NEW or LOAD!!!");
                playerChoice = scan.nextLine();
            }
        }
          
        //loop for running
        boolean running = true;
        while(running){ 
            msg.nextMoveQ();
            Scanner in = new Scanner(System.in);
            String keyboardInput = in.nextLine();
            
            KeyboardInputHandler input= new KeyboardInputHandler(keyboardInput);
            
            String word1 = input.getCommand().toLowerCase();
            String word2 = input.getObject().toLowerCase();
            commandHandler.handle(word1, word2, currentLocation);
            
            if (keyboardInput.equals("exit")){
                running = false;
            }
            if (keyboardInput.equals("save")){ 
                
                ds.Save();
            }    
            if (keyboardInput.equals("load")){ 
                currentLocation = ds.Load(); //loads the last saved game
                currentLocation.showCurrentLocation();
            }
        }
    }  
}
