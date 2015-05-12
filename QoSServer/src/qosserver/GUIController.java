package qosserver;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUIController {
    Listener listener;
    public void loginWindow(){
        LoginWindow login = new LoginWindow();
        login.setVisible(true);
        
    }
    
    public void ConnectWindow() {
        ConnectWindow cw = new ConnectWindow();
        cw.setVisible(true);
    }
    
    public void connect(int port, File file){
        try {
            listener = new Listener(port, file);
            listener.start();
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void socketClose(){
        listener.socketclose();
    }
    
    
    
}
