import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Princess here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Princess extends Actor
{
    GreenfootImage[] crying = new GreenfootImage[12];
    int imageIndex = 0;
    SimpleTimer cryingTimer = new SimpleTimer();
    
    public Princess()
    {
        for(int i = 0; i < crying.length; i++)
        {
            crying[i] = new GreenfootImage("images/Wraith_02/PNG Sequences/Hurt/Wraith_02_Hurt_00" + i + ".png");
        }
        
        cryingTimer.mark();
        setImage(crying[0]);
    }
    
    public void act()
    {
        if(cryingTimer.millisElapsed() < 80)
        {
            return;
        }
    }
}
