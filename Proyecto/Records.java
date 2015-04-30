import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.LinkedList;
import java.io.*;
/**
 * esta clase crea un archivo de texto si es que no existe con records del juego.
 * si existen ya los lee, tambien los sobreescribira.
 */
public class Records extends Actor  
{
    private File file;
    private FileWriter escritor;
    private BufferedWriter bufer;
    private PrintWriter salida;
   private LinkedList<Usuario> records;
    /**
     * inicializa las variables nesesarias
     */
    public Records()
    {
        records=new LinkedList<Usuario>();
        file= new File ("rec.txt");
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException ex){}
        }
        else 
        this.leeRecords();
        

    }
    public void escribeRecords(){
        PrintWriter escritor;
        String num;
        BufferedWriter bw;
        PrintWriter s;
        try{
            escritor= new PrintWriter(file);
            bw= new BufferedWriter(escritor);
            s = new PrintWriter(bw);
            for(Usuario i : records)
            {
             s.println(i.getNombre());
             s.println(i.getPuntos()+"");
            }
            s.close();
            bw.close();
        }catch(IOException e){}

    }

    public void leeRecords(){
            Usuario usuario= new Usuario();
            String nombre="";
            int puntos=0;
            String texto = "";
            FileReader lector=null;
            String linea = "";
            try {
                lector = new FileReader(file);
                BufferedReader bl = new BufferedReader(lector);
                while ((linea = bl.readLine()) != null) {
                    texto=linea;
                    usuario.setNombre(texto);
                    if((linea = bl.readLine()) != null){
                    texto=linea;
                    puntos = Integer.parseInt(texto);
                    usuario.setPuntos(puntos);
                }
                records.add(usuario);
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
         
         }
    public void addUsuario(Usuario us)
        {
          
            records.add(us);
            this.escribeRecords();
        
        }
    public LinkedList<Usuario> creaTablaRecords()
    {
      return records;
    }
   
    }

