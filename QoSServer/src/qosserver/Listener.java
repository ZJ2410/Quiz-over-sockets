package qosserver;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ZSJ
 */
public class Listener extends Thread{
    
    int port;
    File file;
    ServerSocket server;
    Socket[] client = new Socket[500];
    int i=0;
    public Listener(int port, File file) throws IOException{
        this.port = port;
        this.file = file;
        server = new ServerSocket(port);
    }
    public void socketclose(){
        try {
            for( int ii=0; ii<i; ii++ ){
                client[ii].close();
            }
            server.close();
            i=0;
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
    }
    @Override
    public void run(){
        while(true){
            try {
                client[i] = server.accept();
                QuizService qs = new QuizService(client[i], file, i);
                qs.start();
                i++;
            } catch (IOException ex) {
                Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
