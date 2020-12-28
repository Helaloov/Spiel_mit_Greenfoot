import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse Space_invader_world.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Space_invader_world extends World
{
    int leben = 3 ; 
    int wave = 0;
    int help_wave = 1;
    int score = 0 ;
    

    public Space_invader_world()
    {    
        // Erstellt eine neue Welt mit 600x400 Zellen und einer Zell-Größe von 1x1 Pixeln.
        super(100, 80, 8); 
        Add_SpaceShip();
        Add_Aliens();
        Add_ExtraLifes();
        getBackground().setFont(new Font(30));
        getBackground().drawString("Score: " + score , 620, 618);
    }

    public void act()
    {
        gameOver();
        Add_new_wave();
        Add_new_wave2();
        checkForExtraLifes();
        Add_AlienBonus();
        view_score();
        IfWin();
        
    }

    public void Add_SpaceShip()
    {
        Spaceship spaceship = new Spaceship();
        addObject(spaceship, 50, 70);
    }

    public void Add_Aliens() {

        for(int i = 20 ; i < 84; i += 7)
        {

            Alien1 alien1 = new Alien1();
            alien1.set_StartAndEndTime(1500,1600);
            alien1.set_MakeTheFirstMove(8500);
            alien1.set_StartRoatition(21500, 21600);
            addObject(alien1, i, 10);

            Alien2 alien2 = new Alien2();
            alien2.set_StartAndEndTime(1250,1350);
            alien2.set_MakeTheFirstMove(8250);
            alien2.set_StartRoatition(21250, 21350);
            addObject(alien2, i, 17);

            Alien2 alien3 = new Alien2();
            alien3.set_StartAndEndTime(1000,1100);
            alien3.set_MakeTheFirstMove(8000);
            alien3.set_StartRoatition(21000, 21100);
            addObject(alien3, i, 24);

            Alien3 alien4 = new Alien3();
            alien4.set_StartAndEndTime(750,8500);
            alien4.set_MakeTheFirstMove(7750);
            alien4.set_StartRoatition(20750, 20850);
            addObject(alien4, i, 31);

            Alien3 alien5 = new Alien3();
            alien5.set_StartAndEndTime(500,600);
            alien5.set_MakeTheFirstMove(7500);
            alien5.set_StartRoatition(20500, 20600);
            addObject(alien5, i, 38);

    
        }
    }

    public void Add_ExtraLifes()
    {

        for (int i =3 ; i < 12 ; i += 4)
        {
            New_life new_life = new New_life();
            addObject(new_life, i , 77);
        }
    }

    public void checkForExtraLifes()
    {
        if(leben == 2)
        {   
            removeObjects(getObjects(New_life.class));
            for (int i =3 ; i < 8 ; i += 4)
            {
                New_life new_life = new New_life();
                addObject(new_life, i , 77);
            }
        }
        
        else
        {
            if(leben == 1)
            {   
                removeObjects(getObjects(New_life.class));

                New_life new_life = new New_life();
                addObject(new_life, 3 , 77);

            }
        }
        
        if(leben == 0)
        {   
            removeObjects(getObjects(New_life.class));
        }
    }

    public void  Add_new_wave()
    {
        
        
        if(wave == 50 && help_wave == 1)
        {
            getBackground().setFont(new Font(70));
            getBackground().drawString("WAVE 2", 300, 300 );
            removeObjects(getObjects(Alien_Bonus.class));
            Greenfoot.delay(60);
            Add_Aliens();
            help_wave++;
        }

    }

    public void  Add_new_wave2()
    {
        if(wave == 100 && help_wave == 2)
        {
            getBackground().setFont(new Font(70));
            getBackground().drawString("LAST WAVE", 200, 300 );
            removeObjects(getObjects(Alien_Bonus.class));
            Greenfoot.delay(60);
            Add_Aliens();
            help_wave++;
        }

    }

    public void ChangeLeben()
    {
        leben--;
    }

    public void ChangeWave()
    {
        wave++;
    }

    public void gameOver()
    {
        if(leben < 0)
        {
            removeObjects(getObjects(Alien.class));
            removeObjects(getObjects(Alien_Schuss.class));
            removeObjects(getObjects(Spaceship.class));
            removeObjects(getObjects(Schuss.class));
            removeObjects(getObjects(Alien_Schuss.class));
            Greenfoot.stop();
            getBackground().setFont(new Font(50));
            getBackground().drawString("Game over :( \n Your score \n       is " + score, 250, 250);
            
            
        }
        
        
    }
    
    public int getZufall(int i){
        
       int zufall = new java.util.Random().nextInt(i);
       return zufall;
    }
    
    public void Add_AlienBonus()
    {
        if(getZufall(100000)>99900)
        {
            Alien_Bonus alien_Bonus = new Alien_Bonus();
            addObject(alien_Bonus, 1, 5);
        }
    
    }
    
    public void set_score(int S)
    {
        score += S;
    }
    
    public void view_score()
    {
         if(leben >= 0) 
         {
         setBackground("space1.jpg");
         getBackground().setFont(new Font(30));
         getBackground().drawString("Score: " + score , 620, 618);
        }
    }
    
    public void IfWin()
    {
        if(wave == 150)
        {
            removeObjects(getObjects(Alien.class));
            removeObjects(getObjects(Alien_Schuss.class));
            removeObjects(getObjects(Spaceship.class));
            removeObjects(getObjects(Schuss.class));
            removeObjects(getObjects(Alien_Schuss.class));
            Greenfoot.stop();
            getBackground().setFont(new Font(50));
            getBackground().drawString(" You Win :) \n Your score \n  is " + score, 250, 250);
        }
    }

}