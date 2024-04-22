package org.inputs;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import org.world.Player;
import org.world.World;

public class KeyInputs implements KeyListener {


    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyCode());
        if(e.getKeyCode()==87){
            World.up = true;
        }if(e.getKeyCode()==83){
            World.down = true;
        }if(e.getKeyCode()==65){
            World.left = true;
        }if(e.getKeyCode()==68){
            World.right = true;
        }
    }


    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==87){
            World.up = false;
        }if(e.getKeyCode()==83){
            World.down = false;
        }if(e.getKeyCode()==65){
            World.left = false;
        }if(e.getKeyCode()==68){
            World.right = false;
        }
    }
}
