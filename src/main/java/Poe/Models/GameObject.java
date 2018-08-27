package Poe.Models;

import Poe.Drawable.Animation;
import Poe.Drawable.Drawable;

public class GameObject {

    public float x = 0;
    public float y = 0;

    public float width = 5;
    public float height = 5;

    public float rotation = 0;
    public Animation[] animations;
    public int currentAnimation = 0;

    public void update() {

    }

    public void render() {
        animations[currentAnimation].play();
        Drawable.setRotation(rotation);
        Drawable.drawImage(animations[currentAnimation].getImage(), x, y, width, height);
        Drawable.setRotation(0);
    }

}
