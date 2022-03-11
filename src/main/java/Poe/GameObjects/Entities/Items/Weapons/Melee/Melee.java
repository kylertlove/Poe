package Poe.GameObjects.Entities.Items.Weapons.Melee;

import Poe.Engine.Detection.CollisionDetector;
import Poe.Engine.Input.MouseInput;
import Poe.GameObjects.Entities.Entity;
import Poe.GameObjects.Entities.Items.Item;
import Poe.GameObjects.Entities.Items.Weapons.AttackItems;
import Poe.Engine.Utlities.MathUtils;
import Poe.World.World;

public abstract class Melee extends Item implements AttackItems {

    protected float strikingDistance = 0.5f;
    protected float angleOfProjection = 0.0f;
    protected int meleeActionCooldown = 150;

    public Melee(long id, float x, float y, float w, float h) {
        super(id, x, y, w, h);
    }

    public void attack(Entity entity) {
        if(CollisionDetector.isCollided(this, entity)) {
            entity.recieveHit(this.getDamageAmount());
        }
    }

    @Override
    public void update() {
        angleOfProjection = this.getAngleOfProjection();
        this.X = World.player.X + (this.width + this.strikingDistance)  
                * (float)(-Math.cos(Math.toRadians((double)angleOfProjection - 90)));
        this.Y = World.player.Y + (this.height + this.strikingDistance)
                * (float)(Math.sin(Math.toRadians((double)angleOfProjection - 90)));
    }

    @Override
    public float getDamageAmount() {
        return this.attackDamage;
    }

    @Override
    public int getActionCooldown() {
        return this.meleeActionCooldown;
    }

    @Override
    public float getAngleOfProjection() {
        return MathUtils.getAngle(World.player.X, -World.player.Y, MouseInput.getWorldX(), MouseInput.getWorldY());
    }
}
