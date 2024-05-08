package org.world;

import org.graphics.Graphics;

public class RayManager {

    public static double r;
    public static double mx;
    public static double my;
    public static double mp;
    public static double dof;


    public static double rx;
    public static double ry;
    public static double ra;
    public static double xo;
    public static double yo;


    public void drawRays3d(){
        ra = ((Graphics.rotation)*(Math.PI/180));


        for(int r = 0; r<1;r++ ){
            dof = 0;
            double arcTan = -1/Math.tan(ra);
            if(ra>Math.PI){
                ry = ((((int)Player.getPY())>>6)<<6)-0.0001;
                rx = (Player.getPY()-ry)*(arcTan+Player.getPX());
                yo =-64;
                xo=-yo*arcTan;
            }if(ra<Math.PI){
                ry = ((((int)Player.getPY())>>6)<<6)+64;
                rx = (Player.getPY()-ry)*(arcTan+Player.getPX());
                yo = 64;
                xo=-yo*arcTan;
            }

            if(ra==0 || ra==Math.PI){
                rx=Player.getPX();
                ry=Player.getPY();
                dof=8;
            }
            while(dof<8){
                mx = ((int)(rx)>>6);
                my = ((int)(ry)>>6);
                mp = my*10+mx;
                if(mp<100 && )
            }
        }
    }

}
