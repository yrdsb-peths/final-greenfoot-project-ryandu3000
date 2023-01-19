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
    GreenfootSound backgroundMusic = new GreenfootSound("introSceneBackground.mp3");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 960x540 cells with a cell size of 1x1 pixels.
        super(800, 450, 1);
        
        // Adds the objects to the game.
        addObject(wraith, 50, 370);
        addObject(npc, 120, 370);
        
        delay.mark();
        backgroundMusic.playLoop();
        backgroundMusic.setVolume(60);
    }
    
    /**
     * Changes the world to World1.
     */
    public void switchGame()
    {
        backgroundMusic.stop();
        World1 game = new World1();
        Greenfoot.setWorld(game);
    }
    
    /**
     * Do whatever the world wants to do. This method is called whenever
     * the 'Act'or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Adds a label after 0.5 seconds have passed.
        if(delay.millisElapsed() > 500)
        {
            addObject(label,getWidth()/2,200);
        }
        // After 4 seconds have passed changes the label into an empty string.
        if(delay.millisElapsed() > 4000)
        {
            label.setValue("");
        }
    }
}
