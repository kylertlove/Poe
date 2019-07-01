package Poe.GameObjects.Item.Weapons.Projectile;

import Poe.Engine.GameLoop;
import Poe.Engine.Input.MouseInput;
import Poe.GameObjects.Item.Item;
import Poe.GameObjects.Item.Weapons.IAttackItems;
import Poe.Engine.Utlities.GameUtils;
import Poe.Engine.Utlities.MathUtils;

import java.util.function.Predicate;

/**
 * Base Projectile Class
 */
public abstract class Projectile extends Item implements IAttackItems {

    public float angleOfProjection = 0;
    protected int defaultProjectileCooldown = 500;
    protected int BASE_PROJECTILE_VELOCITY = 25;

    /**
     * When activating a Projectile, This sets the starting position and the rotation needed
     * @param x
     * @param y
     */
    public void setInstanceLocation(float x, float y) {
        this.isActive = true;
        this.X = x;
        this.Y = y;
        this.angleOfProjection = this.getAngleOfProjection();
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

    @Override
    public int getActionCooldown() {
        return this.defaultProjectileCooldown;
    }

    /**
     * Return Damage Amount of Projectile
     */
    @Override
    public float getDamageAmount() {
        return this.damageAmount;
    }

    @Override
    public float getAngleOfProjection() {
        return MathUtils.getAngle(this.X, -this.Y, MouseInput.getWorldX(), MouseInput.getWorldY());
    }

    public static Predicate<Projectile> isProjectileActive = projectile -> projectile != null && projectile.isActive;
}
