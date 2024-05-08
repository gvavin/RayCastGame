package org.graphics;



import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.util.awt.TextRenderer;
import org.engine.Gameloop;
import org.resources.ImageResource;
import org.world.World;

import java.awt.*;

import static com.jogamp.graph.font.Font.*;

public class EventListener implements GLEventListener {

    public static GL2 gl = null;
    public static TextRenderer textRenderer;


    public static ImageResource ram = null;
    public static ImageResource floor = null;


    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        textRenderer = new TextRenderer(new Font("Verdana", Font.BOLD,12));
        gl.glClearColor(0,0,0,1);

        gl.glEnable(GL2.GL_TEXTURE_2D);
        ram = new ImageResource("/Images/awesomepic.png");



    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    @Override
    public void display(GLAutoDrawable drawable) {

        gl = drawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

        textRenderer.beginRendering(1024, 768);
        textRenderer.setColor(0,1,0,1);
        textRenderer.setSmoothing(true);


        textRenderer.draw("fps:"+""+Gameloop.getFps(), (int) (725), (int) (465));
        textRenderer.endRendering();

        World.render();
    }


    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();


        gl.glOrtho(0, RayCastGameEngine.getWindowWidth()-1, RayCastGameEngine.getWindowHeight()-1  ,0,-1,1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);

    }
}
