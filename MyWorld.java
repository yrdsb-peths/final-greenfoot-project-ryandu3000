import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 960x540 cells with a cell size of 1x1 pixels.
        super(800, 450, 1);
        Wraith wraith = new Wraith();
        addObject(wraith, 50, 370);
        
        Princess npc = new Princess();
        addObject(npc, 120, 370);
    }
    
    public void switchWorld1()
    {
        World1 gameWorld = new World1();
        Greenfoot.setWorld(gameWorld);
    }
}
