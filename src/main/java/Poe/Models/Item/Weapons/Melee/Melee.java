package Poe.Models.Item.Weapons.Melee;

import Poe.Engine.Utlities.CollisionDetector;
import Poe.Engine.Input.MouseInput;
import Poe.Models.Entities.Entity;
import Poe.Models.Item.Item;
import Poe.Models.Item.Weapons.IAttackItems;
import Poe.Engine.Utlities.MathUtils;
import Poe.World.World;

public class Melee extends Item implements IAttackItems {

    public float strikingDistance = 0.5f;
    public float angleOfProjection;

    public void attack(Entity entity) {
        if(CollisionDetector.isCollided(this, entity)) {
            entity.recieveHit(this.getDamageAmount());
        }

    }

    @Override
    public void update() {
        angleOfProjection = MathUtils.getAngle(World.player.X, -World.player.Y, MouseInput.getWorldX(), MouseInput.getWorldY());
        this.X = World.player.X + (this.width + this.strikingDistance)  
                * (float)(-Math.cos(Math.toRadians((double)angleOfProjection - 90)));
        this.Y = World.player.Y + (this.height + this.strikingDistance)
                * (float)(Math.sin(Math.toRadians((double)angleOfProjection - 90)));
    }

    @Override
    public float getDamageAmount() {
        return this.damageAmount;
    }
}
