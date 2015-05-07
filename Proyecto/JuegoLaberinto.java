import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Esta clase crea un juego de tipo laberinto y anade al mundo lo necesario.
 * @param b Etiqueta que da instrucciones iniciales.
 * @param rata variable tipo GreenfootSound que reproduce el sonido de un raton.
 * @param ban bandera que permite anadir al mundo los elementos un a sola vez.
 * @param tipo Tipo de boton que se ha presionado.
 * @param perder variable que indica cuando se ha perdido.
 * @ param bara obstaculo del escenario.
 * @param pared paredes del laberinto.
 * @param picos obstaculo del escenario.
 * @param inicia variable que indica que el juego a iniciado.
 * @param seg variable que permite contar en milisegundos.
 * @param gana variable que indica que ha ganado.
 * 
 */
public class JuegoLaberinto extends Juego
{
    private  Label b;
    private int nivel;
    private  GreenfootSound rata;     
    private  int ban;
    private int ban2;
    private Ratonera ratonera;
    private int tipo;
    private int perder;
    private BaraFuego bara;
    private Pared pared;
    private Picos picos;
    private int inicia;
    private long seg;
    private long segVida;
    private int gana;
    private int banMuere;
    private Quesito queso;
    private int puntos;
    private int ganar;
    /**
     * Constructor de la clase, se inicializan las variables usadas y se utiliza el constructor de la superclase
     * para inicializar algunas de estas .
     */ 
    public JuegoLaberinto()
    {
        super(new Pantalla("Laberinto"),new Jugador(50,50,100),new Mira(0,0,3 ));
        menu.add(new Boton(580,450,2));
        picos=new Picos();
        nivel=1;
        banMuere=0;
        puntos=0;
        b=new Label("inicia en la zona azul y llega a la cueva",40);        
        ban=0;
        ban2=0;
        seg=System.currentTimeMillis();
        segVida=System.currentTimeMillis();
        rata= new GreenfootSound("rata.mp3");
        perder=0;
        bara=new BaraFuego();
        inicia=0;
        gana=0;
        ganar=0;
    }

    /**
     * Metodo act, aqui se genera todo el ambiente, se reproducen  sonidos y los obstaculos tieen movimiento,
     * tambien se anaden los elementos una sola vez.
     */
    public void act() 
    {
        if(ban==0){

            getWorld().addObject(j,0,0);
            getWorld().addObject(p,0,0);
            getWorld().addObject(m,0,0);
            /*for(Boton b : menu){
            getWorld().addObject(b,0,0);
            }*/
            ban=1;
            if(nivel==1){
                creaLaberinto();  
                getWorld().addObject(b,320,220);
                getWorld().addObject(bara,560,75);
                getWorld().addObject(picos,300,371);
            }
        }
        if(  System.currentTimeMillis()- seg   >= 4000){    
            rata.play();
            seg=System.currentTimeMillis();
        }

        if(m.getX()<640&&m.getX()>540 &&m.getY()>0 &&m.getY()<80 && inicia==1){
            gana=1;        

        }

        if(m.getX()<120&&m.getX()>58 &&m.getY()>420 &&m.getY()<480 && inicia==0){
            inicia=1;           
            this.ponQueso();
            getWorld().removeObject(b);
            if(nivel==2)
            this.ponRatoneras();

        }
        if(gana==0){
            if(m.getBan()== 1){
                for(Boton b: menu)

                    if(b.getTipo()!=0)
                        tipo=b.getTipo(); 
            }
        }
        else{if(ban2==0){ 

                getWorld().removeObjects(getWorld().getObjects(Quesito.class));
                getWorld().removeObjects(getWorld().getObjects(Pared.class));
                inicia=0;
                ban2=1;
                nivel=2;              
                getWorld().removeObject(picos);
                getWorld().removeObject(bara);
                getWorld().removeObject(b);
                puntos=j.getPuntos();
                super.nuevoNivel(new Pantalla("lab2"),new Mira(0,0,3 ));           
                getWorld().addObject(p,getWorld().getWidth() / 2,getWorld().getHeight()/2);
                getWorld().addObject(m,10,10);                
                b=new Label("inicia en la zona azul y llega al queso",40);      
                getWorld().addObject(b,320,220);          
                
                this.ponQueso();

            }
        }
        if(inicia==1){
            
            if(m.ratonMuere()==1){        
                System.out.println(perder);
                banMuere=1;
                //segVida=System.currentTimeMillis();

            }
        }
        perder=j.muerto();        
        if(  System.currentTimeMillis()- segVida   >= 500 && banMuere==1){    
            banMuere=0;          
            j.daña();
            segVida=System.currentTimeMillis();
        }
        banMuere=0;

    }

    /**
     * Metodo botonP, este metodo permite saber el boton que se ha presionado en este juego
     * @return tipo Tipo de boton presionado.
     */
    public int botonP(){
        return tipo;
    }

    /**
     * Metodo incPun, incrementa los puntos del jugador en una cantidad indicada.
     */ 
    public void IncPun(){
        j.IncPuntos(10);
    }

    /**
     * Metodo perder, en este metodo se regresa la variable que indica si se ha perdido.
     * @return perder variable que indica cuando se ha perdido el juego.
     */
    public int perder()
    {
        return perder;
    }

    /**
     * Metodo creaLaberinto, este metodo crea las paredes del laberinto con lineas muy delgadas, solo se usa una variable
     * que es pared para crear todo el laberinto.
     */
    public void creaLaberinto(){

        //paredes del laberinto//      
        pared=new Pared(2,400); 
        getWorld().addObject(pared,56,280); 

        pared=new Pared(2,370);
        getWorld().addObject(pared,118,290);

        pared=new Pared(1,300);
        getWorld().addObject(pared,207,69);

        pared=new Pared(1,200);
        getWorld().addObject(pared,218,104);

        pared=new Pared(2,70);
        getWorld().addObject(pared,356,120);

        pared=new Pared(2,250);
        getWorld().addObject(pared,235,268);

        pared=new Pared(2,150);
        getWorld().addObject(pared,365,405);

        pared=new Pared(1,200);
        getWorld().addObject(pared,463,330);

        pared=new Pared(2,150);
        getWorld().addObject(pared,430,255);

        pared=new Pared(2,70);
        getWorld().addObject(pared,355,36);

    }

    /**
     * Metodo getPicos este metodo indica cuando los picos pueden causar daño.
     * @return picoS  variable que indica cuando los picos estan por fuera y pueden causar daño.
     */
    public int getPicos(){
        return picos.getPicos();
    }
    /**Metodo ponQueso inserta los quesos en el mundo en cierta posicion.*/
    private void ponQueso(){
        if(nivel==1){ queso= new Quesito();
            getWorld().addObject(queso,88,129);
            queso= new Quesito();
            getWorld().addObject(queso,412,379);
            queso= new Quesito();
            getWorld().addObject(queso,412,453);
            queso= new Quesito();
            getWorld().addObject(queso,512,15);}
        else
        {   queso= new Quesito();
            getWorld().addObject(queso,32,229);
            queso= new Quesito();
            getWorld().addObject(queso,174,118);
            queso= new Quesito();
            getWorld().addObject(queso,180,64);
            queso= new Quesito();
            getWorld().addObject(queso,238,64);
            queso= new Quesito();
            getWorld().addObject(queso,296,64);
            queso= new Quesito();
            getWorld().addObject(queso,346,64);
        }

    }
    
    /**Metodo ponRatoneras, dependiendo el nivel inserta las ratoneras en el mundo en un lugar especifico.*/
    private void ponRatoneras(){
        ratonera= new Ratonera(1);
        getWorld().addObject(ratonera,138,448);
        ratonera= new Ratonera(1);
        getWorld().addObject(ratonera,138,361);
        ratonera= new Ratonera(2);
        getWorld().addObject(ratonera,28,345);
        ratonera= new Ratonera(1);
        getWorld().addObject(ratonera,78,228);
        ratonera= new Ratonera(2);
        getWorld().addObject(ratonera,45,164);
        ratonera= new Ratonera(1);
        getWorld().addObject(ratonera,125,88);
        ratonera= new Ratonera(2);
        getWorld().addObject(ratonera,240,115);
        ratonera= new Ratonera(2);
        getWorld().addObject(ratonera,325,115);
        ratonera= new Ratonera(1);
        getWorld().addObject(ratonera,337,222);
        ratonera= new Ratonera(2);
        getWorld().addObject(ratonera,331,454);
        ratonera= new Ratonera(2);
        getWorld().addObject(ratonera,402,52);
    }

    /**
     * Metodo que permite obtener los puntos del jugador.
     * @return getpuntos puntos obtenidos por el jugador.
     */
    public int getPuntos()
    {
        return j.getPuntos();
    }
    
    /**Este metodo retorna el valor de la variable ganar que indica si se a completado el juego.
       @return ganar 0 si no se ha ganado, 1 si se gano.
    */
    public int ganar()
    {
        return ganar;
    }
}
