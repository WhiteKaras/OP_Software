import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import static java.lang.Math.*;

/**
 * Write a description of class Bullet here.
 * a base Bullet class
 * @author Karas 
 * @version v0.1
 */
public class Bullet extends Actor
{
    private int move_speed = 10;
    private double scale_x;
    private double scale_y;
   
    //initialization
    public Bullet(int init_x, int init_y, int direct_x, int direct_y){
        //fire angle scale
        double x = direct_x - init_x;
        double y = direct_y - init_y;
        scale_x = x/sqrt(x*x+y*y);
        scale_y = y/sqrt(x*x+y*y);
    }
    
    public void act() {
       move();
       self_delete();
    }    
    
    public void move(){
         //get current location
        int current_x = getX();
        int current_y = getY();
        int update_x = current_x;
        int update_y = current_y;
        
        update_x = (int)(current_x + move_speed*scale_x);
        update_y = (int)(current_y + move_speed*scale_y);
        
        //update
        turnTowards(update_x,update_y);
        setLocation(update_x,update_y);
    }
    
    public void self_delete(){
        //self delete when hit world edge
        if (!(getX()>0 && getX()<1599 && getY()>0 && getY()<899)){
            getWorld().removeObject(this);
        }
    }
}
