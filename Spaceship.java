import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.concurrent.TimeUnit;


public class Spaceship extends Actor 
{
    
    int z=1;
    public void act() 

    { 
        move();
        Schießen();
        AlienKollision();
        Alien_Schuss();
        
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

    public void Alien_Schuss()
    {
        Actor schuss = getOneIntersectingObject(Alien_Schuss.class);
        if(schuss != null )
        {
            getWorld().removeObject(schuss);
            for(int i = 1 ; i < 9 ; i++)
            {
                setImage("ex" + i + ".png");
                Greenfoot.delay(5);
               

            }
            Spaceship new_spaceship = new Spaceship();
            
            getWorld().addObject(new_spaceship,50 , 70);
            getWorldOfType(Space_invader_world.class).ChangeLeben();
            
            getWorld().removeObject(this);

        }
        
    }
    
    
}