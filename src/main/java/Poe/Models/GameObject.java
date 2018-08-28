package Poe.Models;

import Poe.Drawable.Animation;
import Poe.Drawable.Drawable;

import java.util.List;

public class GameObject {

    public float X = 0;
    public float Y = 0;

    public float width = 2;
    public float height = 2;

    public float rotation = 0;
    public List<Animation> animations = null;
    public int currentAnimation = 0;

    public void update() {

    }

    public void render() {
        if(animations != null) {
            animations.get(currentAnimation).play();
            Drawable.setRotation(rotation);
            Drawable.drawImage(animations.get(currentAnimation).getImage(), X, Y, width, height);
            Drawable.setRotation(0);
        }
    }
}
