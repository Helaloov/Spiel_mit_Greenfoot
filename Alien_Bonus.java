import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse Alien_Bonus.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Alien_Bonus extends Actor
{
    int Start_moving_time = 0 ;
    int End_moving_time = 100 ;
    long time_start;
    int z = 1;
   public void act() 
   {
         SaveTime();
         move();
         Remove();
   }
    
   public void move()
    {
         long time_now = System.currentTimeMillis();
        if(time_now - time_start > Start_moving_time && 
        time_now - time_start < End_moving_time )
        {
        setLocation(getX() +1, getY()  );
        Start_moving_time += 100;
        End_moving_time += 100;
        
        }
    }
   
   public void SaveTime(){
        
        if(z == 1 )
        {
            time_start = System.currentTimeMillis(); z++;
        }}
        
   public void RemoveAtEdge()
    {
        if( isAtEdge())
        {
           getWorld().removeObject(this);
           
           
        }
    }
    
   public void Remove()
    {
      if(isTouching(Schuss.class))
      {
          getWorldOfType(Space_invader_world.class).set_score(50);
          getWorld().removeObjects(getWorld().getObjects(Alien_Bonus.class));
          
      }
      else { RemoveAtEdge();}
    }
}