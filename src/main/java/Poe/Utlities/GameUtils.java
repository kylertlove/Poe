package Poe.Utlities;

import Poe.Engine.Renderer;
import Poe.Models.GameObject;

public class GameUtils {

    private static int idCounter = 0;

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

    //check left -> right -> up -> down
    public static boolean isInBounds(GameObject gameObject) {
        return gameObject.X > -(Renderer.getUnitsWide()/2 - Renderer.cameraX) && gameObject.X < Renderer.getUnitsWide()/2 + Renderer.cameraX
                    && gameObject.Y < Renderer.getUnitsTall()/2  + Renderer.cameraY && gameObject.Y > -(Renderer.getUnitsTall()/2 - Renderer.cameraY);
    }

    public static int getId() {
        return idCounter++;
    }
}
