import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse Alien.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Alien extends Actor
{
    long time_start;
    
    int  Start_moving_time = 0;
    int  End_moving_time = 0;
    
    int  Start_moving_time2 = 0;
    int  End_moving_time2 = 0;
    
    int  Start_moving_time3 = 6900;
    int  End_moving_time3 = 7000;
    
    int  Start_moving_time4 = 2900;
    int  End_moving_time4 = 3000;
    
    int  Start_moving_time5 = 5900;
    int  End_moving_time5 = 6000;
    
   
    int  makeTheFirstMove = 0;
    String image;

    int  moving_factor = 2;
    int  SaveTime = 1 ;
    int  doNotReprat = 1 ;
    int  score_each = 0 ;
    int  difficulty = 9985 ;
    GreenfootSound Explosion = new GreenfootSound("A_Ex.wav");
    public Alien(String P_image)
    {   
        super();
        image = P_image;

    }

    public void act() 
    {
        SaveTime();
        Move();
        MakeTheFirstMove();
        MoveRightAndLeft();
        MoveDown();
        Change_image();
        Change_image2();
        Schießen();
        RemoveIfShotAndSetScore(score_each);
        
    }
    
    public void set_difficulty(int D )
    {
        difficulty = D ;
    
    }

    public void set_StartAndEndTime(int S, int E)
    {
        Start_moving_time = S;
        End_moving_time = E;
    }

    public void set_MakeTheFirstMove(int F)
    {
        makeTheFirstMove = F ;
    }

    public void set_StartRoatition(int S , int E)
    {
        Start_moving_time2 = S;
        End_moving_time2 = E;
    }

    public void SaveTime(){
        if(SaveTime == 1 )
        {
            time_start = System.currentTimeMillis(); SaveTime++;
        }}

    public void Move()
    {
        long time_now = System.currentTimeMillis();
        if(time_now - time_start > Start_moving_time && 
        time_now - time_start < End_moving_time )

        {
            setLocation(getX() - moving_factor, getY()  );
            Start_moving_time = 1000 + Start_moving_time;
            End_moving_time = 1000 + End_moving_time;

        }

    }

    public void Change_image()
    {
        long time_now4 = System.currentTimeMillis();
        if(time_now4 - time_start > Start_moving_time4 && 
        time_now4 - time_start < End_moving_time4 )
        {
            setImage(image + "1.png" );
            Start_moving_time4 += 2000;
            End_moving_time4 += 2000;} 
    }

    public void Change_image2()
    {
        long time_now5 = System.currentTimeMillis();
        if(time_now5 - time_start > Start_moving_time5 && 
        time_now5 - time_start < End_moving_time5 )
        {
            setImage(image + ".png" );
            Start_moving_time5 += 2000;
            End_moving_time5 += 2000;} 
    }

    public void MakeTheFirstMove()
    {   if(doNotReprat == 1){
            if(Start_moving_time > makeTheFirstMove)
            {
                moving_factor = moving_factor * -1 ;
                doNotReprat++;
            }
        }
    }

    public void MoveRightAndLeft()
    {  
        long time_now2 = System.currentTimeMillis();
        if(time_now2 - time_start > Start_moving_time2 && 
        time_now2 - time_start < End_moving_time2 )
        {
            moving_factor = moving_factor * -1 ;
            Start_moving_time2 += 13000;
            End_moving_time2 += 13000;

        }

    }
    
    public void set_Score_each(int scoreEach)
    {
        score_each = scoreEach;
    }
    
    public void MoveDown()
    {
        long time_now3 = System.currentTimeMillis();
        if(time_now3 - time_start > Start_moving_time3 && 
        time_now3 - time_start < End_moving_time3 )
        {
            setLocation(getX() , getY() + 4 );
            Start_moving_time3 += 4000;
            End_moving_time3 += 4000;
            
        }
    }

    public void RemoveIfShotAndSetScore(int score)
    {
        Actor schuss = getOneIntersectingObject(Schuss.class);
        if (schuss != null) 
        {   
            Explosion.play();
            getWorldOfType(Space_invader_world.class).ChangeWave();
            getWorldOfType(Space_invader_world.class).set_score(score);
            getWorld().removeObject(schuss);
            getWorld().removeObject(this);
        }
    }
    

    public void Schießen()
    {
        if (getWorld().getObjectsAt(getX() , getY(), Alien.class) != null)
        {
            
            if (getZufall(10000) > difficulty) 
            {
                Alien_Schuss schuss = new Alien_Schuss();
                getWorld().addObject(schuss, getX() , getY());
            } 
        }   
    }

    public int getZufall(int i){

        int zufall = new java.util.Random().nextInt(i);
        return zufall;
    }
}