package org.world;

import org.graphics.EventListener;
import org.graphics.Graphics;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.concurrent.ConcurrentLinkedQueue;


public class World {
    public static boolean up = false;
    public static boolean down = false;
    public static boolean left = false;
    public static boolean right = false;

    public static final float TileWidth=64;

    public static float worldWidth = 1000;
    public static float worldHeight = 750;

    private static ConcurrentLinkedQueue<Tile> tileList = new ConcurrentLinkedQueue<Tile>();

    public static int mapTileData[][];
    public static ArrayList<Integer> map = new ArrayList<Integer>();




    static Player playa = new Player(250,250);



    public static void update(){

        playa.update(up,down,left,right);

    }
    public static void render(){

        for(Tile tile: tileList){
            tile.Render();
        }
        playa.render();
        RayManager.drawRays3d();
    }

    public static void addTile(Tile tile){
        tileList.offer(tile);
    }
    public static int returnMapData(int x,int y){
        return mapTileData[x][y];
    }

    public static void loadMapData(){
        mapTileData = new int[8][8];
        try{

            InputStream input = World.class.getResourceAsStream("/org/maps/testmap1.txt");
            if(input == null){
                System.out.println("map data empty");
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));


            int col = 0;
            int row = 0;

            while(col<8 && row<8){
                String line = reader.readLine();

                while(col<8){
                    String tileNums[] = line.split("&");

                    int num = Integer.parseInt(tileNums[col]);
                    mapTileData[row][col] = num;
                    map.add(num);
                    col++;

                }if(col==8){

                    col=0;
                    row++;
                }

            }
            reader.close();

        }catch(Exception e){

        }
    }

}
