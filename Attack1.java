import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Attack1 here.
 * 
 * @author Ryan Du
 * @version (a version number or a date)
 */
public class Attack1 extends Actor
{
    int speed = 1;
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
        int x = getX() - speed;
        int y = getY();
        setLocation(x,y);
        
        if(isTouching(Wraith.class))
        {
            World1 world = (World1) getWorld();
            removeTouching((Wraith.class));
            world.gameOver();
        }
        
         if(Greenfoot.mouseClicked(this))
        {
            World1 world = (World1) getWorld();
            world.checkanswer(0);
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
