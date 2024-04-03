package org.graphics;

import com.jogamp.opengl.GL2;

public class Graphics {

    private static float red = 1;
    private static float green = 1;
    private static float blue = 1;
    private static float alpha = 1;

    //rotation in degrees
    public static float rotation = 10;

    public static void fillRect(float x, float y, float width, float height) {
        GL2 gl = EventListener.gl;

        gl.glTranslatef(x,y,0);
        gl.glRotatef(rotation,0,0,1);


        gl.glColor3f(red,green,blue);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(-width/2,-height/2);
        gl.glVertex2f(width/2,-height/2);
        gl.glVertex2f(width/2,height/2);
        gl.glVertex2f(-width/2,height/2);
        gl.glEnd();

        gl.glRotatef(-rotation,0,0,1);
        gl.glTranslatef(-x,-y,0);

    }
    //set color method takes red green and blue float values and sets
    //the instance variables to the inputted values
    public static void setColor(float r, float g, float b,float a){
        red = r;
        green = g;
        blue = b;
        alpha = a;
    }

    public static void setRotation(float r){
        rotation = r;
    }


}
