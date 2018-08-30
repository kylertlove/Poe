package Poe.Models.Item.Weapons;

import Poe.Engine.GameLoop;
import Poe.Input.MouseInput;
import Poe.Models.Item.Item;
import Poe.Utlities.GameUtils;


public class Projectile extends Item {

    public static float angleOfProjection = 0;

    /**
     * When activating a Projectile, This sets the starting position and the rotation needed
     * @param x
     * @param y
     */
    public void setInstanceLocation(float x, float y) {
        System.out.println("location: " + x + y);
        this.isActive = true;
        this.X = x;
        this.Y = y;
        this.angleOfProjection = GameUtils.getAngle(x, y, MouseInput.getWorldX(), MouseInput.getWorldY());
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
}
