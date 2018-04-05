import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BaseWorld extends World
{

    /**
     * Constructor for objects of class BaseWorld.
     * 
     */
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
        Player obj = new Player();
        addObject(obj,630,303);
    }
}
