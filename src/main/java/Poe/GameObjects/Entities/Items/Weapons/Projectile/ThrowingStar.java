package Poe.GameObjects.Entities.Items.Weapons.Projectile;

import Poe.Drawable.Drawable;

public class ThrowingStar extends Projectile {

    public ThrowingStar() {
        super(0, 0, 0, 0.5f, 0.5f);
        this.velocity = baseProjectileVelocity + 10;
        this.rotation = 0;
        this.setObjectColor(0.5f, 0, 0.5f, 1);
        this.attackDamage = 6.0f;
        this.defaultProjectileCooldown = 600;
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
