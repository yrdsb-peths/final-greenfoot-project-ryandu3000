import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionPage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionPage extends World
{
    Label label1 = new Label("Instructions", 90);
    Label label2 = new Label("A thief just stole your money, follow them to",30);
    Label label3 = new Label("get it back!",30);
    Label label4 = new Label("Dodge the cannons for as long as possible!", 30);
    Label label5 = new Label("Use \u2190 \u2192 to move and \u2191 to jump!", 30);
    Label label6 = new Label("Press  <space>  to  Start", 30);
    public InstructionPage()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 
        WraithDeco wraithDeco = new WraithDeco();
        addObject(wraithDeco,166,280);
        addObject(label1,getWidth()/2,60);
        addObject(label2,520,150);
        addObject(label3,337,180);
        addObject(label4, 517, 230);
        addObject(label5, 450, 260);
        addObject(label6, 650,428);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
