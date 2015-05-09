import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Esta clase permite generar un nuevo juego de guerra en el cual se anadiran sus elementos.
 */
// menu lista de botones que estan en el mundo.
// arma arma del jugador tiene balas y granadas.
// ban variable que permite anadir al mundo los elementos solo una vez.
// tipo tipo de boton preisonado.
// perder variable que indica que ha perdido.
// seg variable que permite contar el tiempo en milisegundos.
// seg1 variable que permite contar el tiempo en milisegundos segundo contador.
// seg2 variable que permite contar el tiempo en milisegundos tercer contador.
// banA variable que permite detectar coliciones entre los elementos del juego.
public class JuegoGuerra extends Juego
{
    private LinkedList<Boton> menu;
    private int tiempo;
    private int n;
    private int c;
    private Arma arma;        
    private boolean ban; 
    private int conEnem;
    private int tipo;   
    private long seg, seg1,seg2,seg3,seg4;
    private Actor banA;
    private Label b;
    private int cantEnem;
    /**
     * Constructor de la clase inicializa las variables que se usan tambien inicializa algunas en el constructor de la
     * superclase.
     */
    public JuegoGuerra(){
        super(new Pantalla("guerra"),new Jugador(50,50,100),new Mira(0,0,2));
        arma= new Arma(50,50);
        conEnem=0;
        menu=new LinkedList<Boton>(); 
        menu.add(new Boton(580,450,2));
        ban=false;
        c=0;
        tipo=0;   
        n=1;
        cantEnem=1;
        tiempo=10;       
        seg=System.currentTimeMillis();
        seg1=System.currentTimeMillis();
        seg2=System.currentTimeMillis();
        seg3=System.currentTimeMillis();
        seg4=System.currentTimeMillis();
    }

    /**
     * metodo act, anade al mundo los elementos una sola vez y algunos otros cada cierto tiempo
     */
    public void act() 
    {

        int x;
        int rem=0;
        if(System.currentTimeMillis()- seg4>5000){        
            x=Greenfoot.getRandomNumber(600);
            if (ban==false){
                getWorld().addObject(p,0,0);
                getWorld().addObject(j,0,0);
                getWorld().addObject(m,0,0);
                getWorld().addObject(arma,0,0);
                for(Boton b : menu){
                    getWorld().addObject(b,0,0);
                }
                ban=true;
            }  

            if(System.currentTimeMillis()- seg3 > 1000 && tiempo>0){
                seg3=System.currentTimeMillis();
                tiempo--;
                getWorld().removeObject(b);
                b=new Label("Tiempo: "+Integer.toString(tiempo),40);
            }

            if(System.currentTimeMillis()- seg > 5000){
                for(int c=0;c<cantEnem;c++){Enemigo e = new Enemigo(x,200,Greenfoot.getRandomNumber(2));
                    seg = System.currentTimeMillis();
                    getWorld().addObject(e,x,0);
                    conEnem++;

                }
                if(conEnem>=15)
                    cantEnem++;
            }

            if(System.currentTimeMillis()- seg1 > 10000){
                seg1 = System.currentTimeMillis();
                Municion mun = new Municion(Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
                getWorld().addObject(mun,Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));

            }

            banA=arma.getCol();  
            if(banA!=null )
                j.daña(); 

            if(m.getBan()== 1){
                for(Boton b: menu)

                    if(b.getTipo()!=0)
                        tipo=b.getTipo(); 
            }

            if(tiempo==0 && n==2)
                ganar=true;

            perder=j.muerto();
            getWorld().addObject(b,100,420);

            if(tiempo==0 && n!=2)
            {
                getWorld().removeObjects(getWorld().getObjects(Enemigo.class));
                getWorld().removeObjects(getWorld().getObjects(Municion.class));
                getWorld().removeObjects(getWorld().getObjects(Label.class));
                getWorld().removeObjects(getWorld().getObjects(Arma.class));
                getWorld().removeObjects(getWorld().getObjects(Boton.class));
                getWorld().removeObjects(getWorld().getObjects(Salud.class));
                getWorld().removeObjects(getWorld().getObjects(Granada.class));
                getWorld().removeObjects(getWorld().getObjects(Bala.class));
                ban=false;
                c=0;
                n=2;
                seg4=System.currentTimeMillis();
                tiempo=30;
            }

        }
        else if(c==0){
            c=1;
            getWorld().addObject(new Nivel("Nivel"+n),0,0);
        }
    }

    /**
     * Metodo botonP regresa el tipo del boon presionado
     * @return tipo variable con el tipo de boton presionado
     */
    public int botonP()
    {
        return tipo;
    }

    /**
     * Metodo incPun este metodo incrementa los puntos del jugador
     */
    public void IncPun(){
        j.IncPuntos(10);
    }

    /**
     * Metodo incMuni este metodo incrementa la municion del arma del jugador
     */
    public void incMuni(){
        arma.incBalas(10);
    }

    /**
     * Metodo perder este metodo regresa una varible que indica si ha perdido o no
     * @return perder variable que indica si se ha perdido o no
     */
    public boolean perder()
    {
        return perder;

    }

    /**
     * Metodo getPuntos este metodo regresa los puntos del jugador
     * @return puntos varibale con los puntos del jugador
     */
    public int getPuntos()
    {
        return j.getPuntos();
    }

    /**
     * Este metodo regresa un abandera de tipo entero que indica cuando ha explotado
     * una granada en el juego
     * @return explosion variable que indica explosion de una granada
     * 
     */
    public boolean getExplosion(){
        return arma.getExplosion();
    }

    /**Este metodo retorna el valor de la variable ganar que indica si se a completado el juego.
    @return ganar 0 si no se ha ganado, 1 si se gano.
     */
    public boolean ganar()
    {
        return ganar;
    }
}