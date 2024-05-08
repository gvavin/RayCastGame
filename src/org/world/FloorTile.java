package org.world;

import org.graphics.EventListener;
import org.graphics.Graphics;
import org.resources.ImageResource;


public class FloorTile extends Tile{

    public ImageResource floor;

    public float tileX;
    public float tileY;

    public FloorTile(){

        floor = new ImageResource("/Images/floor.png");
    }

    public void update(){


    }


    public void Render(){

        Graphics.drawImage(floor,tileX,tileY,width,height);

    }
}
