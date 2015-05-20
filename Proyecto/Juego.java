import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**Clase Juego, Contiene los metodos usados en los diferentes juegos.*/
//j Variable de tipo Juegador que representa el usuario.*/
// perder variable que indica cuando se pierde
// ganar variable que indica cuando se gana
abstract class Juego extends KinectFun
{

    protected  Jugador j;
    protected boolean perder;
    protected boolean ganar;
    /**Constructor inicializa las variables.
    @param P contiene la pantalla del juego.
    @param J contiene el jugador.
    @param M contiene la mira que se utilizara.
     */
    public Juego(Pantalla P, Jugador J,Mira M)
    {
        super (P,M);
        j=J;
        perder=false;
        ganar=false;
    }

    /** Metodo nuevoNivel usado en juegoLaberinto crea una nueva pantalla y una mira y remueve los anterio.
    @param pa contiene la nueva pantalla del juego.
    @param mi contiene la nueva mira.
     */  
    public void nuevoNivel(Pantalla pa, Mira mi){
        super.nuevoNivel(pa,mi);
    }

    /**Metodo abstracto se define en las subclases.*/
    abstract int botonP();

    /**Metodo abstracto se define en las subclases.*/
    abstract void IncPun();

    /**Metodo abstracto se define en las subclases.*/
    abstract boolean perder();

    /**Metodo abstracto se define en las subclases.*/
    abstract int getPuntos();

    /**Metodo abstracto se define en las subclases.*/
    abstract boolean ganar();

}
