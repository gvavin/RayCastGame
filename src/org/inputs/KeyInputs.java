package org.inputs;

import com.jogamp.newt.event.InputEvent;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import org.world.Player;
import org.world.World;

public class KeyInputs implements KeyListener {



    public void keyPressed(KeyEvent e) {
        if((InputEvent.AUTOREPEAT_MASK & e.getModifiers()) == 0 )  {
            if(e.getKeyCode()==87){
                World.up = true;
            }
        }if((InputEvent.AUTOREPEAT_MASK & e.getModifiers()) == 0 )  {
            if(e.getKeyCode()==83){
                World.down = true;
            }
        }if((InputEvent.AUTOREPEAT_MASK & e.getModifiers()) == 0 )  {
            if(e.getKeyCode()==65){
                World.left = true;
            }
       }if((InputEvent.AUTOREPEAT_MASK & e.getModifiers()) == 0 )  {
            if(e.getKeyCode()==68){
                World.right = true;
            }
        }

    }


    public void keyReleased(KeyEvent e) {
        if(( InputEvent.AUTOREPEAT_MASK & e.getModifiers() )==0 )  {
            if(e.getKeyCode()==87){
                World.up = false;
            }
        }if(( InputEvent.AUTOREPEAT_MASK & e.getModifiers() )==0 )  {
            if(e.getKeyCode()==83){
                World.down = false;
            }
        }if(( InputEvent.AUTOREPEAT_MASK & e.getModifiers() )==0 )  {
            if(e.getKeyCode()==65){
                World.left = false;
            }
        }if(( InputEvent.AUTOREPEAT_MASK & e.getModifiers() )==0 )  {
            if(e.getKeyCode()==68){
                World.right = false;
            }
        }



    }
}
