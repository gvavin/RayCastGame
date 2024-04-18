package org.graphics;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;
import org.graphics.EventListener;
import org.inputs.KeyInputs;


public class RayCastGameEngine {

    private static GLProfile profile = null;

    // slightly smaller than hd screen resolution
    public static final int finScreenSizeX = 1024;
    public static final int finScreenSizeY = 768;


    public static double unitsWide = 10;





    private static GLWindow window = null;


    //initialize method that initializes the openGL window
    public static void init(){
        GLProfile.initSingleton();
         profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);


        window = GLWindow.create(caps);
        window.setSize(finScreenSizeX,finScreenSizeY);
        window.setResizable(true);
        window.addGLEventListener(new EventListener());
        window.addKeyListener(new KeyInputs());


        //FPSAnimator animator = new FPSAnimator(window, 60);
        //animator.start();


        window.setVisible(true);


    }

    public static void render(){
        if(window == null){
            return;

        }
        window.display();
    }


    public static int getWindowWidth (){
        return window.getWidth();
    }
    public static int getWindowHeight(){
        return window.getHeight();
    }

    public static GLProfile getProfile(){
        return profile;
    }



}
