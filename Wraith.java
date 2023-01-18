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
    
    int imageIndex = 0;
    SimpleTimer walkingTimer = new SimpleTimer();
    SimpleTimer fallingTimer = new SimpleTimer();
    String facing = "right";
    private int speed = 2;
    private int vSpeed = 0;
    private int acceleration = 2;
    private boolean Switch = true;
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
        
        walkingTimer.mark();
        
        // Set initial image
        setImage(walkingRight[0]);
    }
    
    public void animateWraith()
    {
        if(walkingTimer.millisElapsed() < 90)
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
    
    public void checkMovement()
    {
        if(Greenfoot.isKeyDown("left") && Insulter.getCanMove() == true)
        {
            facing = "left";
            setLocation(getX() - speed, getY());
        }
        else if(Greenfoot.isKeyDown("right") && Insulter.getCanMove() == true)
        {
            facing = "right";
            setLocation(getX() + speed, getY());
        }
        if(Greenfoot.isKeyDown("up") && Insulter.getCanMove() == true && onGround())
        {
            vSpeed = -25;
            fall();
        }
    }
    public void addedToMyWorld()
    {
        MyWorld world = (MyWorld) getWorld();
        Switch = true;
    }
    
    public void addedToWorld1()
    {
        World1 world = (World1) getWorld();
        Switch = false;
    }
    
    public void act()
    {
        checkFall();
        checkMovement();
        animateWraith();
        if(Switch && isAtEdge() && getX() > 200)
        {
            World1 gameArea = new World1();
            Greenfoot.setWorld((gameArea));
        }
    }
}

