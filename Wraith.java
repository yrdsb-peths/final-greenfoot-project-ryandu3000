import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wraith here.
 * 
 * @author Ryan Du
 * @version December 2022
 */
public class Wraith extends Actor
{
    GreenfootImage[] idle = new GreenfootImage[12];
    
    public Wraith()
    {
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/Wraith_01/Sequences/Idle/Idle" + i + ".png");
            idle[i].scale(65,53);
        }
        setImage(idle[0]);
    }
    
    int imageIndex = 0;
    public void animateWraith()
    {
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(2);
        }
        
        animateWraith();
    }
}
