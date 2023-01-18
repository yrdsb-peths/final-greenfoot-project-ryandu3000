import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ending screen for my game.
 * 
 * @author Ryan Du 
 * @version Jan 2023
 */
public class gameOver extends World
{
    // Labels
    Label label = new Label("GAME OVER!",100);
    Label label2 = new Label("Play Again?   Leave?", 50);
    Label label3 = new Label("[press space]        [press enter]", 30);
    
    CryingWraithDeco cryingWraithDeco = new CryingWraithDeco();
    /**
     * Constructor for objects of class gameOver.
     * 
     */
    public gameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 450, 1);
        
        // Changing the label colors
        label.setLineColor(Color.WHITE);
        label2.setLineColor(Color.WHITE);
        label3.setLineColor(Color.WHITE);
        
        // Adding the objects to the world
        addObject(label2, 570, 356);
        addObject(label3, 600, 400);
        addObject(label, getWidth()/2, 100);
        addObject(cryingWraithDeco,280,328);
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
