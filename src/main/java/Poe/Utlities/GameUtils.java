package Poe.Utlities;

import Poe.Engine.Renderer;
import Poe.Models.Entities.Entity;
import Poe.Models.GameObject;
import java.util.Random;

public class GameUtils {

    public static Random random = new Random();

    /**
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return float - The Angle at which the two Points form a hypotenuse
     */
    public static float getAngle(double x1, double y1, double x2, double y2) {
        return (float)Math.toDegrees(Math.atan2(x1 - x2, y1 - y2));
    }

    /**
     * Get the distance between two objects
     * @param a
     * @param b
     * @return float - Distance between the objects
     */
    public static float getDistanceBetweenObjects(GameObject a, GameObject b) {
        return (float)Math.sqrt(((a.X - b.X) * (a.X - b.X)) + ((a.Y - b.Y) * (a.Y - b.Y)));
    }

    //check left -> right -> up -> down
    public static boolean isInBounds(GameObject gameObject) {
        return gameObject.X > -(Renderer.getUnitsWide()/2 - Renderer.cameraX) && gameObject.X < Renderer.getUnitsWide()/2 + Renderer.cameraX
                    && gameObject.Y < Renderer.getUnitsTall()/2  + Renderer.cameraY && gameObject.Y > -(Renderer.getUnitsTall()/2 - Renderer.cameraY);
    }

    /**
     * Function That will check if Entity A is within passed radius of Entity B
     * @return isWithinRadius
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

}
