import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse Space_invader_world.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Space_invader_world extends World
{

    /**
     * Konstruktor für Objekte der Klasse Space_invader_world
     * 
     */
    public Space_invader_world()
    {    
        // Erstellt eine neue Welt mit 600x400 Zellen und einer Zell-Größe von 1x1 Pixeln.
        super(100, 80, 8); 
        Spaceship spaceship = new Spaceship();
        addObject(spaceship, 50, 70);
        Add_Aliens();
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
}