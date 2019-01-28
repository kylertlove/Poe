package Poe.Engine.Utlities;

import Poe.Models.GameObject;

/**
 * Math Utility Class
 */
public class MathUtils {

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
     * int a
     * int b
     * @return Random number between range
     */
    public static int getRandomNumberFromRange(int min, int max) {
        return GameUtils.random.nextInt((max - min) + 1) + min;
    }
}