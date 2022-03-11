package Poe.GameObjects.Item.Weapons.Melee;

import Poe.Drawable.Drawable;
import Poe.World.World;

public class ShortSword extends Melee {

    public ShortSword() {
        super(.2f, 200);
        this.height = 1.0f;
        this.width = 1.0f;
        this.damageAmount = 5.0f;
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
