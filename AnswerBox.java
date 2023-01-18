import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnswerBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnswerBox extends Actor
{
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
        if(Greenfoot.mouseClicked(this))
        {
            World1 world = (World1) getWorld();
            world.checkanswer(0);
        }
    }
}
