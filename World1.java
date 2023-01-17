import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World1 here.
 * 
 * @author Ryan Du
 * @version Jan 2023
 */
public class World1 extends World
{
    // Sounds
    GreenfootSound backgroundMusic = new GreenfootSound("background.mp3");
    /**
     * Constructor for objects of class World1.
     * 
     */
    public World1()
    {    
        // Create a new world with 800x450 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 
        Wraith wraith = new Wraith();
        addObject(wraith, 50, 370);
        Npc npc = new Npc();
        addObject(npc, 760, 370);
        backgroundMusic.playLoop();
    }
}
