import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Rocket that ends the game.
 * 
 * @author Ryan Du
 * @version Jan 2023
 */
public class Attack1 extends Actor
{
    // intial speed
    int speed = 1;
    /**
     * Constructor for the objects of class Attack1.
     */
    public Attack1()
    {
        GreenfootImage image = getImage();
        image.scale(62,40);
    }
    
    /**
     * Act - do whatever the Attack1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // moves the rocket left
        int x = getX() - speed;
        int y = getY();
        setLocation(x,y);
        
        // If it touches the wraith calls the gameOver method.
        if(isTouching(Wraith.class))
        {
            World1 world = (World1) getWorld();
            removeTouching((Wraith.class));
            world.gameOver();
        }
    }
    
    /**
     * Changes the speed of the rocket.
     */
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
