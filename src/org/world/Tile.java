package org.world;

import org.graphics.Graphics;

import java.awt.image.BufferedImage;

public class Tile {

    private static float width =25;
    private static float height=25;

    public static float tileX;
    public static float tileY;
    private static BufferedImage tileTexture;


    public Tile(float x, float y, int tileNum){
        tileX = x;
        tileY = y;
    }

    public void Render(){
        Graphics.setColor(0,0,1,1);
        Graphics.fillRect(tileX,tileY,width,height);
    }

}
