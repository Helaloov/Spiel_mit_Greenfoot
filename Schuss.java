import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse Schuss.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Schuss extends Actor
{
    
    public void act() 
    {
        
         setLocation(getX() , getY() - 2);
         
         
         Remove();
    }    
    
    
    
    public void Remove()
    {
        if( isAtEdge())
        {
           getWorld().removeObject(this);
           
           
        }
    }
}