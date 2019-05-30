package Poe.GameObjects.Item.Weapons.Melee;

import Poe.Drawable.Drawable;
import Poe.World.World;

public class ShortSword extends Melee {

    public ShortSword() {
        this.strikingDistance = 0.2f;
        this.height = 1.0f;
        this.width = 1.0f;
        this.damageAmount = 5.0f;
        this.meleeActionCooldown = 200;
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
