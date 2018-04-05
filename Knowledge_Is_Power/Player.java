import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obj here.
 * A base player class
 * @author Karas
 * @version v0.1
 */
public class Player extends Actor
{
    //private GifImage gif = new GifImage("obj_arrow.gif");
    private int move_speed = 5;
    
    //initialization
    public Player(){
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
        
        /*update*/
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
