package Poe.Engine.Input;

import Poe.World.World;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class KeyInput implements KeyListener {

    private static boolean[] keys = new boolean[256];

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = true;

        if(keyEvent.getKeyCode() == KeyEvent.VK_P) {
            World.debug = !World.debug;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if( !keyEvent.isPrintableKey() || keyEvent.isAutoRepeat() ) {
            return;
        }

        keys[keyEvent.getKeyCode()] = false;
    }

    public static boolean getKey(int keyCode) {
        return keys[keyCode];
    }
}
