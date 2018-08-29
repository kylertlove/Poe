package Poe.Models;

import Poe.Drawable.Animation;
import Poe.Drawable.Drawable;
import Poe.Utlities.GameUtils;

import java.util.List;

/**
 * Base Object for everything on the board.  Parent class of Entity & Structures
 */
public class GameObject {

    public float X = 0;
    public float Y = 0;
    public float velocity = 0;
    public boolean isActive = true;
    public static int id;

    public float width = 0;
    public float height = 0;

    public float rotation = 0;
    public List<Animation> animations = null;
    public int currentAnimation = 0;

    public void update() {
        throw new Error(this.getClass().getName() + " Needs to implement Update Method");
    }

    public void render() {
        if(animations != null) {
            animations.get(currentAnimation).play();
            Drawable.setRotation(rotation);
            Drawable.drawImage(animations.get(currentAnimation).getImage(), X, Y, width, height);
            Drawable.setRotation(0);
        }
    }

    public void destroy() {
        //Implementation Hook for Objects that can be destroyed
    }
}
