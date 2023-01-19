import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the instruction page that tells the user how to play
 * 
 * @author Ryan Du
 * @version Jan 2023
 */
public class InstructionPage extends World
{
    // Labels 
    Label label1 = new Label("Instructions", 90);
    Label label2 = new Label("You just got told your bad at math, follow",30);
    Label label3 = new Label("them to prove them wrong!",30);
    Label label4 = new Label("Click the correct answers to the question!", 30);
    Label label5 = new Label("Use \u2190 \u2192 to move!", 30);
    Label label6 = new Label("Press  [space]  to  Start", 30);
    
    SimpleTimer delay = new SimpleTimer();
    /**
     * Constructor for objects of class InstructionPage.
     */
    public InstructionPage()
    {   
        // Create a new world with 800x450 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 
        
        // Adds  all the objects onto the screen
        WraithDeco wraithDeco = new WraithDeco();
        addObject(wraithDeco,166,280);
        addObject(label1,getWidth()/2,60);
        addObject(label2,500,150);
        addObject(label3,422,180);
        addObject(label4, 507, 230);
        addObject(label5, 373, 260);
        addObject(label6, 650,400);
        
        delay.mark();
    }
    
    /**
     * Do whatever the world wants to do. This method is called whenever
     * the 'Act'or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Whenever space is pressed change the world to MyWorld.
        if(Greenfoot.isKeyDown("space") && delay.millisElapsed() > 500)
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
