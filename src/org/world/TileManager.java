package org.world;

import java.util.ArrayList;
import org.world.Tile;
import org.world.World;

public class TileManager {

    public static float tileNumberX = (World.worldWidth / World.TileWidth);
    public static float tileNumberY = (World.worldHeight / World.TileWidth);

    public static ArrayList<Tile> TileList;


    public TileManager(){
        TileList = new ArrayList<>();
        for(float i = 1; i<=tileNumberX;i++){
            for(float j=1;j<=tileNumberY;j++){
                Tile bob = new Tile((i*tileNumberX),(i*tileNumberY),1);
                TileList.add(bob);
            }
        }
    }

    public void update(){

    }
    public void render(){
        for(Tile tiles: TileList){
            tiles.Render();
        }
    }


}
