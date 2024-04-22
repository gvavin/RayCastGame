package org.world;

import org.graphics.Graphics;

public class Player {



    private static float px;
    private static float py;
    private static float worldx;
    private static float worldy;
    public static float getPX(){return px;}
    public static float getPY(){return px;}
    public static float getWorldX(){return worldx;}
    public static float getWorldY(){return worldy;}

    public void update(boolean up,boolean down, boolean left, boolean right){

        if(up){
            moveUp();
        }
        if(down){
            moveDown();
        }
        if(left){
            moveLeft();
        }
        if(right){
            moveRight();
        }
    }

    public void render(){
        Graphics.fillRect(px,py,50,50);
    }

    public Player(float startX, float startY){
        px = startX;
        py = startY;
    }

    public void moveUp(){
        py-=5;
    }
    public void moveDown(){
        py+=5;
    }
    public void moveLeft(){
        px-=5;
    }
    public void moveRight(){
        px+=5;
    }
}
