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
        putInLocation();
        createRocket();
        createQuestion();
    }
    
    public void putInLocation()
    {
        Wraith wraith = new Wraith();
        addObject(wraith,30,370);
        Npc npc = new Npc();
        addObject(npc, 760, 370);
        Box box = new Box();
        addObject(box, 280,120);
        AnswerBox answerBox = new AnswerBox();
        addObject(answerBox,550,75);
        AnswerBox answerBox2 = new AnswerBox();
        addObject(answerBox2,550,168);
        AnswerBox answerBox3 = new AnswerBox();
        addObject(answerBox3,720,75);
        AnswerBox answerBox4 = new AnswerBox();
        addObject(answerBox4,720,168);
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
        addObject(question, 280,120);
        int answer = x1 +y1;
        int rand = Greenfoot.getRandomNumber(3);
        if(rand == 0)
        {
            Label answer1 = new Label(answer,25);
            Label answer2 = new Label(answer + Greenfoot.getRandomNumber(10),25);
            Label answer3 = new Label(answer - Greenfoot.getRandomNumber(10),25);
            Label answer4 = new Label(answer + Greenfoot.getRandomNumber(100),25);
            addObject(answer1, 550,75);
            addObject(answer2, 550,168);
            addObject(answer3, 720,75);
            addObject(answer4, 720,168);
        }
        else if(rand == 1)
        {
            Label answer2 = new Label(answer,25);
            Label answer1 = new Label(answer + Greenfoot.getRandomNumber(10),25);
            Label answer3 = new Label(answer - Greenfoot.getRandomNumber(10),25);
            Label answer4 = new Label(answer + Greenfoot.getRandomNumber(100),25);
            addObject(answer1, 550,75);
            addObject(answer2, 550,168);
            addObject(answer3, 720,75);
            addObject(answer4, 720,168);
        }
        else if(rand == 2)
        {
            System.out.println("hi");
            Label answer3 = new Label(answer,25);
            Label answer1 = new Label(answer + Greenfoot.getRandomNumber(100),25);
            Label answer2 = new Label(answer + Greenfoot.getRandomNumber(10),25);
            Label answer4 = new Label(answer - Greenfoot.getRandomNumber(10),25);
            addObject(answer1, 550,75);
            addObject(answer2, 550,168);
            addObject(answer3, 720,75);
            addObject(answer4, 720,168);
        }
        else
        {
            Label answer4 = new Label(answer,25);
            Label answer1 = new Label(answer + Greenfoot.getRandomNumber(5),25);
            Label answer2 = new Label(answer + Greenfoot.getRandomNumber(10),25);
            Label answer3 = new Label(answer - Greenfoot.getRandomNumber(10),25);
            addObject(answer1, 550,75);
            addObject(answer2, 550,168);
            addObject(answer3, 720,75);
            addObject(answer4, 720,168);
        }
    }
}
