    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    import java.util.*;
   
    public class JuegoGuerra extends Juego
    {
        private LinkedList<Boton> menu=new LinkedList<Boton>(); 
        private Arma arma;        
        private int ban; 
        private int tipo;
        private int perder;
        private int cM;        
        private long seg, seg1,seg2;
        private Actor banA;
        public JuegoGuerra(){
            super(new Pantalla("guerra"),new Jugador(50,50,100),new Mira(0,0,2));
            arma= new Arma(50,50);           
            menu.add(new Boton(580,450,2));
            ban=0;
            tipo=0;
            perder=0;
            cM=0;
            seg=System.currentTimeMillis();
            seg1=System.currentTimeMillis();
            seg2=System.currentTimeMillis();
            }
        public void act() 
        {  
           int x;
           int rem=0;
           x=Greenfoot.getRandomNumber(600);
                if (ban==0){
                  getWorld().addObject(p,0,0);
                  getWorld().addObject(j,0,0);
                  getWorld().addObject(m,0,0);
                  getWorld().addObject(arma,0,0);
                  for(Boton b : menu){
                   getWorld().addObject(b,0,0);
                               }
                  ban=1;
                           }                   
                    
              
               if(System.currentTimeMillis()- seg > 5000){
                  
                Enemigo e = new Enemigo(x,200,Greenfoot.getRandomNumber(2));
                seg = System.currentTimeMillis();
                getWorld().addObject(e,x,0);
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
               perder=j.muerto();
        }
            
    
        public int botonP()
        {
            return tipo;
        }
        public void IncPun(){
                j.IncPuntos(10);
                             }
        public void incMuni(){
                arma.incBalas(10);
                              }
        public int perder()
        {
            return perder;
           
        }
     
    }