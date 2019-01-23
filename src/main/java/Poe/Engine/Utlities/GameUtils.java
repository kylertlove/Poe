package Poe.Engine.Utlities;

import Poe.Engine.Renderer;
import Poe.Models.Entities.Entity;
import Poe.Models.GameObject;
import java.util.Random;

/**
 *  Random One off utility functions
 */
public class GameUtils {

    public static Random random = new Random();

    /**
     * @param double x1
     * @param double y1
     * @param double x2
     * @param double y2
     * @return float - The Angle at which the two Points form a hypotenuse
     */
    public static float getAngle(double x1, double y1, double x2, double y2) {
        return (float)Math.toDegrees(Math.atan2(x1 - x2, y1 - y2));
    }

    /**
     * Get the distance between two objects
     * @param GameObject a
     * @param GameObject b
     * @return float - Distance between the objects
     */
    public static float getDistanceBetweenObjects(GameObject a, GameObject b) {
        return (float)Math.sqrt(((a.X - b.X) * (a.X - b.X)) + ((a.Y - b.Y) * (a.Y - b.Y)));
    }

    /**
     * 
     * @param GameObject gameObject
     * @return check left -> right -> up -> down to see if gameObject is in bounds of Renderer
     */
    public static boolean isInBounds(GameObject gameObject) {
        return gameObject.X > -(Renderer.getUnitsWide()/2 - Renderer.cameraX) && gameObject.X < Renderer.getUnitsWide()/2 + Renderer.cameraX
                    && gameObject.Y < Renderer.getUnitsTall()/2  + Renderer.cameraY && gameObject.Y > -(Renderer.getUnitsTall()/2 - Renderer.cameraY);
    }

    /**
     * @param Entity A 
     * @param Entity B  
     * @param float radius 
     * @return will check if Entity A is within passed radius of Entity B
     */
    public static boolean entityNearEntity(Entity A, Entity B, float radius) {
        float distance = getDistanceBetweenObjects(A, B);
        return distance < radius;
    }

    /**
     * int a
     * int b
     * @return Random number between range
     */
    public static int getRandomNumberFromRange(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }


    /**
     * Timeout function
     * @param Runnable runnable
     * @param int delay
     */
    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                PoeLogger.logger.info("Set Timeout error");
                PoeLogger.logger.severe(e.getMessage());
            }
        }).start();
    }
}
