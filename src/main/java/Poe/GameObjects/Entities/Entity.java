package Poe.GameObjects.Entities;

import Poe.Engine.GameLoop;
import Poe.GameObjects.GameObject;
import Poe.World.World;
import Poe.Engine.Utlities.GameUtils;
import Poe.Engine.Utlities.MathUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Base Class for all "Living" GameObjects
 */
public class Entity extends GameObject {

    public boolean canMoveUp = true;
    public boolean canMoveDown = true;
    public boolean canMoveLeft = true;
    public boolean canMoveRight = true;
    public float viewDistance = 5;
    public boolean isTrackingEntity = false;
    public boolean isAttackingEntity = false;
    public boolean attackCooldownFinished = true;
    public List<GameObject> objectsCollidedWith = new ArrayList<>();
    protected float destinationX = 0;
    protected float destinationY = 0;
    protected float attackDamage = 1;
    //identifier for player object
    protected boolean canRangeAttack = true;
    protected boolean isMeleeAttacking = false;

    /**
     * Set Entity to start Tracking passed Entity
     * @param entityToTrack
     */
    public void trackingTarget(Entity entityToTrack) {
        this.destinationX = entityToTrack.X;
        this.destinationY = entityToTrack.Y;
    }

	/**
	 * Overridden Update from Gameobject.  used for movement tracking
	 */
	@Override
    public void update() {
        if(this.isTrackingEntity) {
            float xVal = 0;
            float yVal = 0;

            if(this.destinationX < X && canMoveLeft) {
                xVal -= this.velocity;
            } 
            if(this.destinationX > X && canMoveRight) {
                xVal += this.velocity;
            }
            if(this.destinationY < Y && canMoveDown) {
                yVal -= this.velocity;
            }
            if(this.destinationY > Y && canMoveUp){
                yVal += this.velocity;
            }

            X += xVal * GameLoop.getDelta();
            Y += yVal * GameLoop.getDelta();
            rotation = MathUtils.getAngle(this.destinationX, this.destinationY, X, Y);
            if((!canMoveDown || !canMoveLeft || !canMoveRight || !canMoveUp) 
            && isAttackingEntity
            && attackCooldownFinished) {
                attackCooldownFinished = false;
                World.player.recieveHit(this.attackDamage);
                GameUtils.setTimeout(() -> attackCooldownFinished = true, 1200);
            }
        }
        canMoveLeft = true;
        canMoveUp = true;
        canMoveDown = true;
        canMoveRight = true;
    }

    public boolean isCanRangeAttack() {
        return this.canRangeAttack;
    }

    public boolean isMeleeAttacking() { return this.isMeleeAttacking; }
}
