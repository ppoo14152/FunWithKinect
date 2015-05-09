import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
Clase Balon nos permite crear un objeto de tipo Balon el cual es usado en juegoGool.
 */
// balon  Contiene la imagen del objeto.
// patada Contiene el sonido de patada, el cual se reproduce cuando se patea el balon.
// parado Contiene el sonido de parado, el cual se reproduce si el portero intercepta el balon.
// gool   Contiene el sonido de gool, el cual se reproduce si se anota un gool.
// seg    Variable que contiene una referencia de tiempo, se usa para marcar el tiempo en que el balon 
//        realiza sus acciones y movimientos.
// v      Variable que contiene la velocidad en que se mueve el balon;
// x1     Variable usada para manipular la direccion del balon, almacena la coordenada en x de nuestra 
//        mano derecha.
// y1     Variable usada para manipular la direccion del balon, almacena la coordenada en x de nuestra 
//        mano derecha.
//disparo Bandera que nos indica si el balon fue pateado.
// ban    Bandera que no permite que los objetos se incerten mas de una vez.
// act    Variable usada para detectar las coliciones que tiene el balon.

public class Balon extends Objeto
{

    private GreenfootImage balon;
    private GreenfootSound patada;
    private GreenfootSound parado;
    private GreenfootSound gool;   
    private long seg;
    private int v;
    private int x1;
    private int y1;
    private int disparo;
    private int ban;
    private Actor act;

    /**
    Constructor de la clase Balon aqui se inicializan las variable y se realiza el metodo super para inicializar
    las variable x y y heredadas de la superclase.
    @param X coordenada en el eje x en que se quiere comience el objeto.
    @param Y coordenada en el eje y en que se quiere comience el objeto.
    @param velocidad en que se quiere se mueva el objeto.
     */
    public Balon(int X, int Y, int velocidad)
    {
        super(X,Y);
        v=velocidad;
        ban=0;
        Greenfoot.playSound("silbato.mp3");
        balon=new GreenfootImage("balon.png");
        patada=new GreenfootSound("patada.mp3");
        parado=new GreenfootSound("BOO.WAV");
        gool=new GreenfootSound("gool.WAV");
        seg=System.currentTimeMillis();
        balon.scale(50,50);
        disparo=0;

    }

    /**Metodo act del objeto aqui se detecta si el jugador pateo el balon y genera el movimiento del mismo, ademas 
    verificar y alterar la direccion del mismo detectando el movimiento de nuestra mano derecha*/
    public void act() 
    {
        if(System.currentTimeMillis()-seg>10){
            seg=System.currentTimeMillis();
            if(disparo==1){

                act=getOneIntersectingObject(Porteria.class);
                if(y<255 ){
                    if(act!=null )
                        ((Inicio)getWorld()).IncPun();
                    x=340;
                    y=420;
                    disparo=0;
                    gool.play();
                }
                else{
                    act=getOneIntersectingObject(Portero.class);
                    if(act!=null){              
                        disparo=0;
                        parado.play();
                        x=340;
                        y=420;
                    }
                    else
                    if(x>x1)
                        x--;
                    else if( x!=x1)
                        x++;

                    y--;
                }
            }
        }
        setLocation(x,y);
        setImage(balon);
    }

    /** Metodo patada actualiza la bandera de disparo y reproduce el sonido de patada */
    public void patada()
    {
        disparo=1;   
        patada.play();
    }

    /** Metodo setDireccion permite actualizar las variables x1 Y y1 las cuales establecen la direccion del balon en el metodo act.
    @param direccionX coordenada x de la mano derecha.
    @param direccionY coordenada y de la mano derecha.
     */
    public void setDireccion(int direccionX, int direccionY)
    {
        x1=direccionX;
        y1=direccionY;
    }
}