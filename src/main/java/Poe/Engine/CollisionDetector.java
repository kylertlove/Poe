package Poe.Engine;

import Poe.Models.Entities.Entity;
import Poe.Models.GameObject;
import Poe.World.World;

import java.util.List;


/**
 *  --------------
 * | (-,+) | (+,+) |
 * |---------------|
 * | (-,-) | (+,-) |
 *  ---------------
 */
public class CollisionDetector {

    public static float marginOfError = 0.2f;

    public static boolean isCollided(GameObject a, GameObject b) {
        return (a.X - a.width/2) < (b.X + b.width/2) &&
                (a.X + a.width/2) > (b.X - b.width/2) &&
                (a.Y - a.height/2) < (b.Y + b.height/2) &&
                (a.Y + a.height/2) > (b.Y - b.height/2);
    }

    public static void updateMoveable(Entity updateObject, List<GameObject> collidedObjects) {
        collidedObjects.forEach((collidedObject) -> {
            if(leftSideCollision(updateObject, collidedObject)) {
                updateObject.canMoveLeft = false;
            }
            if(rightSideCollision(updateObject, collidedObject)) {
                updateObject.canMoveRight = false;
            }
            if(topCollision(updateObject, collidedObject)) {
                updateObject.canMoveUp = false;
            }
            if(bottomCollision(updateObject, collidedObject)) {
                updateObject.canMoveDown = false;
            }
        });
    }

    private static boolean leftSideCollision(Entity a, GameObject b) {
        boolean aa = getLeft(a) < getRight(b);//a left side is left of b right side
        boolean bb = getRight(a) > getRight(b);//a right side is right of b right side
        boolean cc = (getTop(a) + marginOfError) > getTop(b) && ((getTop(a) + marginOfError)) < getBottom(b);
        boolean dd = (getBottom(a) - marginOfError) > getTop(b) && ((getBottom(a) - marginOfError) < getBottom(b));
        boolean ee = (getTop(a) < getTop(b)) && (getBottom(a) > getBottom(b));
        return aa && bb && (cc || dd || ee);
    }
    private static boolean rightSideCollision(Entity a, GameObject b) {
        boolean aa = (getRight(a) > getLeft(b));
        boolean bb = getRight(a) < getRight(b);
        boolean cc = ((getTop(a) + marginOfError) > getTop(b)) && ((getTop(a) + marginOfError) < getBottom(b));
        boolean dd = ((getBottom(a) - marginOfError) > getTop(b)) && ((getBottom(a) - marginOfError) < getBottom(b));
        boolean ee = (getTop(a) < getTop(b)) && (getBottom(a) > getBottom(b));
        return aa && bb && (cc || dd || ee);
    }
    private static boolean topCollision(Entity a, GameObject b){
        boolean aa = (getTop(a) > getBottom(b));
        boolean bb = (getBottom(a) < getBottom(b));
        boolean cc = ((getLeft(a) + marginOfError) > getLeft(b)) && ((getLeft(a) + marginOfError) < getRight(b));
        boolean dd = ((getRight(a) - marginOfError) > getLeft(b)) && ((getRight(a) - marginOfError) < getRight(b));
        boolean ee = (getLeft(a) < getLeft(b)) && (getRight(a) > getRight(b));
        return aa && bb && (cc || dd || ee);
    }
    private static boolean bottomCollision(Entity a, GameObject b){
        boolean aa = (getBottom(a) < getTop(b));
        boolean bb = ((getBottom(a) - marginOfError) > getBottom(b));
        boolean cc = ((getLeft(a) + marginOfError) > getLeft(b) && ((getLeft(a) + marginOfError) < getRight(b)));
        boolean dd = ((getRight(a) - marginOfError) > getLeft(b)) && ((getRight(a) - marginOfError) < getRight(b));
        boolean ee = (getLeft(a)< getLeft(b)) && (getRight(a) >getRight(b));
        return aa && bb && (cc || dd || ee);
    }

    private static float getBottom(GameObject a) {
        return (a.Y - a.height/2);
    }
    private static float getTop(GameObject a) {
        return (a.Y + a.height/2);
    }
    private static float getLeft(GameObject a) {
        return (a.X - a.width/2);
    }
    private static float getRight(GameObject a) {
        return (a.X + a.width/2);
    }
}
