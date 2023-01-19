import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Main game world.
 * 
 * @author Ryan Du
 * @version Jan 2023
 */
public class World1 extends World
{
    // Sounds
    GreenfootSound backgroundMusic = new GreenfootSound("background.mp3");
    GreenfootSound correct = new GreenfootSound("correct.mp3");
    GreenfootSound wrong = new GreenfootSound("wrong.mp3");
    
    // Variables
    int score = 0;
    int level = 1;
    int answer = 0;
    int rand = 0;
    
    // Labels
    Label scoreLabel = new Label(score,40);
    Label question = new Label("",50);
    Label answer1 = new Label("",20);
    Label answer2 = new Label("",20);
    Label answer3 = new Label("",20);
    Label answer4 = new Label("",20);
    
    //Objects
    Wraith wraith = new Wraith();
    Npc npc = new Npc();
    Box box = new Box();
    AnswerBox answerBox = new AnswerBox();
    AnswerBox2 answerBox2 = new AnswerBox2();
    AnswerBox3 answerBox3 = new AnswerBox3();
    AnswerBox4 answerBox4 = new AnswerBox4();
    /**
     * Constructor for objects of class InstructionPage.
     */
    public World1()
    {    
        // Create a new world with 800x450 cells with a cell size of 1x1 pixels.
        super(800, 450, 1);
        
        // Adds objects onto the screen
        addObject(wraith,30,370);
        addObject(npc, 760, 370);
        addObject(box, 280,120);
        addObject(answerBox,550,75);
        addObject(answerBox2,550,168);
        addObject(answerBox3,720,75);
        addObject(answerBox4,720,168);
        addObject(scoreLabel,20,20);
        
        // Changing the colors of the labels
        question.setFillColor(Color.BLACK);
        answer1.setFillColor(Color.BLACK);
        answer2.setFillColor(Color.BLACK);
        answer3.setFillColor(Color.BLACK);
        answer4.setFillColor(Color.BLACK);
        scoreLabel.setFillColor(Color.BLACK);
        
        // Creates a rocket and creates an addition question
        createRocket();
        createQuestionAdd();
        
        // Changes volume
        correct.setVolume(60);
        wrong.setVolume(100);
        backgroundMusic.setVolume(70);
    }
    
    /**
     * This method switches the world to the end screen and stops the music.
     */
    public void gameOver()
    {
        backgroundMusic.stop();
        gameOver endscreen = new gameOver();
        Greenfoot.setWorld(endscreen);
    }
    
    /**
     * This method checks if the answer is correct. If it is it will 
     * create another question and if not it will end the game.
     */
    public void checkanswer(int check)
    { 
        if(check == rand)
        {
            correct.play();
            score ++;
            scoreLabel.setValue(score);
            if(score % 10 == 0)
            {
                level ++;
            }
            deleteQuestion();
            if(level >= 2)
            {
                int max = 2;
                int min = 0;
                int range = max - min + 1;
                int random = (int)(Math.random() * range) + min;
                if(random == 0)
                {
                    createQuestionAdd();
                }
                else if(random == 1)
                {
                    createQuestionMultiply();
                }
                else
                {
                    createQuestionSubtract();
                }
            }
            else
            {
                createQuestionAdd();
            }
            removeObjects(getObjects(Attack1.class));
            createRocket();
        }
        else
        {
            wrong.play();
            gameOver();
        }
    }
    
    /**
     * Sets the value of the labels in the answer boxes to an empty string.
     */
    public void deleteQuestion()
    {
        answer1.setValue("");
        answer2.setValue("");
        answer3.setValue("");
        answer4.setValue("");

    }
    
    /**
     * Creates a rocket with a speed of the level.
     */
    public void createRocket()
    {
        Attack1 rocket = new Attack1();
        if(level < 4)
        {
            rocket.setSpeed(level);
        }
        else
        {
            rocket.setSpeed(4);
        }
        int x = 690;
        int y = 340;
        addObject(rocket,x,y);
    }
    
    /**
     * Act - do whatever the wraith wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        backgroundMusic.playLoop();
        MouseInfo mouse = Greenfoot.getMouseInfo();
    }

    /**
     * Creates a multiplication question with numbers ranging from 0 to 14.
     */
    public void createQuestionMultiply()
    {
        int x1 = Greenfoot.getRandomNumber(14);
        int y1 = Greenfoot.getRandomNumber(14);
        question.setValue(x1 + " x " + y1 + " = ");
        addObject(question, 280, 120);
        answer = x1 * y1;
        putAnswerBoxes();
    }
    
    /**
     * Creates a subtraction question with numbers ranging from 0 to 50.
     */
    public void createQuestionSubtract()
    {
        int x1 = Greenfoot.getRandomNumber(50);
        int y1 = Greenfoot.getRandomNumber(50);
        question.setValue(x1 + " - " + y1 + " = ");
        addObject(question, 280,120);
        answer = x1 - y1;
        putAnswerBoxes();
    }
    
    /**
     * Creates an addition question with numbers ranging from 0 to 100.
     */
    public void createQuestionAdd()
    {
        int x1 = Greenfoot.getRandomNumber(100);
        int y1 = Greenfoot.getRandomNumber(100);
        question.setValue(x1 + " + " + y1 + " = ");
        addObject(question, 280,120);
        answer = x1 +y1;
        putAnswerBoxes();
    }
    
    /**
     * Places the answer labels into their locations.    
     */
    public void putAnswerBoxes()
    {
        rand = Greenfoot.getRandomNumber(3);
        if(rand == 0)
        {
            answer1.setValue(answer);
            answer2.setValue(answer + 1 + Greenfoot.getRandomNumber(10));
            answer3.setValue(answer - 1 - Greenfoot.getRandomNumber(10));
            answer4.setValue(answer + 1 + Greenfoot.getRandomNumber(100));
            addObject(answer1, 550,75);
            addObject(answer2, 550,168);
            addObject(answer3, 720,75);
            addObject(answer4, 720,168);    
        }
        else if(rand == 1)
        {
            answer2.setValue(answer);
            answer1.setValue(answer + 1 + Greenfoot.getRandomNumber(10));
            answer3.setValue(answer - 1 - Greenfoot.getRandomNumber(10));
            answer4.setValue(answer + 1 + Greenfoot.getRandomNumber(100));
            addObject(answer1, 550,75);
            addObject(answer2, 550,168);
            addObject(answer3, 720,75);
            addObject(answer4, 720,168);
        }
        else if(rand == 2)
        {
            answer3.setValue(answer);
            answer1.setValue(answer + 1 + Greenfoot.getRandomNumber(100));
            answer2.setValue(answer + 1 + Greenfoot.getRandomNumber(10));
            answer4.setValue(answer - 1 - Greenfoot.getRandomNumber(10));
            addObject(answer1, 550,75);
            addObject(answer2, 550,168);
            addObject(answer3, 720,75);
            addObject(answer4, 720,168);
        }
        else
        {
            answer4.setValue(answer);
            answer1.setValue(answer + 1 + Greenfoot.getRandomNumber(5));
            answer2.setValue(answer + 1 + Greenfoot.getRandomNumber(10));
            answer3.setValue(answer - 1 - Greenfoot.getRandomNumber(10));
            addObject(answer1, 550,75);
            addObject(answer2, 550,168);
            addObject(answer3, 720,75);
            addObject(answer4, 720,168);
        }
    }
}
