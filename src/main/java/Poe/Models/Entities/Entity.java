package Poe.Models.Entities;

import Poe.Engine.GameLoop;
import Poe.Models.GameObject;
import Poe.Utlities.GameUtils;

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
    public float destinationX = 0;
    public float destinationY = 0;
    public boolean isTrackingEntity = false;
    public List<GameObject> objectsCollidedWith = new ArrayList<>();

    /**
     * Set Entity to start Tracking passed Entity
     * @param entityToTrack
     */
    public void trackingTarget(Entity entityToTrack) {
        this.destinationX = entityToTrack.X;
        this.destinationY = entityToTrack.Y;
    }

    @Override
    public void update() {
        if(this.isTrackingEntity) {
            float xVal = 0;
            float yVal = 0;

            if(this.destinationX < X && canMoveLeft) {
                xVal -= this.velocity;
            } else if(this.destinationX > X && canMoveRight) {
                xVal += this.velocity;
            }
            if(this.destinationY < Y && canMoveUp) {
                yVal -= this.velocity;
            }else if(this.destinationY > Y && canMoveDown){
                yVal += this.velocity;
            }

            X += xVal * GameLoop.getDelta();
            Y += yVal * GameLoop.getDelta();
            rotation = GameUtils.getAngle(this.destinationX, this.destinationY, X, -Y);
        }
        canMoveLeft = true;
        canMoveUp = true;
        canMoveDown = true;
        canMoveRight = true;
    }
}
