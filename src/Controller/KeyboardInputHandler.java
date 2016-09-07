/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Giannis
 */
public class KeyboardInputHandler {
    
    private String input;
    private String words[];
    private String command;
    private String obj;
    
    public KeyboardInputHandler(String keyboardInput){
        
        this.input = keyboardInput;
        words = input.split(" ", 2);
        command = words[0].trim();
        
        if (words.length<2){
            obj = "none";
        }
        else {
            obj = words[1].trim();
        }
    }
    
    public String getCommand(){
        return command;
    }
    
    public String getObject(){
        return obj;
    }
    
}
