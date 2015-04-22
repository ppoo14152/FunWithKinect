import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**Esta clase permite tener un jugador el cual tendra coordenadas y salud
 * estas variables son publicas ya que heredara a otras clases.
 * @param x coordenada en el eje x del personaje.
 * @param y coordenada en el eje y del personaje.
 * @param salud variable que almacena la salud actual del personaje.
 */
public class Personaje extends Actor
{ 
    public int x;
    public int y;
    public int salud;

    /**
    El ocnstructor inicializa las coordenadas y la salud, recibe como parametro estas variables
     */
    public Personaje(int X, int Y, int S){
        x=X;
        y=Y;
        salud=S;
    }

}
