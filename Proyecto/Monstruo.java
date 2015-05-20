import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.LinkedList;
/**Clase Monstruo permite crear objetos de tipo monstruo usados en el juegoForest.*/

// m      Contiene los disfraces del objeto.
// banInsercion    Variable que controla que los objetos no sean incertados mas de una vez.
// seg    Contiene una referencia de tiempo la cual maraca la transicion de disfraces asi como el movimiento del objeto.
// seg2   Contiene una referencia de tiempo la cual maraca el choque con un objeto.
// disfraz      Variable que indica el difraz usado en el momento.
// choque Contiene el sonido de choque.

public class Monstruo extends Objeto
{
    private LinkedList<GreenfootImage> mounstro;
    private boolean banInsercion;
    private long seg;
    private long seg2;
    private int disfraz;
    private GreenfootSound choque;
    /**Constructor de la clase Monstruo inicializa todas las variables. */
    public Monstruo(int X, int Y)
    {
        super(X,Y);
        mounstro= new  LinkedList<GreenfootImage>();
        choque=new GreenfootSound("pierdeForest.WAV");
        banInsercion=false;
        seg=System.currentTimeMillis();
        seg2=System.currentTimeMillis();
        disfraz=0;
    } 

    /**Metodo act de la clase, aqui se verifican las coliciones y se realiza el movimiento del objeto, ademas de actualizar las vanderas de puntos y daño.*/
    public void act() 
    {
        if(banInsercion==false){
            mounstro.add(new GreenfootImage("ojo.png"));
            mounstro.add(new GreenfootImage("ojo1.png"));
            banInsercion=true;
        }
        if(getOneIntersectingObject(Sombra.class)!=null ){
            ((Inicio)getWorld()).IncPun();    
            getWorld().removeObject(this); 
            return;     
        }
        if(getOneIntersectingObject(Mono.class)!=null ){
            if( System.currentTimeMillis()- seg2   >= 800){
                choque.play();
                ((Inicio)getWorld()).tropesar();
                seg2= System.currentTimeMillis();
                getWorld().removeObject(this); 

            }
        }
        if(System.currentTimeMillis()-seg>300){
            seg=System.currentTimeMillis();
            if(disfraz==1)
                disfraz=0;
            else
                disfraz++;
            x-=50;
        }
        mounstro.get(disfraz).scale(30,30);
        setImage(mounstro.get(disfraz));
        setLocation(x,y);
    }    
}
