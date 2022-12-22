import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wraith here.
 * 
 * @author Ryan Du
 * @version December 2022
 */
public class Wraith extends Actor
{
    GreenfootImage[] walkingRight = new GreenfootImage[12];
    GreenfootImage[] walkingLeft = new GreenfootImage[12];
    SimpleTimer animationTimer = new SimpleTimer();
    
    int imageIndex = 0;
    
    boolean isMoving = false;
    String facing = "right";
    
    public Wraith()
    {
        for(int i = 0; i < walkingRight.length; i++)
        {
            walkingRight[i] = new GreenfootImage("images/Wraith_01/Sequences/Walking/Forward" + i + ".png");
            walkingRight[i].scale(130,105);
        }
        
        for(int i = 0; i < walkingLeft.length; i++)
        {
            walkingLeft[i] = new GreenfootImage("images/Wraith_01/Sequences/Walking/Forward" + i + ".png");
            walkingLeft[i].mirrorHorizontally();
            walkingLeft[i].scale(130,105);
        }
        
        animationTimer.mark();
        
        // Set initial image
        setImage(walkingRight[0]);
    }
    
    public void animateWraith()
    {
        if(animationTimer.millisElapsed() < 80)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(walkingRight[imageIndex]);
            imageIndex = (imageIndex + 1) % walkingRight.length;
        }
        else
        {
            setImage(walkingLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % walkingLeft.length;
        }
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            facing = "left";
            move(-1);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            facing = "right";
            move(1);
        }
        
        animateWraith();
    }
}
