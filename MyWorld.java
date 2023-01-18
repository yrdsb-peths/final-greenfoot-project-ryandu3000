import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Ryan Du
 * @version Jan 2023
 */
public class MyWorld extends World
{
    // Variables 
    int level = 2;
    
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
        
        // Adds the sprites to the game
        Wraith wraith = new Wraith();
        addObject(wraith, 50, 370);
        Thief npc = new Thief();
        addObject(npc, 120, 370);
        
        //backgroundMusic.playLoop();
    }
}
