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
        FileWriter escritor;
        BufferedWriter bw;
        PrintWriter s;
        try{
            escritor= new FileWriter(file);
            bw= new BufferedWriter(escritor);
            s = new PrintWriter(bw);

            s.write("nombre"+ nom+"             " +     punt+"\n");
            s.close();
            bw.close();
        }catch(IOException e){}

    }

    public String leeRecords(){
       
            String texto = "";
            FileReader lector=null;
            String linea = "";
            try {
                lector = new FileReader(file);
                BufferedReader bl = new BufferedReader(lector);
                while ((linea = bl.readLine()) != null) {
                    texto += linea + "\n";
                }                
            } catch (IOException e) {
              
            } finally {
                if (lector != null) {
                    try {
                        lector.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return texto;
        }

    }

