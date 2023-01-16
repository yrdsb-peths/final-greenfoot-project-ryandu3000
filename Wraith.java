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
    GreenfootImage[] dodgingRight = new GreenfootImage[13];
    GreenfootImage[] dodgingLeft = new GreenfootImage[13];
    
    int imageIndex = 0;
    SimpleTimer walkingTimer = new SimpleTimer();
    SimpleTimer dodgingTimer = new SimpleTimer();
    String facing = "right";
    private int speed = 2;
    private int vSpeed = 0;
    private int acceleration = 2;
    public Wraith()
    {
        for(int i = 0; i < walkingRight.length; i++)
        {
            walkingRight[i] = new GreenfootImage("images/Wraith_01/Sequences/Walking/Forward" + i + ".png");
            walkingRight[i].scale(61,88);
        }
        
        for(int i = 0; i < walkingLeft.length; i++)
        {
            walkingLeft[i] = new GreenfootImage("images/Wraith_01/Sequences/Walking/Forward" + i + ".png");
            walkingLeft[i].mirrorHorizontally();
            walkingLeft[i].scale(61,88);
        }
        
        for(int i = 0; i < dodgingRight.length; i++)
        {
            dodgingRight[i] = new GreenfootImage("images/Wraith_01/Sequences/Dying/Dying" + i + ".png");
            dodgingRight[i].scale(105,130);
        }
        
        for(int i = 0; i < dodgingLeft.length; i++)
        {
            dodgingLeft[i] = new GreenfootImage("images/Wraith_01/Sequences/Dying/Dying" + i + ".png");
            dodgingLeft[i].mirrorHorizontally();
            dodgingLeft[i].scale(67,97);
        }
        
        walkingTimer.mark();
        
        // Set initial image
        setImage(walkingRight[0]);
    }
    
    public void animateWraith()
    {
        if(walkingTimer.millisElapsed() < 80)
        {
            return;
        }
        walkingTimer.mark();
    
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
    
    public void fall()
    {
        setLocation(getX(),getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
    }
    
    public boolean onGround()
    {
        return getY() == 370;
    }

    public void checkFall()
    {
        if(onGround())
        {
            vSpeed = 0;
        }
        else
        {
            fall();
        }
    }
    
    public void checkKeys()
    {
        if(Greenfoot.isKeyDown("left") && Princess.getCanMove() == true)
        {
            facing = "left";
            setLocation(getX() - speed, getY());
        }
        else if(Greenfoot.isKeyDown("right") && Princess.getCanMove() == true)
        {
            facing = "right";
            setLocation(getX() + speed, getY());
        }
        if(Greenfoot.isKeyDown("up") && Princess.getCanMove() == true && onGround())
        {
            vSpeed = -20;
            fall();
        }
        //elif(Greenfoot.isKeyDown("down") && Princess.getCanMove() == true)
        //{
            
        //}
    }
    public void act()
    {
        checkFall();
        checkKeys();
        animateWraith(); 
        MyWorld world = (MyWorld) getWorld();
        if(isAtEdge() && getX() > 20)
        {
            world.switchWorld1();
        }
    }
}
