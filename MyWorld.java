import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Intro scene to the game.
 * 
 * @author Ryan Du
 * @version Jan 2023
 */
public class MyWorld extends World
{
    // Variables 
    Label label = new Label("Hahahaha ur bad at math!",30);
    SimpleTimer delay = new SimpleTimer();
    Wraith wraith = new Wraith();
    Insulter npc = new Insulter();
    
    //Sounds 
    //GreenfootSound backgroundMusic = new GreenfootSound
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 960x540 cells with a cell size of 1x1 pixels.
        super(800, 450, 1);
        
        // Adds the objects to the game
        addObject(wraith, 50, 370);
        addObject(npc, 120, 370);
        
        delay.mark();
        //backgroundMusic.playLoop();
    }
    
    public void act()
    {
        if(delay.millisElapsed() > 500)
        {
            addObject(label,getWidth()/2,200);
        }
        if(delay.millisElapsed() > 4000)
        {
            label.setValue("");
        }
    }
}
