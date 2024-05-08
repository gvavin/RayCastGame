package org.world;

import org.graphics.EventListener;
import org.graphics.Graphics;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.concurrent.ConcurrentLinkedQueue;


public class World {
    public static boolean up = false;
    public static boolean down = false;
    public static boolean left = false;
    public static boolean right = false;

    public static final float TileWidth=50;

    public static float worldWidth = 5000;
    public static float worldHeight = 5000;

    private static ConcurrentLinkedQueue<Tile> tileList = new ConcurrentLinkedQueue<Tile>();


    static Player playa = new Player(100,100);



    public static void update(){

        playa.update(up,down,left,right);


    }
    public static void render(){
        for(Tile tile: tileList){
            tile.Render();
        }
        playa.render();
    }

    public static void addTile(Tile tile){
        tileList.offer(tile);
    }

}
