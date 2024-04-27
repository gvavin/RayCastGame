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
        TileList = new ArrayList<>();
        for(float i = 0; i<tileNumberX;i++){
            for(float j=0;j<tileNumberY;j++){
                System.out.println("X:"+(i*50)+"y:"+(j*50));
                TileList.add(new Tile((i*50),(i*50),1));
            }
        }
    }

    public void update(){

    }
    public void render(){
        for(int i =0; i<TileList.size();i++){
            //System.out.println(TileList.get(i).getX());
            TileList.get(i).Render();
        }
    }


}
