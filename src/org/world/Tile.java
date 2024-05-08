package org.world;

import org.graphics.Graphics;

import java.awt.image.BufferedImage;

public class Tile {

    public float width =64;
    public float height=64;

    public float tileX;
    public float tileY;
    private BufferedImage tileTexture;

    public void Render(){

        Graphics.fillRect(tileX,tileY,width,height);

    }

   public float getX(){
        return tileX;
   }
   public float getY(){
        return tileY;
   }

}
