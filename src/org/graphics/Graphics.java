package org.graphics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;
import org.resources.ImageResource;

public class Graphics {

    private static float red = 1;
    private static float green = 1;
    private static float blue = 1;
    private static float alpha = 1;

    //rotation in degrees
    public static float rotation = 0;

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

    public static void drawImage(ImageResource image,float x, float y, float width, float height) {
        GL2 gl = EventListener.gl;

        Texture tex = image.getTexture();

        if(tex != null){
            gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
        }



        gl.glTranslatef(x,y,0);
        //gl.glRotatef(-rotation,0,0,1);


        gl.glColor4f(red,green,blue,alpha);
        gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(0,0);
            gl.glVertex2f(-width/2,-height/2);

            gl.glTexCoord2f(1,0);
            gl.glVertex2f(width/2,-height/2);

            gl.glTexCoord2f(1,1);
            gl.glVertex2f(width/2,height/2);

            gl.glTexCoord2f(0,1);
            gl.glVertex2f(-width/2,height/2);
        gl.glEnd();
        gl.glFlush();

        gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);

        //gl.glRotatef(-rotation,0,0,1);
        gl.glTranslatef(-x,-y,0);

    }
    public static void fillPlayerRect(double x, double y, double width, double height) {
        GL2 gl = EventListener.gl;

        gl.glTranslated(x,y,0);
        gl.glRotated(rotation,0,0,1);


        gl.glColor3d(red,green,blue);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2d(-width/2,-height/2);
        gl.glVertex2d(width/2,-height/2);
        gl.glVertex2d(width/2,height/2);
        gl.glVertex2d(-width/2,height/2);
        gl.glEnd();

        gl.glRotated(-rotation,0,0,1);
        gl.glTranslated(-x,-y,0);
        /*
        gl.glLineWidth(1);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(x,y);
        gl.glVertex2d(x+(pdx*50),y+(pdy*50));
        gl.glEnd();*/

    }

    public static void drawPlayerLine(double x, double y, double pdx, double pdy){
        GL2 gl = EventListener.gl;




        gl.glLineWidth(1);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(x,y);
        gl.glVertex2d(x+pdx*50,y+pdy*50);
        gl.glEnd();



    }

    public static void setRotation(float r){
        rotation = r;
    }


}
