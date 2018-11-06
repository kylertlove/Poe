package Poe.Engine;

import Poe.Models.Entities.Entity;
import Poe.Models.GameObject;
import Poe.Models.Structures.Structure;
import Poe.World.World;

import java.util.Collection;
import java.util.List;
import java.util.Map;


/**
 *  --------------
 * | (-,+) | (+,+) |
 * |---------------|
 * | (-,-) | (+,-) |
 *  ---------------
 */
public class CollisionDetector {

    public static float marginOfError = 0.3f;

    public static boolean isCollided(GameObject a, GameObject b) {
        return (a.X - a.width/2) < (b.X + b.width/2) &&
                (a.X + a.width/2) > (b.X - b.width/2) &&
                (a.Y - a.height/2) < (b.Y + b.height/2) &&
                (a.Y + a.height/2) > (b.Y - b.height/2);
    }

    public static boolean isCollidedWithList(GameObject a, Map<Long, Structure> list) {
        return list.entrySet().stream().filter(struct -> isCollided(struct.getValue(), a)).count() > 0;
    }

    public static void updateMoveableSingle(Entity object1, GameObject object2) {
        if(leftSideCollision(object1, object2)) {
            object1.canMoveLeft = false;
            if(object2 instanceof Entity) {
                ((Entity) object2).canMoveRight = false;
            }
        }
        if(rightSideCollision(object1, object2)) {
            object1.canMoveRight = false;
            if(object2 instanceof Entity) {
                ((Entity) object2).canMoveLeft = false;
            }
        }
        if(topCollision(object1, object2)) {
            object1.canMoveUp = false;
            if(object2 instanceof Entity) {
                ((Entity) object2).canMoveDown = false;
            }
        }
        if(bottomCollision(object1, object2)) {
            object1.canMoveDown = false;
            if(object2 instanceof Entity) {
                ((Entity) object2).canMoveUp = false;
            }
        }
    }

    public static void updateMoveable(Entity updateObject, List<GameObject> collidedObjects) {
        collidedObjects.forEach((collidedObject) -> {
            if(leftSideCollision(updateObject, collidedObject)) {
                updateObject.canMoveLeft = false;
                if(collidedObject instanceof Entity) {
                    ((Entity) collidedObject).canMoveRight = false;
                }
            }
            if(rightSideCollision(updateObject, collidedObject)) {
                updateObject.canMoveRight = false;
                if(collidedObject instanceof Entity) {
                    ((Entity) collidedObject).canMoveLeft = false;
                }
            }
            if(topCollision(updateObject, collidedObject)) {
                updateObject.canMoveUp = false;
                if(collidedObject instanceof Entity) {
                    ((Entity) collidedObject).canMoveDown = false;
                }
            }
            if(bottomCollision(updateObject, collidedObject)) {
                updateObject.canMoveDown = false;
                if(collidedObject instanceof Entity) {
                    ((Entity) collidedObject).canMoveUp = false;
                }
            }
        });
    }

    private static boolean leftSideCollision(Entity a, GameObject b) {
        boolean aa = getLeft(a) < getRight(b);
        boolean bb = getRight(a) > getRight(b);
        boolean cc = (getTop(a) - marginOfError) > getBottom(b);
        boolean dd = (getBottom(a) + marginOfError) < getTop(b);
        return aa && bb && cc && dd;
    }
    private static boolean rightSideCollision(Entity a, GameObject b) {
        boolean aa = getRight(a) > getLeft(b);
        boolean bb = getLeft(a) < getLeft(b);
        boolean cc = (getTop(a) - marginOfError) > getBottom(b);
        boolean dd = (getBottom(a) + marginOfError) < getTop(b);
        return aa && bb && cc && dd;
    }
    private static boolean topCollision(Entity a, GameObject b){
        boolean aa = getTop(a) > getBottom(b);
        boolean bb = getBottom(a) < getBottom(b);
        boolean cc = (getLeft(a) + marginOfError) < getRight(b);
        boolean dd = (getRight(a) - marginOfError) > getLeft(b);
        return aa && bb && cc && dd;
    }
    private static boolean bottomCollision(Entity a, GameObject b){
        boolean aa = getBottom(a) < getTop(b);
        boolean bb = getTop(a) > getTop(b);
        boolean cc = (getLeft(a) + marginOfError) < getRight(b);
        boolean dd = (getRight(a) - marginOfError) > getLeft(b);
        return aa && bb && cc && dd;
    }

    public static float getBottom(GameObject a) {
        return (a.Y - a.height/2);
    }
    public static float getTop(GameObject a) {
        return (a.Y + a.height/2);
    }
    public static float getLeft(GameObject a) {
        return (a.X - a.width/2);
    }
    public static float getRight(GameObject a) {
        return (a.X + a.width/2);
    }
}
