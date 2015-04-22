 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**Clase Pared perite crear objetos de tipo pared usados en el juegoLaberinto.
@param pared contiene la imagen de la pared.*/

public class Pared extends Objeto
{  private GreenfootImage pared;   
    /**Constructor de la clase inicializa las variables y llama al constructor de la superclase para inicializar las coordenadas iniciales del 
    objeto.
    @param tipo indica la posicion de la pared. 
    @param largo indica el largo en el eje x que tendra la pared.*/
    public Pared(int tipo, int largo){
        super(0,0);
        pared=new GreenfootImage("pared.png");
        pared.scale(largo,1);
        setImage(pared);
        if(tipo==2)
            setRotation(90);
        pared.setTransparency(100);
    }

    /**Metodo act de la clase vacio por default */
    public void act() 
    {
        // Add your action code here.
    } 

    /**Metodo que permite rotar el objeto tipo Pared */ 
    public void gira(int a){
        setRotation(a); 
    }
}
