package Poe.GameObjects.Entities;

import Poe.GameObjects.GameObject;

public abstract class Entity extends GameObject {

    protected float attackDamage = 1;
    public float velocity = 0;
    //identifier for player object
    protected boolean canRangeAttack = true;
    protected boolean isMeleeAttacking = false;

    public Entity(long id, float x, float y, float w, float h) {
        super(id, x, y, w, h);
        animations = animationBuilder();
    }

    public boolean isCanRangeAttack() {
        return this.canRangeAttack;
    }

    public boolean isMeleeAttacking() { return this.isMeleeAttacking; }
}
