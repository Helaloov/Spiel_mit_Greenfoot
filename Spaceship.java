import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.concurrent.TimeUnit;

public class Spaceship extends Actor 
{

    int pause =1;
    GreenfootSound laser = new GreenfootSound("laser.wav");
    GreenfootSound Explosion = new GreenfootSound("explosion.wav");
    boolean explode = false;
    int Counter = 72;
    int imageNumber = 1;
    public void act() 

    { 
        move();
        Schießen();
        AlienKollision();
        Alien_Schuss();
        if (explode)
        {
            Counter--;
            if(Counter == -1) {explode = false;Counter = 70;}
        }
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
        if (Greenfoot.isKeyDown("space") && pause % 13 == 1) 
        {
            Schuss schuss = new Schuss();
            getWorld().addObject(schuss, getX() , getY());
            laser.play();
        } 

        pause++;
    }

    public void AlienKollision()
    {
        if(isTouching(Alien.class))
        {   
            explode = true;
            Explosion.play();
        }

    }

    public void Alien_Schuss()
    {
        Actor schuss = getOneIntersectingObject(Alien_Schuss.class);
        if(schuss != null )
        {explode = true;Explosion.play();
            getWorld().removeObject(schuss);}
        if(explode)
        {   

            if(Counter % 5 == 0 && Counter  > 35)
            {   

                setImage("ex" + imageNumber + ".png");
                imageNumber++;

            }
            if(Counter == 35 ){
                Spaceship new_spaceship = new Spaceship();
                getWorld().addObject(new_spaceship,50 , 70);
                getWorldOfType(Space_invader_world.class).ChangeLeben();
                
                getWorld().removeObjects(getWorld().getObjects(Alien_Bonus.class));
                Counter = 72;
                
                imageNumber =1;

                getWorld().removeObject(this);}
        }
    }
}