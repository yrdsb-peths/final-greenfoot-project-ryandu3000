import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World1 here.
 * 
 * @author Ryan Du
 * @version Jan 2023
 */
public class World1 extends World
{
    // Sounds
    GreenfootSound backgroundMusic = new GreenfootSound("background.mp3");

    int score = 0;
    int level = 1;
    Label scoreLabel = new Label(score,20);
    /**
     * Constructor for objects of class World1.
     * 
     */
    public World1()
    {    
        // Create a new world with 800x450 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 
        Wraith wraith = new Wraith();
        addObject(wraith, 50, 370);
        Npc npc = new Npc();
        addObject(npc, 760, 370);
        createRocket();
        Box box = new Box();
        addObject(box, getWidth()/2,120);
        createQuestion();
        prepare();
    }

    public void createRocket()
    {
        Attack1 rocket = new Attack1();
        int x = 690;
        int y = 340;
        addObject(rocket,x,y);
    }

    public void act()
    {
        backgroundMusic.playLoop();
    }

    public void createQuestion()
    {
        int x1 = Greenfoot.getRandomNumber(100);
        int y1 = Greenfoot.getRandomNumber(100);
        Label question = new Label(x1 + " + " + y1 + " = ",50);
        addObject(question, getWidth()/2,120);
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        AnswerBox answerBox = new AnswerBox();
        addObject(answerBox,706,86);
        answerBox.setLocation(648,65);
        AnswerBox answerBox2 = new AnswerBox();
        addObject(answerBox2,653,168);
        answerBox.setLocation(542,88);
        answerBox.setLocation(542,46);
        answerBox2.setLocation(697,55);
        AnswerBox answerBox3 = new AnswerBox();
        addObject(answerBox3,528,156);
        AnswerBox answerBox4 = new AnswerBox();
        addObject(answerBox4,714,152);
        answerBox4.setLocation(696,154);
    }
}
