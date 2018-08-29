package Poe.Models.Item.Weapons;

import Poe.Input.MouseInput;
import Poe.Models.Item.Item;
import Poe.Utlities.GameUtils;

public class Projectile extends Item {


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
        this.rotation = GameUtils.getAngle(x, y, MouseInput.getWorldX(), MouseInput.getWorldY());
    }
}
