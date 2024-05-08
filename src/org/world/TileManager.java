package org.world;

import java.util.ArrayList;
import org.world.Tile;
import org.world.World;

public class TileManager {

    public static float tileNumberX = (World.worldWidth / World.TileWidth);
    public static float tileNumberY = (World.worldHeight / World.TileWidth);

    public static ArrayList<Tile> TileList;

    public static int[][] mapArray = new int[100][100];


    public TileManager(){

    }

    public void update(){

    }
    public void render(){
        for(int i =0; i<TileList.size();i++){

        }
    }


}
