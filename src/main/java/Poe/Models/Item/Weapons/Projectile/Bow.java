package Poe.Models.Item.Weapons.Projectile;

import Poe.Drawable.Drawable;

public class Bow extends Projectile {

    public Bow() {
        this.X = 0;
        this.Y = 0;
        this.width = 0.25f;
        this.height = 1.0f;
        this.velocity = 25;
        this.rotation = 0;
        this.setObjectColor(0.5f, 0, 0.5f, 1);
        this.damageAmount = 10.0f;
        this.projectileCooldown = 1000;
    }

    @Override
    public void destroy() {
        this.isActive = false;
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
