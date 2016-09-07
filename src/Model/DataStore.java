package Model;

import Model.Map.CurrentLocation;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giannis
 */
public class DataStore {
    private CurrentLocation currentLocation;
    String fileName = "data.bin";
    
    public DataStore ( CurrentLocation currentLocation){
        this.currentLocation = currentLocation;
    }
    
    public void Save(){
        try {
            ObjectOutputStream os = new ObjectOutputStream( new FileOutputStream(fileName));
            os.writeObject(currentLocation);
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(DataStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("DONE SAVING TO FILE!\n");
    }
    
    public CurrentLocation Load() throws IOException, ClassNotFoundException{
        
        try {
            ObjectInputStream is = new ObjectInputStream( new FileInputStream(fileName));
            this.currentLocation = (CurrentLocation) is.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("LOADED SUCCESFULLY!\n");
        return currentLocation;
        
    }
}
