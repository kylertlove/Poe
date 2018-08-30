package Poe.Models.Structures;

import Poe.Drawable.Drawable;

public class Wall extends Structure {

    public Wall(float x, float y, float w, float h) {
        this.X = x;
        this.Y = y;
        this.width = w;
        this.height = h;
    }
    
    @Override
    public void render() {
        Drawable.setColor(0, 0, 0, 1);
        Drawable.fillRect(X, Y, width, height);
        Drawable.setColor(1, 1, 1, 1);
    }
}
