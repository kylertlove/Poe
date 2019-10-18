package Poe.GameObjects.Entities.Items.Weapons.Melee;

import Poe.Drawable.Drawable;

public class ShortSword extends Melee {

    public ShortSword() {
        super(0, 0, 0, 1.0f, 1.0f);
        this.strikingDistance = 0.2f;
        this.attackDamage = 5.0f;
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
