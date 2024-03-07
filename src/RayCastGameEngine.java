import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;




public class RayCastGameEngine {


    // slightly smaller than hd screen resolution
    public static final int finScreenSizeX = 1280;
    public static final int finScreenSizeY = 1024;


    public static double unitsWide = 10;




    private static GLWindow window = null;


    //initialize method that initializes the openGL window
    public static void init(){
        GLProfile.initSingleton();
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);




        window = GLWindow.create(caps);
        window.setSize(finScreenSizeX,finScreenSizeY);
        window.setResizable(true);
        window.addGLEventListener(new EventListener());


        FPSAnimator animator = new FPSAnimator(window, 60);
        animator.start();


        window.setVisible(true);






    }


    public static int getWindowWidth (){
        return window.getWidth();
    }
    public static int getWindowHeight(){
        return window.getHeight();
    }


    public static void main(String[] args){
        init();
    }
}
