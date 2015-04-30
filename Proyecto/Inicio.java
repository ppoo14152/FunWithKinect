import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.LinkedList;
/**La clase inicio es un mundo donde se crearan cada uno de los diferentes escenarios del juego asi como sus diferentes componentes.
@param THUMNAIL_HEIGHT Esta variable guarda el valor de la altura del mundo.
@param THUMNAIL_WIDTH  Esta variable guarda el valor de la anchura del mundo.
@param leftHandUP      Bandera que se usa para detectar si nuestro jugador esta levantando las manos.
@param ban             Bandera usada al incertar un objeto, no permite que el objeto se incerte mas que una vez.
@param mundo           Esta variable guarda el mundo en el que se encuentra el jugador.     
@param musica          Se encarga de almacenar la musica del juego */

public class Inicio extends KinectWorld
{

    private static final int THUMBNAIL_WIDTH = 80;
    private static final int THUMBNAIL_HEIGHT = 60;
    private long leftHandUp;
    private int pideDatos;
    private Pantalla calibra;
    private int ban=0; 
    private KinectFun mundo;
    private GreenfootSound musica;
    private int puntuacion;
    private Usuario usuario;
    private Records rec;

  

    /**Es el constructor de la clase se llama al constructor de la superclase, donde se crea una 
     * pequeña camara que es odnde se visualiza el jugador al inicio del juego
     */
    public Inicio ()
    {    
        super(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT, 1.0, false);
        puntuacion=0;
     
        pideDatos=0;
        calibra=new Pantalla("Calibrar");
        setActOrder(Pantalla.class,Boton.class,Mira.class,Mono.class );
        final int width = getWidth();
        final int height = getHeight();
        usuario= new Usuario();
        rec=new Records();
        mundo=new Principal(); 
        musica= new GreenfootSound("menuMusica.mp3");
        addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
        addObject(calibra,width/2,height/2);
        rec.addUsuario(usuario);
        
    }

    /**En el act se conecta al jugador con el juego y una ves que esta conectado
     * se revisan  los botones para poder crear un escenario en base al boton seleccionado
     */
    public void act()
    {  
        
        super.act();
       
       
        if (!isConnected())
            return;
        UserData[] us = getTrackedUsers();
        boolean anyLeftHandUp = false;
        for (UserData u: us)
        {
            anyLeftHandUp = anyLeftHandUp || (u.getJoint(Joint.LEFT_HAND).getY() < u.getJoint(Joint.HEAD).getY());
        }

        if (anyLeftHandUp && ban==0 )
        {
            ban=1;
            removeObject(calibra);
            musica= new GreenfootSound("menuMusica.mp3");
            musica.setVolume(50);
            musica.play();
            addObject(mundo,0,0);
        }
        else{
            musica.setVolume(50);
            switch(mundo.botonP()){
                case 0:
                
                if((mundo).perder()== 1){
                    if(musica.isPlaying()==true)
                        musica.stop();
                    puntuacion+=((Juego)mundo).getPuntos();
                    removeObjects(getObjects(null));
                    mundo=new GameOver();
                    addObject(mundo,0,0);
                                         }
                    else if((mundo).ganar()==1){
                        if(musica.isPlaying()==true)
                        musica.stop();
                        puntuacion+=((Juego)mundo).getPuntos();
                        removeObjects(getObjects(null));
                        mundo=new Ganar(puntuacion);
                        addObject(mundo,0,0);
  
                    }

                break;
                case 1: //botonJugar.png, carga los botones de los distintos juegos 
                if(musica.isPlaying()==true)
                    musica.stop();
                musica= new GreenfootSound("menuMusica.mp3");
                musica.play();
                removeObjects(getObjects(null));
                mundo=new Juegos();
                addObject(mundo,0,0);
                break;
                case 2: //   botonSalir.png, carga los botones de salir y la ayuda
                if(musica.isPlaying()==true)
                    musica.stop();
                musica= new GreenfootSound("menuMusica.mp3");
                musica.play();
                if(mundo instanceof Juego)
                    puntuacion+=((Juego)mundo).getPuntos();
                removeObjects(getObjects(null));
                mundo=new Principal(); 
                addObject(mundo,0,0);
                break;
                case 3://botonAyuda.png carga los botones de menuInicio3
                removeObjects(getObjects(null));
                mundo=new Ayuda(); 
                addObject(mundo,0,0);

                break;
                case 4: //botonMundo1.png carga boton de salir y juego 1
                if(musica.isPlaying()==true)
                    musica.stop();
                removeObjects(getObjects(null));
                mundo = new JuegoLaberinto();
                addObject(mundo,0,0);
                musica= new GreenfootSound("laberintoMusica.mp3");
                musica.playLoop();
                break;
                case 5: //botonMundo2.png carga boton de salir y juego 2
                if(musica.isPlaying()==true)
                    musica.stop();
                removeObjects(getObjects(null));
                mundo = new JuegoForest();
                addObject(mundo,0,0);
                musica= new GreenfootSound("forestMusica.mp3");
                musica.playLoop();
                break;
                case 6:  //botonMundo3.png carga boton de salir y juego 3
                if(musica.isPlaying()==true)
                    musica.stop();
                removeObjects(getObjects(null));
                mundo = new JuegoGool();
                addObject(mundo,0,0);
                break;

                case 7:         
                if(musica.isPlaying()==true)
                    musica.stop();
                removeObjects(getObjects(null));
                mundo= new JuegoGuerra();
                addObject(mundo,0,0);
                musica= new GreenfootSound("guerraSound.mp3");
                musica.playLoop();
                break;

                case 8://records         
                if(musica.isPlaying()==true)
                    musica.stop();
                removeObjects(getObjects(null));


                musica= new GreenfootSound("guerraSound.mp3");
                musica.playLoop();
                break;

            }

        }       
    }

    /**Este metodo incrementa los puntos del jugador, el cual se encuentra contenido en los diferentes escenarios.     
     */
    public void IncPun(){
        ((Juego)mundo).IncPun();
    }

    /**Este metodo solo se aplica cuando existe un escenario de tipo juegoGuerra ya que es      * 
     * el unico que requiere municion.
     */     
    public void incMun(){
        ((JuegoGuerra)mundo).incMuni();
    }

    /**Este metodo reduce la salud del jugador  en juegoForest.
     */
    public void daña(){
        ((JuegoForest)mundo).daña();
    }

    /**Este metodo retrocede al jugador en el minujuego juegoForest.
     */
    public void tropesar(){
        ((JuegoForest)mundo).retrocede();

    }

    /**Este metodo permite saber el estado de el obstaculo picos en el juegoLaberinto
     * depende de este para perder.
     */
    public int getPicos(){
        return ((JuegoLaberinto)mundo).getPicos();
    }

    /**l metodo detiene la musica si es que se presiona el boton pause de greenfoot
     */
    public void stopped(){
        if(musica.isPlaying()==true)
            musica.stop();
       
    }  

    /**
     * este metodo determina si una granada ha explotado
     * @return explosion variable que se pone en 1 si una granada explota
     */
    public int explota(){
        return ((JuegoGuerra)mundo).getExplosion();
    }
}