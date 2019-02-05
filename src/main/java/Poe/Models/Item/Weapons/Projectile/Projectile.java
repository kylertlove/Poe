package Poe.Models.Item.Weapons.Projectile;

import Poe.Engine.GameLoop;
import Poe.Engine.Input.MouseInput;
import Poe.Models.Item.Item;
import Poe.Models.Item.Weapons.IAttackItems;
import Poe.Engine.Utlities.GameUtils;
import Poe.Engine.Utlities.MathUtils;

/**
 * Base Projectile Class
 */
public abstract class Projectile extends Item implements IAttackItems {

    public float angleOfProjection = 0;
    public int projectileCooldown = 500;

    /**
     * When activating a Projectile, This sets the starting position and the rotation needed
     * @param x
     * @param y
     */
    public void setInstanceLocation(float x, float y) {
        this.isActive = true;
        this.X = x;
        this.Y = y;
        this.angleOfProjection = MathUtils.getAngle(x, -y, MouseInput.getWorldX(), MouseInput.getWorldY());
    }

    /**
     * Projectile Update
     */
    @Override
    public void update() {
        if(GameUtils.isInBounds(this)) {
            this.X = this.X + (this.velocity * GameLoop.getDelta() 
            * (float)(-Math.cos(Math.toRadians((double)angleOfProjection - 90))));
            this.Y = this.Y + (this.velocity * GameLoop.getDelta() 
            * (float)(Math.sin(Math.toRadians((double)angleOfProjection - 90))));
        } else {
            this.destroy();
        }
    }

    /**
     * Return Damage Amount of Projectile
     */
    @Override
    public float getDamageAmount() {
        return this.damageAmount;
    }
}
