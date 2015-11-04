/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr7app;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivan
 */
public class Pr7app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            
            // TODO code application logic here
            
            System.out.println("Hola profes!");
            
            //download
            try {
                URL url = new URL("http://192.168.122.200/docs/ic10-m04-WindowsServer.pdf");
                url.openConnection();
                InputStream reader = url.openStream();
                FileOutputStream writer = new FileOutputStream("/Users/sean/NetBeansProjects/pr7/src/pr7app/resource/sebastian.pdf");
                byte[] buffer = new byte[153600];
                int bytesRead = 0;
                while ((bytesRead = reader.read(buffer)) > 0) {
                    writer.write(buffer, 0, bytesRead);
                    // buffer = new byte[153600];
                }
                writer.close();
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(Pr7app.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Nadie");
            }
            
         try {
           
            FTPClient cliente = new FTPClient();
            cliente.connect("srv.toca.cat",21);
            cliente.login("fulano", "Platano123");
            cliente.upload(new java.io.File("/Users/sean/NetBeansProjects/pr7/src/pr7app/resource/sebastian.pdf"));
            cliente.disconnect(true);
         }catch (FTPAbortedException | FTPDataTransferException | FTPException | FTPIllegalReplyException | IOException | IllegalStateException ex) {
               System.err.println("Nadie2");
             Logger.getLogger(Pr7app.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

}
