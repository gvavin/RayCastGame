package org.engine;

import org.graphics.RayCastGameEngine;
import org.world.FloorTile;
import org.world.Tile;
import org.world.WallTile;
import org.world.World;

public class Main {

    public static void main(String[] args){
        World.loadMapData();
        RayCastGameEngine.init();
        Gameloop.start();

        for(int y = 0; y < 8; y++){

            for(int x = 0; x < 8;x++){

                if(World.returnMapData(y,x)==1){
                    WallTile tile = new WallTile();
                    tile.tileX = (float)((tile.width * x)+32);
                    tile.tileY = (float)((tile.height * y)+32);
                    World.addTile(tile);
                }if(World.returnMapData(y,x)==0){
                    FloorTile tile = new FloorTile();
                    tile.tileX = (float)((tile.width * x)+32);
                    tile.tileY = (float)((tile.height * y)+32);
                    World.addTile(tile);
                }

            }
        }
    }


}
