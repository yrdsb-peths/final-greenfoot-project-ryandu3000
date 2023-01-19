import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title screen for our game.
 * 
 * @author Ryan Du
 * @version Jan 2023
 */
public class TitleScreen extends World
{
    // Labels
    Label label1 = new Label("Wraith Math",100);
    Label label2 = new Label("space \u2192", 30);
    
    WraithDeco wraithDeco = new WraithDeco();
    InsulterDeco insulterDeco = new InsulterDeco();
    
    //Sounds
    GreenfootSound backgroundMusic = new GreenfootSound("intro.mp3");
    /**
     * Constructor for objects of class TitleScreen.
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 
        
        // Adds the objects onto the world
        addObject(label1, getWidth()/2, 80);
        addObject(label2, 725, 425);
        addObject(wraithDeco,300,324);
        addObject(insulterDeco,544,324);
    }

    /**
     * Do whatever the world wants to do. This method is called whenever
     * the 'Act'or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        backgroundMusic.playLoop();
        
        // Whenever space is pressed changes the world to InstructionPage.
        if(Greenfoot.isKeyDown("space"))
        {
            InstructionPage instruction = new InstructionPage();
            Greenfoot.setWorld(instruction);
            backgroundMusic.stop();
        }
    }
}
