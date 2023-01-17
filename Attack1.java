import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Attack1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Attack1 extends Actor
{
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
        int x = getX() - 1;
        int y = getY();
        setLocation(x,y);
        
        if(isTouching(Wraith.class))
        {
            removeTouching((Wraith.class));
        }
        
    }
}
