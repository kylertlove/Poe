package Poe.Engine.Utlities;

import Poe.Engine.Renderer;
import Poe.GameObjects.Entities.Entity;
import Poe.GameObjects.GameObject;

import java.util.logging.Logger;

/**
 *  Game Utility Class
 */
public class GameUtils {

    private static final Logger logger = Logger.getLogger(GameUtils.class.getName());

    /**
     * 
     * @param GameObject gameObject
     * @return check left -> right -> up -> down to see if gameObject is in bounds of Renderer
     */
    public static boolean isInBounds(GameObject gameObject) {
        return gameObject.X > -(Renderer.getUnitsWide()/2 - Renderer.cameraX) 
            && gameObject.X < Renderer.getUnitsWide()/2 + Renderer.cameraX
            && gameObject.Y < Renderer.getUnitsTall()/2  + Renderer.cameraY 
            && gameObject.Y > -(Renderer.getUnitsTall()/2 - Renderer.cameraY);
    }

    /**
     * Timeout function
     * @param Runnable runnable
     * @param int delay
     */
    public static void setTimeout(Runnable runnable, int delay) {
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                logger.severe(e.getMessage());
            }
        }).start();
    }
}
