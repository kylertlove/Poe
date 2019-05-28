package Poe.Models;

import Poe.Drawable.Animation;
import Poe.Drawable.Drawable;

import java.util.List;
import java.util.logging.Logger;

/**
 * Base Object for everything on the board.  Parent class of Entity, Structures, And Item
 */
public class GameObject {

    private static final Logger logger = Logger.getLogger(GameObject.class.getName());

    public float X = 0;
    public long id = 0;
    public float Y = 0;
    public float velocity = 0;
    public boolean isActive = false;
    public float[] objectColor = new float[]{1, 1, 1, 1};
    public float width = 0;
    public float height = 0;
    public int health = 0;

    public float rotation = 0;
    public Animation[] animations = null;
    public int currentAnimation = 0;

    public void update() {
        throw new Error(this.getClass().getName() + " Needs to implement Update Method");
    }

    public void render() {
        if(animations != null) {
            animations[currentAnimation].play();
            Drawable.setRotation(rotation);
            Drawable.drawImage(animations[currentAnimation].getImage(), X, Y, width, height);
            Drawable.setRotation(0);
        }
    }

    public void setObjectColor(float r, float g, float b, float a) {
        this.objectColor = new float[]{r, g, b, a};
    }

    public void destroy() {
        logger.info("Game Object Instance has no Destroy Implementation");
    }

    public void recieveHit(float hitAmount) {
        this.health -= hitAmount;
        if(this.health <= 0) {
            this.destroy();
        }
    }
}
