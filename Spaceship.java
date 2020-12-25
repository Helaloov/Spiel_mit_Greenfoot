import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.concurrent.TimeUnit;
/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse spaceship.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spaceship extends Actor
{
    int z=1;
    public void act() 

    { 
        move();
        Schießen();
    }

    public void move(){
        if (Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX() + 1, getY());
        } 

        if (Greenfoot.isKeyDown("left")) 
        {
            setLocation(getX() - 1, getY());
        }
    }
    
     public void Schießen()
    {
        if (Greenfoot.isKeyDown("space") && z % 13 == 1) 
        {
            Schuss schuss = new Schuss();
            getWorld().addObject(schuss, getX() , getY());
        } 
        z++;
    }
}