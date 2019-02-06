package Poe.Models.Gui;

import Poe.Drawable.Drawable;
import Poe.Engine.Renderer;
import Poe.Models.GameObject;

public class ItemDisplay extends GameObject {

    public ItemDisplay() {
        this.width = 5;
        this.height = 2;
    }

    @Override
    public void update() {
        this.X = Renderer.getUnitsWide() / 2;
        this.Y = Renderer.getUnitsTall() - 2;
    }

    @Override
    public void render() {
        Drawable.setRotation(rotation);
        Drawable.setColor(this.objectColor);
        Drawable.fillRect(this.X, this.Y, this.width, this.height);
        Drawable.setColor(Drawable.DEFAULT_COLOR);
        Drawable.setRotation(0);
    }
}