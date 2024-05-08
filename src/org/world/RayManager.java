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

    public static double px = Player.getPX();
    public static double py = Player.getPY();

    public static double P2 = (Math.PI/2);
    public static double P3 = ((3*Math.PI)/2);
    public static double deg1 = 0.0174533;

    public static double distance(double ax, double ay, double bx, double by, double ang){
        return(Math.sqrt( (bx-ax)*(bx-ax) + (by-ay)*(by-ay) ) );
    }


    public static void drawRays3d(){
        ra = (((Graphics.rotation)*(Math.PI/180))-deg1*30);
        if(ra<0){ra+=Math.PI*2;}
        if(ra>Math.PI*2){ra-=Math.PI*2;}


        for(int r = 0; r<60;r++ ){

            //horizontal line check
            dof = 0;
            double disH = 1000000, hx=Player.getPX(), hy=Player.getPY();
            double arcTan = -1/Math.tan(ra);
            if(ra>Math.PI){
                ry = ((((int)Player.getPY())>>6)<<6)-0.0001;
                rx = ((Player.getPY()-ry)*arcTan)+Player.getPX();
                yo =-64;
                xo=-yo*arcTan;
            }if(ra<Math.PI){
                ry = ((((int)Player.getPY())>>6)<<6)+64;
                rx = ((Player.getPY()-ry)*arcTan)+Player.getPX();
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
                mp = my*8+mx;

                //this if statement determines collision, could also call it hit detection
                if(mp>0 && mp<64   && World.map.get((int)mp)==1){
                    hx = rx;
                    hy = ry;
                    disH = distance(px,py,hx,hy,ra);
                    dof=8;
                }
                else{ // if no hit, go to next horizontal grid space
                    rx+=xo;
                    ry+=yo;
                    dof+=1;
                }

            }


            //vertical line check
            dof = 0;
            double disV = 1000000, vx=Player.getPX(), vy=Player.getPY();
            double negTan = -Math.tan(ra);
            if(ra>P2 || ra<P3){
                rx = ((((int)Player.getPX())>>6)<<6)-0.0001;
                ry = ((Player.getPX()-rx)*negTan)+Player.getPY();
                xo =-64;
                yo=-xo*negTan;
            }if(ra<P2 || ra>P3){
                rx = ((((int)Player.getPX())>>6)<<6)+64;
                ry = ((Player.getPX()-rx)*negTan)+Player.getPY();
                xo = 64;
                yo=-xo*negTan;
            }
            if(ra==0 || ra==Math.PI){
                rx=Player.getPX();
                ry=Player.getPY();
                dof=8;
            }
            while(dof<8){
                mx = ((int)(rx)>>6);
                my = ((int)(ry)>>6);
                mp = my*8+mx;

                //this if statement determines collision, could also call it hit detection
                if(mp>0 && mp<64   && World.map.get((int)mp)==1){
                    vx = rx;
                    vy = ry;
                    disV = distance(px,py,vx,vy,ra);
                    dof=8;
                }
                else{ // if no hit, go to next horizontal grid space
                    rx+=xo;
                    ry+=yo;
                    dof+=1;
                }

            }
            if(disV<disH){
                rx = vx;
                ry = vy;
            }if(disH<disV){
                rx = hx;
                ry = hy;
            }
            Graphics.castRay(Player.getPX(),Player.getPY(),rx,ry);
            ra+= deg1;
            if(ra<0){ra+=Math.PI*2;}
            if(ra>Math.PI*2){ra-=Math.PI*2;}
        }
    }

}
