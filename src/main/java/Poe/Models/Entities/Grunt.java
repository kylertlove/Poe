package Poe.Models.Entities;

import Poe.Drawable.Drawable;
import Poe.Utlities.GameUtils;
import Poe.Utlities.PoeLogger;
import Poe.World.World;

public class Grunt extends Entity {

    public Grunt(int x, int y, int width, int height) {
        this.id = GameUtils.getId();
        this.X = x;
        this.Y = y;
        this.width = width;
        this.height = height;
        this.health = 10;
        this.setObjectColor(0.5f, 0, 0, 1);
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        Drawable.setColor(this.objectColor);
        Drawable.fillRect(X, Y, width, height);
        Drawable.setColor(Drawable.DEFAULT_COLOR);
    }

    @Override
    public void destroy() {
        this.isActive = false;
        World.enemies.remove(this.id);
    }
}
