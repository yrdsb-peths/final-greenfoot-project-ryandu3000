import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Wraith that does math.
 * 
 * @author Ryan Du
 * @version December 2022
 */
public class Wraith extends Actor
{
    // image arrays
    GreenfootImage[] walkingRight = new GreenfootImage[12];
    GreenfootImage[] walkingLeft = new GreenfootImage[12];
    
    // variables
    int imageIndex = 0;
    SimpleTimer walkingTimer = new SimpleTimer();
    SimpleTimer fallingTimer = new SimpleTimer();
    String facing = "right";
    private int speed = 2;
    private int vSpeed = 0;
    private int acceleration = 2;
    private boolean Switch = true;
    
    /**
     * Constructor for objects of class Wraith.
     */
    public Wraith()
    {
        // Puts the images into the array
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
    
    /**
     * Animation for the wraith.
     */
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
    
    /**
     * Drops the wraith down.
     */
    public void fall()
    {
        setLocation(getX(),getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
    }
    
    /**
     * Checks if the wraith is on the ground.
     */
    public boolean onGround()
    {
        return getY() == 370;
    }

    /**
     * Makes our wraith fall when it's not on the ground.
     */
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
    
    /**
     * Moves the wraith if the key is pressed and other conditions are met.
     */
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
    
    /**
     * Turns the variable switch to true when added to class Myworld.
     */
    public void addedToMyWorld()
    {
        MyWorld world = (MyWorld) getWorld();
        Switch = true;
    }
    
    /**
     * Turns the variable switch to false when added to class World1.
     */
    public void addedToWorld1()
    {
        World1 world = (World1) getWorld();
        Switch = false;
    }
    
    /**
     * Act - do whatever the wraith wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkFall();
        checkMovement();
        animateWraith();
        
        // When its at the edge calls the class switchGame
        if(Switch && isAtEdge() && getX() > 200)
        {
            MyWorld world = (MyWorld) getWorld();
            world.switchGame();
        }
    }
}

