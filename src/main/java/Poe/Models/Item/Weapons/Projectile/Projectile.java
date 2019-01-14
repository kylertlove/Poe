package Poe.Models.Item.Weapons.Projectile;

import Poe.Engine.GameLoop;
import Poe.Engine.Input.MouseInput;
import Poe.Models.Item.Item;
import Poe.Models.Item.Weapons.IAttackItems;
import Poe.Engine.Utlities.GameUtils;


public abstract class Projectile extends Item implements IAttackItems {

    public float angleOfProjection = 0;

    /**
     * When activating a Projectile, This sets the starting position and the rotation needed
     * @param x
     * @param y
     */
    public void setInstanceLocation(float x, float y) {
        this.isActive = true;
        this.X = x;
        this.Y = y;
        this.angleOfProjection = GameUtils.getAngle(x, -y, MouseInput.getWorldX(), MouseInput.getWorldY());
    }

    /**
     * Update
     */
    @Override
    public void update() {
        if(GameUtils.isInBounds(this)) {
            this.X = this.X + (float)((this.velocity * GameLoop.getDelta()) * -Math.cos(Math.toRadians((double)angleOfProjection - 90)));
            this.Y = this.Y + (float)((this.velocity * GameLoop.getDelta()) * Math.sin(Math.toRadians((double)angleOfProjection - 90)));
        } else {
            this.destroy();
        }
    }

    @Override
    public float getDamageAmount() {
        return this.damageAmount;
    }
}
