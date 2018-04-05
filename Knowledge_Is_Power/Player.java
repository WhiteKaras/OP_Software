import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import static java.lang.Math.*;

/**
 * Write a description of class Obj here.
 * A base player class
 * @author Karas
 * @version v0.101
 */
public class Player extends Actor
{
    //private GifImage gif = new GifImage("obj_arrow.gif");
    private int size_x;
    private int size_y;
    private int move_speed = 5;
    
    //Max hp = 100
    private final int MAX_HP = 100;
    private int hp = MAX_HP;
    
    //initialization
    public Player(){
        this(50,50);    //default size 50*50
    }
    
    public Player(int x, int y){
        size_x = x;
        size_y = y;
        GreenfootImage image = getImage();
        image.scale(size_x, size_y);
        setImage(image);
        
    }
    
    public void act() 
    {
       //setImage(gif.getCurrentImage());
       move(); 
       attack();
    }    
    
    //movement control using WASD
    public void move(){
        /*get current location*/
        int current_x = getX();
        int current_y = getY();
        int update_x = current_x;
        int update_y = current_y;
        
        /*move and turn*/
        if(Greenfoot.isKeyDown("w")){
            update_y = current_y - move_speed;
            turnTowards(update_x,update_y);
        }
        if(Greenfoot.isKeyDown("s")){
            update_y = current_y + move_speed;
            turnTowards(update_x,update_y);
        }
        if(Greenfoot.isKeyDown("a")){
            update_x = current_x - move_speed;
            turnTowards(update_x,update_y);
        }
        if(Greenfoot.isKeyDown("d")){
            update_x = current_x + move_speed;
            turnTowards(update_x,update_y);
        }
        
        //update
        setLocation(update_x,update_y);
    }
    
    
    public void attack(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse == null) return;
        if(Greenfoot.mousePressed(null)){
            getWorld().addObject(new Bullet(getX(),getY(),mouse.getX(),mouse.getY()),getX(),getY());
        } 
    }
   
}
