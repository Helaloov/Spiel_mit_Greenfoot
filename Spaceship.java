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
        AlienKollision();
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
    
    public void AlienKollision()
    {
        if(isTouching(Alien.class))
        {   
            for(int i = 1 ; i < 9 ; i++)
            {
                setImage("ex" + i + ".png");
                Greenfoot.delay(5);
                
            }
            
            Greenfoot.stop();
        }
        
    }
}