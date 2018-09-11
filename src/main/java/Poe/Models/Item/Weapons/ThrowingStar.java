package Poe.Models.Item.Weapons;

import Poe.Drawable.Drawable;
import Poe.Utlities.GameUtils;
import Poe.World.World;

public class ThrowingStar extends Projectile {

    public ThrowingStar(int damage) {
        this.X = 0;
        this.Y = 0;
        this.width = 0.5f;
        this.height = 0.5f;
        this.velocity = 25;
        this.rotation = 0;
        this.isActive = false;
        this.setObjectColor(0.5f, 0, 0.5f, 1);
        damageAmount = damage;
    }

    @Override
    public void destroy() {
        this.isActive = false;
        World.player.currentlyRangeAttacking = false;
    }


    @Override
    public void render() {
        Drawable.setColor(this.objectColor);
        Drawable.fillRect(this.X, this.Y, this.width, this.height);
        Drawable.setColor(Drawable.DEFAULT_COLOR);
    }

}
