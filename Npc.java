import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Npc decoration with an animation.
 * 
 * @author Ryan Du
 * @version Jan 2023
 */
public class Npc extends Actor
{
    GreenfootImage[] attack = new GreenfootImage[12];
    int imageIndex = 0;
    SimpleTimer attackTimer = new SimpleTimer();

    /**
     * Constructor for objects of the class Npc.
     */
    public Npc()
    {
        for(int i = 0; i < attack.length; i++)
        {
            attack[i] = new GreenfootImage("images/Wraith_02/PNG Sequences/Attacking/Wraith_02_Attack_00" + i + ".png");
            attack[i].mirrorHorizontally();
            attack[i].scale(130,105);
        }
        attackTimer.mark();
        setImage(attack[0]);
    }
    
    /**
     * Does an animation in place.
     */
    public void sequence()
    {
        if(attackTimer.millisElapsed() < 150)
        {
            return;
        }
        setImage(attack[imageIndex]);
        imageIndex = (imageIndex + 1) % attack.length;
        attackTimer.mark();
    }
    
    /**
     * Act - do whatever the Npc wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        sequence();
    }
}
