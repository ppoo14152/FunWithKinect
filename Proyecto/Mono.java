import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**Clase Mono, nos permite crear objetos Mono usados en el juegoForest.
 * */
// forest   Variable que guarda los diferentes disfraces de el objeto.
// brinco   Contiene el sonido de brinco que se ejecuta al saltar.
// correr   Contiene el correr que se ejecuta mientras el jugador no salte ni se agache.
// disfraz        Variable que indica el disfraz que se esta utilizando y permite el cambio del disfraz.
// seg      Variable que contiene una relacion de tiempo y marca las transiciones entre disfraces.
// y2       Variable que contiene la posicion en el eje y de la cabeza del jugador.
// y3       Variable que contiene la posicion inicial en el eje y del jugador.
// banCoor      Bandera encargada de controlar las actualizaciones de y2 e y3.
// b        Bandera encargada de controlar el cambio de disfraces al agacharce.
// banSalto     Bandera encargada de detectar si se ha ejecutado un brinco.
// banAgacharse     Bandera encargada de detectar si el jugador se agacho.
// tropesar contiene el sonido tropesar el cual se reproduce si el jugador choca con algun objeto.

public class Mono extends Objeto
{
    private LinkedList<GreenfootImage> forest;
    private GreenfootSound brinco;
    private GreenfootSound correr;
    private int disfraz;
    private long seg;
    private int y2;
    private int y3;
    private boolean banCoor;
    private int b;
    private boolean banSalto;//salto
    private boolean banAgacharse;//agacharce
    private int tropesar;

    /**Constructor de la clase, aqui se inicializan todas la variable, ademas se llama al constructor de la superclase para inicializar las coordenadas iniciales del objeto
    @param X Indica la coordenada inicial del objeto en el eje x.
    @param Y Indica la coordenada inicial del objeto en el eje y
     */
    public Mono(int X, int Y)
    {
        super(X,Y);
        banCoor=false;
        b=0;
        banSalto=false;
        banAgacharse=false;
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
        disfraz=0;
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
            if(banCoor==false){
                y3=y2;
                banCoor=true;
            } 
        }  

        if(y2<y3-20 && banSalto==false && banAgacharse==false)
        {
            banSalto=true; 
            brinco.play();
            disfraz=0;  
        }
        else if(y2>y3+20 && banAgacharse==false && banSalto==false){
            banAgacharse=true;
            disfraz=0;
        }

        if( System.currentTimeMillis()- seg   >=150){
            banCoor=false;
            x+=1;
            if(banSalto==true && banAgacharse==false){

                if(correr.isPlaying()==true)
                    correr.stop();

                if(disfraz>1)
                    y=y+50;
                else
                    y=y-50;
                setLocation(x,y);
                setImage(forest.get(disfraz+4));
                disfraz++;
                if(disfraz+4==8)
                    banSalto=false;
            }
            else if(banAgacharse==true && banSalto==false){
                if(correr.isPlaying()==true)
                    correr.stop();
                setLocation(x,y);
                setImage(forest.get(disfraz+8));
                if(disfraz+8<11 && b==0){
                    disfraz++;
                    y+=10;
                }
                else
                    b=1;
                if(b==1){
                    y-=10;
                    disfraz--;
                }
                if(disfraz==0){
                    b=0;
                    banAgacharse=false;
                }
            }else if(banSalto==false  && banAgacharse==false){
                correr.play();
                if(disfraz<3)
                    disfraz++;
                else{
                    disfraz=0;
                }
                setLocation(x,y);
                setImage(forest.get(disfraz));

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

