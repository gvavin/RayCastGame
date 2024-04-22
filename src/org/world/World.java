package org.world;

import org.graphics.EventListener;
import org.graphics.Graphics;


public class World {
    public static boolean up = false;
    public static boolean down = false;
    public static boolean left = false;
    public static boolean right = false;

    //public static float worldWidth =

    static Player playa = new Player(100,100);
    public static void update(){
        playa.update(up,down,left,right);



    }

    public static void render(){
        playa.render();


    }
}
