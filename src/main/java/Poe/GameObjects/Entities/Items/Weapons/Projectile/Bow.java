package Poe.GameObjects.Entities.Items.Weapons.Projectile;

import Poe.Drawable.Drawable;

public class Bow extends Projectile {

    public Bow() {
        super(0, 0, 0, 0.15f, .75f);
        this.velocity = baseProjectileVelocity + 20;
        this.rotation = 0;
        this.setObjectColor(0.5f, 0, 0.5f, 1);
        this.attackDamage = 10.0f;
        this.defaultProjectileCooldown = 1000;
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
