import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import static java.lang.Math.*;

/**
 * Write a description of class BaseWorld here.
 * a base world class
 * @author Karas     
 * @version v0.101
 */
public class BaseWorld extends World
{
    //public 
    
    public BaseWorld()
    {    
        // Create a new world with 1600x900 cells with a cell size of 1x1 pixels.
        super(1600, 900, 1); 
        prepare();
        
    }
 
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //create player
        Player player = new Player();
        addObject(player,800,400);
        
        //create 3 enermies
        Enermy enermy1 = new Enermy();
        Enermy enermy2 = new Enermy();
        Enermy enermy3 = new Enermy();
        addObject(enermy1,200,200);
        addObject(enermy2,400,400);
        addObject(enermy3,800,800);
    }
}
