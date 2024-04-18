package org.engine;

import com.sun.source.tree.TryTree;
import org.graphics.RayCastGameEngine;
import org.world.World;

public class Gameloop {

    private static boolean running = false;
    private static int fps;
    private static int lastFps=0;
    private static long lastFpsCheck;

    private static int updates = 0;
    private static final int MAX_UPDATES = 5;

    private static long lastUpdateTime=0;

    private static int targetFPS = 60;

    private static int targetTime = 1000000000/ targetFPS;

    public static void start(){
        Thread thread = new Thread(){
            public void run(){

                running = true;

                lastUpdateTime = System.nanoTime();

                fps = 0;
                lastFpsCheck = System.nanoTime();

                while(running){
                    long currentTime = System.nanoTime();

                    updates = 0;

                    while(currentTime - lastUpdateTime >targetTime){
                        World.update();
                        lastUpdateTime += targetTime;
                        updates ++;

                        if(updates > MAX_UPDATES){
                            break;
                        }
                    }
                    RayCastGameEngine.render();

                    fps++;
                    if(System.nanoTime() >= lastFpsCheck+1000000000){
                        lastFps=fps;
                        fps = 0;
                        lastFpsCheck= System.nanoTime();
                    }

                    long timeTaken = System.nanoTime() - currentTime;
                    if(targetTime > timeTaken ){
                        try {
                            Thread.sleep((targetTime-timeTaken)/1000000);
                        } catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    }



                    /*Long startTime = System.nanoTime();

                    //poll input

                    //update Game
                    World.update();
                    //Render
                    RayCastGameEngine.render();

                    Long timeTaken = System.nanoTime() - startTime;

                    if(timeTaken<targetTime){
                        try {
                            Thread.sleep((targetTime-timeTaken)/1000000);
                        } catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    }*/
                }

            }
        };
        thread.setName("GameLoop");
        thread.start();
    }

    public static int getFps(){
        return lastFps;
    }
}
