import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sprite who insults the wraith.
 * 
 * @author Ryan Du
 * @version Jan 2023
 */
public class Insulter extends Actor
{
    // variables
    GreenfootImage[] crying = new GreenfootImage[12];
    int imageIndex = 0;
    SimpleTimer cryingTimer = new SimpleTimer();
    public static boolean canMove = false;
    /**
     * Constructor for the objects of class Insulter.
     */
    public Insulter()
    {
        for(int i = 0; i < crying.length; i++)
        {
            crying[i] = new GreenfootImage("images/Wraith_02/PNG Sequences/Hurt/Hurt" + i + ".png");
            crying[i].scale(130,105);
        }
        
        cryingTimer.mark();
        setImage(crying[0]);
    }
    
    /**
     * Runs to the end of the world.
     */
    public void animationsequence1()
    {
        while(isAtEdge() == false)
        {
            if(cryingTimer.millisElapsed() < 90)
            {
                return;
            }
            move(8);
            setImage(crying[imageIndex]);
            imageIndex = (imageIndex + 1) % crying.length;
            cryingTimer.mark();
        }
    }
    
    /**
     * returns the boolean value of canMove;
     */
    public static boolean getCanMove()
    {
        return canMove;
    }
    
    /**
     * Does the animation sequence when added to MyWorld.
     */
    public void addedToMyWorld()
    {
        MyWorld world = (MyWorld) getWorld();
        animationsequence1();
    }
    
    /**
     * Act - do whatever the Insulter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        animationsequence1();
        // removes the object when it touches the edge of the world.
        if(isAtEdge())
        {
            world.removeObject(this);   
            canMove = true;
        }
    }
}
