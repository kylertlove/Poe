package Poe.GameObjects.Structures;

import Poe.Drawable.Drawable;

public class Wall extends Structure {

    /**
     *
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public Wall(float x, float y, float w, float h) {
        super(0, x, y, w, h);
        this.setObjectColor(0, 0, 0, 1);
    }

    @Override
    public void render() {
        Drawable.setColor(this.objectColor);
        Drawable.fillRect(X, Y, width, height);
        Drawable.setColor(Drawable.DEFAULT_COLOR);
    }
}
