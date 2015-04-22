    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    import java.util.*;
   
    public class JuegoGool extends Juego
    {
        LinkedList<Boton> menu=new LinkedList<Boton>(); 
       private int ban;
       private int ban2;
       private int ban3;
       private int tipo;
       private int pd;
       private  int pi;
       private int perder;
       private Porteria port;
       private Balon balon;
       private Portero portero;
        public JuegoGool(){
            super(new Pantalla("gool"),new Jugador(50,50,100),new Mira(0,0,4));
            menu.add(new Boton(580,450,2));
            port=new Porteria(340,200);
            balon=new Balon(340,420,10);
            portero= new Portero(340,210);
            ban=0;
            ban2=0;
            ban3=0;
            tipo=0;
            perder=0;
            }
        public void act() 
        {  
           
                if (ban==0){
                  getWorld().addObject(p,0,0);
                  getWorld().addObject(j,0,0);
                  getWorld().addObject(m,0,0);
                  getWorld().addObject(port,340,200);
                  getWorld().addObject(balon,340,420);
                  getWorld().addObject(portero,340,420);
                  for(Boton b : menu){
                   getWorld().addObject(b,0,0);
                               }
                  ban=1;
                           }                   
                    
           KinectWorld mundo =(KinectWorld)getWorld();
           
           UserData[] usuarios = mundo.getTrackedUsers();
           for(UserData i : usuarios)
           {         
            Joint pie = i.getJoint(Joint.RIGHT_FOOT);
            pd=pie.getY();
            if(ban2==0){
            pie = i.getJoint(Joint.LEFT_FOOT);
            pi=pie.getY();
            ban2=1;
                        }
            
           } 
           
           if(pi-pd>40 && ban3==0){
              balon.patada();
         
              ban3=1;
                        }
           else if(pi-pd<40)
              ban3=0;
           balon.setDireccion(m.getX(),m.getY()); 
               if(m.getBan()== 1){
                for(Boton b: menu)
                
               if(b.getTipo()!=0)
                tipo=b.getTipo(); 
                                 }
               perder=j.muerto();
        }
            
    
        public int botonP()
        {
            return tipo;
        }
        public void IncPun(){
                j.IncPuntos(10);
                             }
        public int perder()
        {
            return perder;
           
        }
    }