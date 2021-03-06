import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.LinkedList;

/**La clase inicio es un mundo donde se crearan cada uno de los diferentes escenarios del juego asi como sus diferentes componentes.*/
// THUMNAIL_HEIGHT Esta variable guarda el valor de la altura del mundo.
// THUMNAIL_WIDTH  Esta variable guarda el valor de la anchura del mundo.
// leftHandUP      Bandera que se usa para detectar si nuestro jugador esta levantando las manos.
// banInsercion             Bandera usada al incertar un objeto, no permite que el objeto se incerte mas que una vez.
// mundo           Esta variable guarda el mundo en el que se encuentra el jugador.     
// musica          Se encarga de almacenar la musica del juego 
// calibra         Contiene la imagen de inicio que indica los pasos para poder jugar.
//mira             Variable de tipo mira se usa en los menus.
//banInsercion              Bandera que controla la insercion de objetos en el mundo.
//mundo            Contenedor del juego, aqui se insertan todos los objetos.
//musica           Contiene los diferentes sonidos de ambiente que se reproducen en el juego.
//puntuacion       Variable que contiene la puntuacion del jugador en el juego.
//usuario          Objeto que contiene los datos del usuario.
//rec              Se encarga de gusrdar los jugadores.
//tabla            Representa los records en una tabla ordenada.

public class Inicio extends KinectWorld
{

    private static final int THUMBNAIL_WIDTH = 160;
    private static final int THUMBNAIL_HEIGHT = 120;
    private long leftHandUp;   
    private Pantalla calibra;
    private Mira mira;
    private boolean banInsercion; 
    private KinectFun mundo;
    private GreenfootSound musica;
    private int puntuacion;
    private Usuario usuario;
    private Records rec;
    private TablaRecords tabla;
    private boolean banNom;
    final int width = getWidth();
    final int height = getHeight();

    /**Es el constructor de la clase se llama al constructor de la superclase, donde se crea una 
     * pequeña camara que es odnde se visualiza el jugador al inicio del juego
     */
    public Inicio ()
    {    
        super(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT, 1.0, false);
        puntuacion=0;
        banNom=false;
        banInsercion=false;       
        calibra=new Pantalla("Calibrar");
        setActOrder(Pantalla.class,Boton.class,Mira.class,Mono.class,Thumbnail.class );
       
        usuario= new Usuario();
        rec=new Records();
        mundo=new Principal();
        musica= new GreenfootSound("menuMusica.mp3");
        addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
        addObject(calibra,width/2,height/2);

    }

    /**En el act se conecta al jugador con el juego y una ves que esta conectado
     * se revisan  los botones para poder crear un escenario en base al boton seleccionado
     */
    public void act()
    {  

        super.act();
        if(banNom==false){
            banNom=true;
            usuario.setNombre(Greenfoot.ask("dame tu nombre"));
        }

        if (!isConnected())
            return;
        UserData[] us = getTrackedUsers();
        boolean anyLeftHandUp = false;
        for (UserData u: us)
        {
            anyLeftHandUp = anyLeftHandUp || (u.getJoint(Joint.LEFT_HAND).getY() < u.getJoint(Joint.HEAD).getY());
        }

        if (anyLeftHandUp && banInsercion==false )
        {
            banInsercion=true;
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

                if((mundo).perder()== true){
                    if(musica.isPlaying()==true)
                        musica.stop();
                    puntuacion+=((Juego)mundo).getPuntos();
                    removeObjects(getObjects(null));
                    addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
                    mundo=new GameOver();
                    addObject(mundo,0,0);
                }
                else if((mundo).ganar()==true){
                    if(musica.isPlaying()==true)
                        musica.stop();
                    puntuacion+=((Juego)mundo).getPuntos();
                    removeObjects(getObjects(null));
                     addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
                    mundo=new Ganar(puntuacion);
                    addObject(mundo,0,0);

                }
                usuario.setPuntos(puntuacion);
                break;
                case 1: //botonJugar.png, carga los botones de los distintos juegos 
                if(musica.isPlaying()==true)
                    musica.stop();
                musica= new GreenfootSound("menuMusica.mp3");
                musica.play();
                removeObjects(getObjects(null));
                 addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
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
                addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
                mundo=new Principal(); 
                addObject(mundo,0,0);
                break;
                case 3://botonAyuda.png carga los botones de menuInicio3
                removeObjects(getObjects(null));
                 addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
                mundo=new MenuAyuda(); 
                addObject(mundo,0,0);

                break;
                case 4: //botonMundo1.png carga boton de salir y juego 1
                if(musica.isPlaying()==true)
                    musica.stop();
                removeObjects(getObjects(null));
                 addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
                mundo = new JuegoLaberinto();
                addObject(mundo,0,0);
                musica= new GreenfootSound("laberintoMusica.mp3");
                musica.playLoop();
                break;
                case 5: //botonMundo2.png carga boton de salir y juego 2
                if(musica.isPlaying()==true)
                    musica.stop();
                removeObjects(getObjects(null));
                 addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
                mundo = new JuegoForest();
                addObject(mundo,0,0);
                musica= new GreenfootSound("forestMusica.mp3");
                musica.playLoop();
                break;
                case 6:  //botonMundo3.png carga boton de salir y juego 3
                if(musica.isPlaying()==true)
                    musica.stop();
                removeObjects(getObjects(null));
                 addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
                mundo = new JuegoGool();
                addObject(mundo,0,0);
                break;

                case 7:         
                if(musica.isPlaying()==true)
                    musica.stop();
                removeObjects(getObjects(null));
                 addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
                mundo= new JuegoGuerra();
                addObject(mundo,0,0);
                musica= new GreenfootSound("guerraSound.mp3");
                musica.playLoop();
                break;

                case 8://records         
                if(musica.isPlaying()==true)
                    musica.stop();
                removeObjects(getObjects(null));
                 addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
                mundo= new Record();
                addObject(mundo,0,0); 
                rec.addUsuario(usuario);
                tabla=new TablaRecords(rec.creaTablaRecords());
                addObject(tabla,0,0); 
                break;
                case 9://AyudaForest 
                removeObjects(getObjects(null));
                 addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
                mundo=new Ayuda("AyudaJForest");
                addObject(mundo,0,0);
                addObject(new Boton(500,400,2),500,400);
                addObject(new Mira(0,0,1),0,0);
                //Reproducir sonido AyudaForest
                break;
                case 10://AyudaGool
                removeObjects(getObjects(null));
                 addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
                mundo=new Ayuda("AyudaJGool");
                addObject(mundo,0,0);
                break;
                case 11://AyudaLaberinto
                removeObjects(getObjects(null));
                 addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
                mundo=new Ayuda("AyudaJLaberinto");
                addObject(mundo,0,0); 
                break;
                case 12://AyudaResistencia;
                removeObjects(getObjects(null));
                 addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
                mundo=new Ayuda("AyudaJResistencia");
                addObject(mundo,0,0);
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
    public boolean explota(){
        return ((JuegoGuerra)mundo).getExplosion();
    }
}