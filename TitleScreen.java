import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title screen for our game.
 * 
 * @author Ryan Du
 * @version Jan 2023
 */
public class TitleScreen extends World
{
    // Label
    Label label1 = new Label("Wraith Chaser",100);
    
    //Sounds
    GreenfootSound backgroundMusic = new GreenfootSound("intro.mp3");
    /**
     * Constructor for objects of class TitleScreen.
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 
        
        // Adds the label and deoration onto the world
        addObject(label1, getWidth()/2, 100);
        WraithDeco wraithDeco = new WraithDeco();
        ThiefDeco thiefDeco = new ThiefDeco();
        addObject(wraithDeco,300,344);
        addObject(thiefDeco,544,344);
        backgroundMusic.playLoop();
    }

    /**
     * Do whatever the world wants to do. This method is called whenever
     * the 'Act'or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Whenever space is pressed changes the world to InstructionPage.
        if(Greenfoot.isKeyDown("space"))
        {
            InstructionPage instruction = new InstructionPage();
            Greenfoot.setWorld(instruction);
            backgroundMusic.stop();
        }
    }
}
