import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**Clase Obstaculo, permite crear un objeto Obstaculo usado en juegoForest.*/

// obstaculo Variable que contiene la imagen del objeto.
// choque    Variable que contiene el sonido choque, el cual se reproduce si ocurre una colicion con un objeto Mono.
// seg       Variable que contiene una referencia de tiempo la cual marca las transiciones en el desplazamiento del objeto.
// seg2      Variable que contiene una referencia de tiempo la cual marca la revicion de coliciones.
// v         Variable que indica la velocidad del objeto

public class Obstaculo extends Objeto
{
    private GreenfootImage obstaculo;
    private GreenfootSound choque;
    private long seg;
    private long seg2;
    private int v;

    /** Constructor de la clase, aqui se inicializan todas las variables.
    @param X contiene la posicion en el eje x en donde aparecera el objeto.
    @param Y contiene la posicion en el eje y en donde aparecera el objeto.
    @param objeto cadena que contiene el nombre del Obstaculo que se quiere crear.
    @param velocidad Indica la velocidad a la que se desplazara el objeto.
     */
    public Obstaculo(int X, int Y, String objeto, int velocidad)
    {
        super(X,Y);
        v=velocidad;
        choque=new GreenfootSound("pierdeForest.WAV");
        obstaculo=new  GreenfootImage(objeto+".png");
        seg=System.currentTimeMillis();
        seg2=System.currentTimeMillis();
        obstaculo.scale(30,50);

    }

    /**Metodo act de la clase, se muestra el objeto en la pantalla asi como su desplazamiento por la misma, tambien realiza el 
     * incremento de puntos y daño al jugador.
     */
    public void act() 
    {
        if( System.currentTimeMillis()-seg >50){
            x-=v;
            setLocation(x,y);
            seg=System.currentTimeMillis();}
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

        setImage(obstaculo);
    }    
}
