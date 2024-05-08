package org.world;

import org.graphics.EventListener;
import org.graphics.Graphics;
import org.resources.ImageResource;


public class WallTile extends Tile{

    public ImageResource floor;

    public float tileX;
    public float tileY;

    public WallTile(){

        floor = new ImageResource("/Images/floor.png");
    }

    public void update(){


    }


    public void Render(){
        Graphics.setColor(1,0,1,1);
        Graphics.drawImage(floor,tileX,tileY,width,height);
        Graphics.setColor(1,1,1,1);

    }
}
