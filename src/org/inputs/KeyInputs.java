package org.inputs;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import org.world.Player;
import org.world.World;

public class KeyInputs implements KeyListener {


    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if(e.getKeyCode()==87){
            World.runUp = true;
        }
    }


    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==87){
            Player.runUp = false;
        }
    }
}
