package org.world;

import org.graphics.Graphics;
import java.lang.Math;

public class Player {



    private static double px;
    private static double py;
    private static double pdx;
    private static double pdy;
    private static float worldx;
    private static float worldy;
    public static double getPX(){return px;}
    public static double getPY(){return py;}
    public static float getWorldX(){return worldx;}
    public static float getWorldY(){return worldy;}

    public Player(double startX, double startY){
        px = startX;
        py = startY;

        pdx = Math.cos((((Graphics.rotation)*(Math.PI/180))));
        pdy = Math.sin((((Graphics.rotation)*(Math.PI/180))));
    }

    public void update(boolean up,boolean down, boolean left, boolean right){


        if(up){
            moveUp();
        }
        if(down){
            moveDown();
        }
        if(left){
            lookLeft();
        }
        if(right){
            lookRight();
        }


    }

    public void render(){
        Graphics.fillPlayerRect(px,py,25,25);
        //Graphics.drawPlayerLine(px,py,pdx,pdy);
    }



    public void moveUp(){
        px+=pdx;
        py+=pdy;
    }
    public void moveDown(){
        px-=pdx;
        py-=pdy;
    }
    public void lookLeft(){
        subtractPlayerAngle(1);
        if(((Graphics.rotation)*(Math.PI/180))<0){
            Graphics.setRotation(360);
        }
        pdx = Math.cos((((Graphics.rotation)*(Math.PI/180))));
        pdy = Math.sin((((Graphics.rotation)*(Math.PI/180))));

    }
    public void lookRight(){
        addPlayerAngle(1);
        if(((Graphics.rotation)*(Math.PI/180))>(2*Math.PI)){
            Graphics.setRotation(0);
        }
        pdx = Math.cos((((Graphics.rotation)*(Math.PI/180))));
        pdy = Math.sin((((Graphics.rotation)*(Math.PI/180))));
    }

    public void addPlayerAngle(float rotation){
        float rotAmount = Graphics.rotation+rotation;
        Graphics.setRotation(rotAmount);
    }
    public void subtractPlayerAngle(float rotation){
        float rotAmount = Graphics.rotation-rotation;
        Graphics.setRotation(rotAmount);
    }
}
