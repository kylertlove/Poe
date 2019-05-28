package Poe.GameObjects.Item.Weapons.Melee;

import Poe.Engine.Utlities.CollisionDetector;
import Poe.Engine.Input.MouseInput;
import Poe.GameObjects.Entities.Entity;
import Poe.GameObjects.Item.Item;
import Poe.GameObjects.Item.Weapons.IAttackItems;
import Poe.Engine.Utlities.MathUtils;
import Poe.World.World;

public abstract class Melee extends Item implements IAttackItems {

    public float strikingDistance = 0.5f;
    public float angleOfProjection = 0.0f;
    protected int meleeActionCooldown = 150;

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

    @Override
    public int getActionCooldown() {
        return this.meleeActionCooldown;
    }
}
