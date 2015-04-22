import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class JuegoForest extends Juego
{
    private int ban;
    private int tipo;
    private int perder;
    private int c;
    private int o;
    private long seg;
    private long seg1;
    private Mono forest;
    private Sombra sombra;
    public JuegoForest()
    {

        super(new Pantalla("Forest",640,240),new Jugador(50,50,100),new Mira(0,0, 4 ));
        forest= new Mono(240,420);
        sombra= new Sombra(50,420);
        menu.add(new Boton(580,450,2));
        ban=0;
        c=640;
        o=0;
        seg=System.currentTimeMillis();
        seg1=System.currentTimeMillis();
        perder=0;
    }

    public void act() 
    {
        Random r=new Random();
        if(ban==0){
            getWorld().addObject(j,0,0);
            getWorld().addObject(p,0,0);
            getWorld().addObject(m,0,0);
            getWorld().addObject(forest,240,440);
            getWorld().addObject(sombra,50,440);
            for(Boton b : menu){
                getWorld().addObject(b,0,0);
            }
            ban=1;

        }

        if(  System.currentTimeMillis()- seg   >= 100){          
            seg=System.currentTimeMillis();
            if(c==0)
                c=640;
            else
                c-=2;
            p.Scroll(c,240);
            if(o==25){
               if(  System.currentTimeMillis()- seg1   >= 5000){          
               seg1=System.currentTimeMillis();
               getWorld().addObject(new Monstruo(640,372),640,372);
               }
               else{
                if(r.nextFloat() > .5f)
                    getWorld().addObject(new Obstaculo(640,450,"carro",18),640,450);
                else
                    getWorld().addObject(new Obstaculo(640,450,"bote",18),640,450);
               }
             o=0;}
            else
                o++;

        }
        
        if(m.getBan()== 1){
            for(Boton b: menu)

                if(b.getTipo()!=0)
                    tipo=b.getTipo(); 
        }
        perder=j.muerto();
    }

    public int botonP(){
        return tipo;
    }

    public void IncPun(){
        j.IncPuntos(10);
    }

    public void daña()
    {
        j.daña();
    }

    public void retrocede(){
        forest.retrocede();
    }

    public int perder()
    {
        return perder;
    }

}
