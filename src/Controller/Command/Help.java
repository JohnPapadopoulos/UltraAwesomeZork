package Controller.Command;

import Model.Map.CurrentLocation;
import Model.Messages;
import Model.Character.IPlayer;

/**
 *
 * @author Giannis
 */
public class Help implements ICommand {
    
    private Messages msg = new Messages();
    private IPlayer player;
    private String command;
    private String helpMsg = "";
    private CurrentLocation currentLocation;
    
    
    public Help(IPlayer player, CurrentLocation currentLocation){
        this.player = player;
        this.currentLocation = currentLocation;
        command = "help";
    }

    
    @Override
    public String getCommand(){
        return command;
    }
    
    @Override
    public void action (CurrentLocation currentLocation, String word){
        helpMsg = "\n" + currentLocation.getPlayer().getName() + ", you are in " + currentLocation.getCurrentLocation().getLocationName() + ".\n" + currentLocation.getCurrentLocation().getLocationDescr();
        System.out.println(helpMsg);
        msg.availableCommands();
    }
}
