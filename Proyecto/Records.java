import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.io.IOException;
import java.io.*;
/**
 * esta clase crea un archivo de texto si es que no existe con records del juego.
 * si existen ya los lee, tambien los sobreescribira.
 */
public class Records  
{
    private File file;
    private FileWriter escritor;
    private BufferedWriter bufer;
    private PrintWriter salida;

    /**
     * inicializa las variables nesesarias
     */
    public Records()
    {file= new File ("rec.txt");
     if(!file.exists()){
         try{
             file.createNewFile();
            }catch(IOException ex){}
        }
        
    
    
    }
    
    public void escribeRecords(String nom, int punt){
        // put your code here
       
    }
}
