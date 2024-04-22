package org.world;

import java.util.ArrayList;
import org.world.Tile;

public class TileManager {

    public static ArrayList TileList;


    public TileManager(){

    }

    public void update(){

    }
    public void render(){
        for(Tile t: TileList){
            t.Render();
        }
    }


}
