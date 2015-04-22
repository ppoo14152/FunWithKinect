import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**Clase Mono, nos permite crear objetos Mono usados en el juegoForest.
@param forest Variable que guarda los diferentes disfraces de el objeto.
@param brinco Contiene el sonido de brinco que se ejecuta al saltar.
@param correr Contiene el correr que se ejecuta mientras el jugador no salte ni se agache.
@param c Variable que indica el disfraz que se esta utilizando y permite el cambio del disfraz.
@param seg Variable que contiene una relacion de tiempo y marca las transiciones entre disfraces.
@param y2  Variable que contiene la posicion en el eje y de la cabeza del jugador.
@param y3  Variable que contiene la posicion inicial en el eje y del jugador.
@param ban Bandera encargada de controlar las actualizaciones de y2 e y3.
@param b   Bandera encargada de controlar el cambio de disfraces al agacharce.
@param ban2 Bandera encargada de detectar si se ha ejecutado un brinco.
@param ban3 Bandera encargada de detectar si el jugador se agacho.
@param tropesar contiene el sonido tropesar el cual se reproduce si el jugador choca con algun objeto.
 */
public class Mono extends Objeto
{
    private LinkedList<GreenfootImage> forest;
    private GreenfootSound brinco;
    private GreenfootSound correr;
    private int c;
    private long seg;
    private int y2;
    private int y3;
    private int ban;
    private int b;
    private int ban2;//salto
    private int ban3;//agacharce
    private int tropesar;

    /**Constructor de la clase, aqui se inicializan todas la variable, ademas se llama al constructor de la superclase para inicializar las coordenadas iniciales del objeto
    @param X Indica la coordenada inicial del objeto en el eje x.
    @param Y Indica la coordenada inicial del objeto en el eje y
     */
    public Mono(int X, int Y)
    {
        super(X,Y);
        ban=0;
        b=0;
        ban2=0;
        ban3=0;
        brinco= new GreenfootSound("saltoforest.mp3");
        correr= new GreenfootSound("correr.mp3");
        forest=new LinkedList <GreenfootImage> () ;
        forest.add(new GreenfootImage ("mono1.png"));
        forest.add(new GreenfootImage ("mono2.png"));
        forest.add(new GreenfootImage ("mono3.png"));
        forest.add(new GreenfootImage ("mono4.png"));
        forest.add(new GreenfootImage ("salto1.png"));
        forest.add(new GreenfootImage ("salto2.png"));
        forest.add(new GreenfootImage ("salto3.png"));
        forest.add(new GreenfootImage ("salto4.png"));
        forest.add(new GreenfootImage ("derrape1.png"));
        forest.add(new GreenfootImage ("derrape2.png"));
        forest.add(new GreenfootImage ("derrape3.png"));
        forest.add(new GreenfootImage ("derrape4.png"));
        c=0;
        tropesar=0;
        seg=System.currentTimeMillis();
        setLocation(x,y);
        setImage(forest.get(0));
    }

    /**Metodo act de la clase, se realiza el cambio de disfraces, ademas de se verifica si se ha realizado un salto o si el jugador se agacha, nos muestra el personaje en pantalla y se detecta si el jugador a sido 
    atrapado por el enemigo.*/
    public void act() 
    {

        KinectWorld mundo =(KinectWorld)getWorld();
        UserData[] usuarios = mundo.getTrackedUsers();
        for(UserData i : usuarios)
        {         
            Joint cabeza = i.getJoint(Joint.HEAD);            
            y2=cabeza.getY();   
            if(ban==0){
                y3=y2;
                ban=1;
            } 
        }  

        if(y2<y3-20 && ban2==0 && ban3==0)
        {
            ban2=1; 
            brinco.play();
            c=0;  
        }
        else if(y2>y3+20 && ban3==0 && ban2==0){
            ban3=1;
            c=0;
        }

        if( System.currentTimeMillis()- seg   >=150){
            ban=0;
            if(ban2==1 && ban3==0){

                if(correr.isPlaying()==true)
                    correr.stop();
                if(c>1)
                    y=y+50;
                else
                    y=y-50;
                setLocation(x,y);
                setImage(forest.get(c+4));
                c++;
                if(c+4==8)
                    ban2=0;
            }
            else if(ban3==1 && ban2==0){
                if(correr.isPlaying()==true)
                    correr.stop();
                setLocation(x,y);
                setImage(forest.get(c+8));
                if(c+8<11 && b==0){
                    c++;
                    y+=10;
                }
                else
                    b=1;
                if(b==1){
                    y-=10;
                    c--;
                }
                if(c==0){
                    b=0;
                    ban3=0;
                }
            }else if(ban2==0  && ban3==0){
                correr.play();
                if(c<3)
                    c++;
                else{
                    c=0;
                }
                setLocation(x,y);
                setImage(forest.get(c));

            }
            seg=System.currentTimeMillis();
        }

        if(getOneIntersectingObject(Sombra.class)!=null){
            ((Inicio)getWorld()).daña();
        } 

    }

    /**Metodo retrocede, reduce la posicion en x de el objeto cada vez que choca.*/
    public void retrocede()
    {
        x-=20;
    }

}

