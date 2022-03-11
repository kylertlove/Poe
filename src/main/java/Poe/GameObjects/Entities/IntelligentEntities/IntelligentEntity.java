package Poe.GameObjects.Entities.IntelligentEntities;

import Poe.Engine.GameLoop;
import Poe.Engine.Utlities.GameUtils;
import Poe.Engine.Utlities.MathUtils;
import Poe.GameObjects.Entities.Entity;
import Poe.GameObjects.GameObject;
import Poe.World.World;

import java.util.ArrayList;
import java.util.List;

public abstract class IntelligentEntity extends Entity implements DetectableEntity {

	public List<GameObject> objectsCollidedWith = new ArrayList<>();
	public boolean isTrackingPlayerEntity = false;
	protected float destinationX = 0;
	protected float destinationY = 0;
	public boolean canMoveUp = true;
	public boolean canMoveDown = true;
	public boolean canMoveLeft = true;
	public boolean canMoveRight = true;
	public boolean isAttackingEntity = false;
	public boolean attackCooldownFinished = true;

	public IntelligentEntity(long id, int x, float y, float w, float h) {
		super(id, x, y, w, h);
	}

	/**
	 * Overridden Update from Gameobject.  used for movement tracking.
	 */
	@Override
	public void update() {
		if(this.isTrackingPlayerEntity) {
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
			attackPlayerEntity();
		}
		canMoveLeft = true;
		canMoveUp = true;
		canMoveDown = true;
		canMoveRight = true;
	}

	/**
	 * Set Entity to start Tracking passed Entity
	 * @param entityToTrack
	 */
	public void trackingTarget(Entity entityToTrack) {
		this.destinationX = entityToTrack.X;
		this.destinationY = entityToTrack.Y;
	}

	private void attackPlayerEntity() {
		if((!canMoveDown || !canMoveLeft || !canMoveRight || !canMoveUp)
				&& isAttackingEntity
				&& attackCooldownFinished) {
			attackCooldownFinished = false;
			World.player.recieveHit(this.attackDamage);
			GameUtils.setTimeout(() -> attackCooldownFinished = true, 1200);
		}
	}

	@Override
	public void destroy() {
		this.isActive = false;
		World.enemies.remove(this.id);
	}
}
