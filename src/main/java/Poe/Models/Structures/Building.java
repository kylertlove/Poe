package Poe.Models.Structures;

import Poe.Drawable.Drawable;

public class Building extends Structure {


    public Building(float x, float y, float w, float h) {
        this.X = x;
        this.Y = y;
        this.width = w;
        this.height = h;
        this.setObjectColor(0, 0, 0, 1);
    }

    @Override
    public void render() {
        Drawable.setColor(this.objectColor);
        Drawable.fillRect(X, Y, width, height);
        Drawable.setColor(Drawable.DEFAULT_COLOR);
    }

    /**
     * Build the structure
     * @return
     */
    public Wall[] buildStructure() {
        //top wall
        Wall w1 = new Wall(this.X + (this.width/2), this.Y + (this.height / 2), this.width, 1);
        //Left Side
        Wall w2 = new Wall(this.X, this.Y, 1, this.height);
        //right side
        Wall w3 = new Wall(this.X + this.width, this.Y, 1, this.height);
        return new Wall[]{ w1, w2, w3 };
    }

}
