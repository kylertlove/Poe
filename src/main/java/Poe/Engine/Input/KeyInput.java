package Poe.Engine.Input;

import Poe.Engine.GameLoop;
import Poe.World.World;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class KeyInput implements KeyListener {

    private static boolean[] keys = new boolean[256];

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = true;

        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_P:
                World.debug = !World.debug;
                break;
            case KeyEvent.VK_1:
                World.player.setRangeWeapon(0);
                break;
            case KeyEvent.VK_2:
                World.player.setRangeWeapon(1);
                break;
            case KeyEvent.VK_ENTER:
                GameLoop.paused = !GameLoop.paused;
            default:
                break;
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
