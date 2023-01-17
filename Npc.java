import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Npc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Npc extends Actor
{
    GreenfootImage[] attack = new GreenfootImage[12];
    int imageIndex = 0;
    SimpleTimer attackTimer = new SimpleTimer();
    int speed = 200;
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
    
    public void sequence()
    {
        if(attackTimer.millisElapsed() < speed)
        {
            return;
        }
        setImage(attack[imageIndex]);
        imageIndex = (imageIndex + 1) % attack.length;
        attackTimer.mark();
    }
    public void act()
    {
        sequence();
    }
}
