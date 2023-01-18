import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

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
    GreenfootSound correct = new GreenfootSound("correct.mp3");
    GreenfootSound wrong = new GreenfootSound("wrong.mp3");
    
    // Variables
    public static int score = 0;
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
    
    public World1()
    {    
        // Create a new world with 800x450 cells with a cell size of 1x1 pixels.
        super(800, 450, 1);
        Wraith wraith = new Wraith();
        addObject(wraith,30,370);
        Npc npc = new Npc();
        addObject(npc, 760, 370);
        Box box = new Box();
        addObject(box, 280,120);
        AnswerBox answerBox = new AnswerBox();
        addObject(answerBox,550,75);
        AnswerBox2 answerBox2 = new AnswerBox2();
        addObject(answerBox2,550,168);
        AnswerBox3 answerBox3 = new AnswerBox3();
        addObject(answerBox3,720,75);
        AnswerBox4 answerBox4 = new AnswerBox4();
        addObject(answerBox4,720,168);
        addObject(scoreLabel,20,20);
        createRocket();
        createQuestionAdd();
        correct.setVolume(40);
        wrong.setVolume(100);
    }
    
    public void gameOver()
    {
        backgroundMusic.stop();
        gameOver endscreen = new gameOver();
        Greenfoot.setWorld(endscreen);
    }
    
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
    
    public void deleteQuestion()
    {
        answer1.setValue("");
        answer2.setValue("");
        answer3.setValue("");
        answer4.setValue("");

    }
        
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

    public void act()
    {
        backgroundMusic.playLoop();
        MouseInfo mouse = Greenfoot.getMouseInfo();
    }

    public void createQuestionMultiply()
    {
        int x1 = Greenfoot.getRandomNumber(14);
        int y1 = Greenfoot.getRandomNumber(14);
        question.setValue(x1 + " x " + y1 + " = ");
        addObject(question, 280, 120);
        answer = x1 * y1;
        putAnswerBoxes();
    }
    
    public void createQuestionSubtract()
    {
        int x1 = Greenfoot.getRandomNumber(50);
        int y1 = Greenfoot.getRandomNumber(50);
        question.setValue(x1 + " - " + y1 + " = ");
        addObject(question, 280,120);
        answer = x1 - y1;
        putAnswerBoxes();
    }
    
    public void createQuestionAdd()
    {
        int x1 = Greenfoot.getRandomNumber(100);
        int y1 = Greenfoot.getRandomNumber(100);
        question.setValue(x1 + " + " + y1 + " = ");
        addObject(question, 280,120);
        answer = x1 +y1;
        putAnswerBoxes();
    }
    
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
