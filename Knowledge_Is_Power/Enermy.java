import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import static java.lang.Math.*;

/**
 * Write a description of class Enermy here.
 * a base enermy class
 * @author Karas
 * @version v0.101
 */
public class Enermy extends Actor
{
    private int size_x;
    private int size_y;
    private int move_speed = 3;
    private double scale_x;
    private double scale_y;
    
    //enermy hp
    private int hp = 100;
    
    //knowing players current location
    private boolean player_found = false;
    private int player_x = 800;
    private int player_y = 450;
    
    //random start timer and random point for wander direction
    private int timer = (int)(40*random());
    private double x = 0;
    private double y = 0;
    
    public Enermy(){
        this(50,50);    //default size 50*50
    }
    
    public Enermy(int sizeX, int sizeY){
        size_x = sizeX;
        size_y = sizeY;
        GreenfootImage image = getImage();
        image.scale(size_x, size_y);
        setImage(image);
    }
    
    public void act() 
    {
        update();
        move(); 
        attack();
    }
    
    public void update(){
        
    }
    
    public void move(){
        
        if (player_found){
            chase();
        }
        else{
            wander();
        }
    }
    
    public void chase(){
        /*get current location*/
        int current_x = getX();
        int current_y = getY();
        int update_x = current_x;
        int update_y = current_y;
        
        /*calculate direction towards player*/
        double x = player_x - current_x;
        double y = player_y - current_y;
        scale_x = x/sqrt(x*x+y*y);
        scale_y = y/sqrt(x*x+y*y);
        
        //update
        update_x = (int)(current_x + move_speed*scale_x);
        update_y = (int)(current_y + move_speed*scale_y);
        turnTowards(update_x,update_y);
        setLocation(update_x,update_y);
    }
    
    public void wander(){
        //get current location
        int current_x = getX();
        int current_y = getY();
        int update_x = current_x;
        int update_y = current_y;
        
        //calculate direction to a random point for every 80-120 frames (2sec)
        if (timer == 0){
            x = 1600.0*random() - current_x;
            y = 900.0*random() - current_y;
            timer = (int)(120-40*random());
        }
        else if (timer > 40){
            timer--;
            scale_x = x/sqrt(x*x+y*y);
            scale_y = y/sqrt(x*x+y*y);
            
            //update
            update_x = (int)(current_x + move_speed*scale_x);
            update_y = (int)(current_y + move_speed*scale_y);
            turnTowards(update_x,update_y);
            setLocation(update_x,update_y);
        }
        else timer--;
    }
    
    public void attack(){

    }
}
