package Poe.Input;


import Poe.Utlities.PoeLogger;
import Poe.World.World;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class KeyInput implements KeyListener {

    private static boolean[] keys = new boolean[256];

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if( !keyEvent.isPrintableKey() || keyEvent.isAutoRepeat() ) {
            return;
        }

        keys[keyEvent.getKeyCode()] = false;

        //Debug switching
        if(keyEvent.getKeyChar() == 'D') {
            World.debug = !World.debug;
        }
    }

    public static boolean getKey(int keyCode) {
        return keys[keyCode];
    }
}
