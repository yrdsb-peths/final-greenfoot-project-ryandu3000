import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameOver extends World
{
    Label label = new Label("GAME OVER!",100);
    Label label2 = new Label("Play Again?   Leave?", 50);
    Label label3 = new Label("[press space]        [press enter]", 30);
    

    /**
     * Constructor for objects of class gameOver.
     * 
     */
    public gameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 450, 1);
        label.setLineColor(Color.WHITE);
        label2.setLineColor(Color.WHITE);
        label3.setLineColor(Color.WHITE);
        addObject(label2, 570, 356);
        addObject(label3, 600, 400);
        addObject(label, getWidth()/2, 100);
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        CryingWraithDeco cryingWraithDeco = new CryingWraithDeco();
        addObject(cryingWraithDeco,248,368);
        cryingWraithDeco.setLocation(300,336);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
        else if(Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.stop();
        }
    }
}
