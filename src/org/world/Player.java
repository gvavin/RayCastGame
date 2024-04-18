package org.world;

public class Player {


    public static boolean runUp = false;
    private static float px;
    private static float py;
    private static float worldx;
    private static float worldy;
    public static float getPX(){return px;}
    public static float getPY(){return px;}
    public static float getWorldX(){return worldx;}
    public static float getWorldY(){return worldy;}

    public Player(float startX, float startY){
        px = startX;
        py = startY;
    }

    public void moveUp(){
        py+=5;
    }
    public void moveDown(){
        py-=5;
    }
    public void moveLeft(){
        px-=5;
    }
    public void moveRight(){
        px+=5;
    }
}
