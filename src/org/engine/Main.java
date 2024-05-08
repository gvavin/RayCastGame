package org.engine;

import org.graphics.RayCastGameEngine;
import org.world.FloorTile;
import org.world.Tile;
import org.world.World;

public class Main {

    public static void main(String[] args){
        RayCastGameEngine.init();
        Gameloop.start();

        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10;y++){
                FloorTile tile = new FloorTile();
                tile.tileX = (float)((tile.width * x)+15);
                tile.tileY = (float)((tile.height * y)+15);
                World.addTile(tile);
            }
        }
    }


}
