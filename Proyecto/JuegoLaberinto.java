import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
public class JuegoLaberinto extends Juego
{
    private  Label b;
    private  GreenfootSound rata;     
    private  int ban;
    private int tipo;
    private int perder;
    private BaraFuego bara;
    private Pared pared;
    private Picos picos;
    private int inicia;
    private long seg;
    private int gana;
    public JuegoLaberinto()
    {
        super(new Pantalla("Laberinto"),new Jugador(50,50,100),new Mira(0,0,3 ));
        menu.add(new Boton(580,450,2));
        picos=new Picos();
        b=new Label("inicia en la zona azul y llega a la verde",40);        
        ban=0;
        seg=System.currentTimeMillis();
        rata= new GreenfootSound("rata.mp3");
        perder=0;
        bara=new BaraFuego();
        inicia=0;
        gana=0;
    }

    public void act() 
    {
        if(ban==0){

            //getWorld().addObject(j,0,0);
            getWorld().addObject(p,0,0);
            getWorld().addObject(m,0,0);
            /*for(Boton b : menu){
            getWorld().addObject(b,0,0);
            }*/
            ban=1;
            creaLaberinto();  
            getWorld().addObject(b,320,220);
            getWorld().addObject(bara,572,200);
            getWorld().addObject(picos,260,288);
        }
        if(  System.currentTimeMillis()- seg   >= 4000){    
            rata.play();
            seg=System.currentTimeMillis();
        }
        if(m.getX()<640&&m.getX()>600 &&m.getY()>0 &&m.getY()<60 && inicia==0){
            inicia=1;
            getWorld().removeObject(b);
        }
        if(m.getBan()== 1){
            for(Boton b: menu)

                if(b.getTipo()!=0)
                    tipo=b.getTipo(); 
        }

        if(inicia==1){
            if(m.ratonMuere()==1){        
                System.out.println(perder);
                perder=1;
            }
        }

 
    }

    public int botonP(){
        return tipo;
    }

    public void IncPun(){
        j.IncPuntos(10);
    }

    public int perder()
    {
        return perder;
    }

    public void creaLaberinto(){

        //paredes del laberinto//      
        pared=new Pared(1,80); 
        getWorld().addObject(pared,40,86); 

        pared=new Pared(2,40);
        getWorld().addObject(pared,79,67);

        pared=new Pared(1,480);
        getWorld().addObject(pared,319,38);

        pared=new Pared(1,490);
        getWorld().addObject(pared,395,77);

        pared=new Pared(2,50);
        getWorld().addObject(pared,150,103);

        pared=new Pared(1,120);
        getWorld().addObject(pared,91,127);

        pared=new Pared(2,40);
        getWorld().addObject(pared,32,147);

        pared=new Pared(1,40);
        getWorld().addObject(pared,52,165);

        pared=new Pared(2,40);
        getWorld().addObject(pared,71,186);

        pared=new Pared(1,40);
        getWorld().addObject(pared,51,204);

        pared=new Pared(1,400);
        getWorld().addObject(pared,195,230);

        /* pared=new Pared(2,540);
        getWorld().addObject(pared,370,254);*/

        pared=new Pared(2,80);
        getWorld().addObject(pared,101,294);

        pared=new Pared(1,300);
        getWorld().addObject(pared,252,334);

        pared=new Pared(1,500);
        getWorld().addObject(pared,250,375);

        pared=new Pared(2,50);
        getWorld().addObject(pared,400,309);

        pared=new Pared(1,150);
        getWorld().addObject(pared,475,283);

        pared=new Pared(2,200);
        getWorld().addObject(pared,550,383);

        pared=new Pared(2,60);
        getWorld().addObject(pared,498,345);

        pared=new Pared(1,20);
        getWorld().addObject(pared,509,315);

        pared=new Pared(2,120);
        getWorld().addObject(pared,517,376);

    }

    public int getPicos(){
        return picos.getPicos();
    }
}
