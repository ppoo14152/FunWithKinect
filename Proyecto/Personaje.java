import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**Esta clase permite tener un jugador el cual tendra coordenadas y salud
 * estas variables son publicas ya que heredara a otras clases.*/
 // x coordenada en el eje x del personaje.
 // y coordenada en el eje y del personaje.
 // salud variable que almacena la salud actual del personaje.

public class Personaje extends Actor
{ 
    public int x;
    public int y;
    public int salud;

    /**el ocnstructor inicializa las coordenadas y la salud, recibe como parametro estas variables
     * @param X coordenada en x que se le coloca al crear instancias de esta clase
     * @param Y coordenada en y que se le coloca al crear instancias de esta clase
     * @param S salud del personaje se le coloca al crear instancias de esta clase
     */
    public Personaje(int X, int Y, int S){
        x=X;
        y=Y;
        salud=S;
    }

}
