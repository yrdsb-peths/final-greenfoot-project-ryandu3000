import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnswerBox2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnswerBox2 extends Actor
{
    public AnswerBox2()
    {
        GreenfootImage image = getImage();
        image.scale(100,60);
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            World1 world = (World1) getWorld();
            world.checkanswer(2);
        }
    }
}
