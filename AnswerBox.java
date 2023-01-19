import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Box where the first answer goes.
 * 
 * @author Ryan Du
 * @version Jan 2023
 */
public class AnswerBox extends Actor
{
    /**
     * Constructor for objects of class AnswerBox.
     * 
     */
    public AnswerBox()
    {
        GreenfootImage image = getImage();
        image.scale(100,60);
    }
    
    /**
     * Act - do whatever the AnswerBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // If clicked by the mouse calls the checkanswer method with an argument of 0.
        if(Greenfoot.mouseClicked(this))
        {
            World1 world = (World1) getWorld();
            world.checkanswer(0);
        }
    }
}