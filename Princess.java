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
    public static boolean canMove = false;
    
    public Princess()
    {
        for(int i = 0; i < crying.length; i++)
        {
            crying[i] = new GreenfootImage("images/Wraith_02/PNG Sequences/Hurt/Hurt" + i + ".png");
            crying[i].scale(61,88);
        }
        
        cryingTimer.mark();
        setImage(crying[0]);
    }
    
    public void animationsequence1()
    {
        while(!isAtEdge())
        {
            if(cryingTimer.millisElapsed() < 80)
            {
                return;
            }
            move(8);
            setImage(crying[imageIndex]);
            imageIndex = (imageIndex + 1) % crying.length;
            cryingTimer.mark();
        }
    }
    
    public static boolean getCanMove()
    {
        return canMove;
    }
    
    public void checkRemove()
    {
        if(isTouching(Portal.class))
        {
            MyWorld world = (MyWorld) getWorld();
            world.removeObject(this);   
            canMove = true;
        }
    }
    public void act()
    {
        animationsequence1();
        checkRemove();
    }
}
