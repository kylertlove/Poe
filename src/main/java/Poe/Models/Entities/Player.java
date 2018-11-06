package Poe.Models.Entities;

import Poe.Drawable.Animation;
import Poe.Engine.GameLoop;
import Poe.Input.KeyInput;
import Poe.Input.MouseInput;
import Poe.ResourceManager.ImageResource;
import Poe.Utlities.GameUtils;
import Poe.Utlities.PoeLogger;
import Poe.World.World;
import com.jogamp.newt.event.KeyEvent;

import java.io.File;
import java.util.ArrayList;

public class Player extends Entity {

    public boolean currentlyRangeAttacking = false;
    public boolean rangeClick = false;
    public static final int DEFAULT_DAMAGE = 3;

    public Player() {
        this.width = 1.5f;
        this.height = 1.5f;
        this.velocity = 6;
        this.id = World.currentLevel.generateId();
        animations = new ArrayList<>();
        Animation walking = new Animation();
        walking.frames = new ImageResource[1];
        String uri =  "/Images/Poe.png";
        walking.frames[0] = new ImageResource(this.getClass().getResourceAsStream(uri));
        animations.add(walking);
    }

    @Override
    public void update() {

        float xInput = 0;
        float yInput = 0;

        if(KeyInput.getKey(KeyEvent.VK_A) && canMoveLeft) {
            xInput -= velocity;
        }
        if(KeyInput.getKey(KeyEvent.VK_D) && canMoveRight) {
            xInput += velocity;
        }
        if(KeyInput.getKey(KeyEvent.VK_W) && canMoveUp) {
            yInput += velocity;
        }
        if(KeyInput.getKey(KeyEvent.VK_S) && canMoveDown) {
            yInput -= velocity;
        }

        X += xInput * GameLoop.getDelta();
        Y += yInput * GameLoop.getDelta();
        rotation = GameUtils.getAngle(MouseInput.getWorldX(), MouseInput.getWorldY(), X, -Y);

        if(rangeClick && !currentlyRangeAttacking) {
            this.rangeAttack();
        }
        canMoveLeft = true;
        canMoveUp = true;
        canMoveDown = true;
        canMoveRight = true;
    }

    public void rangeAttack() {
        this.currentlyRangeAttacking = true;
        World.activeRangeWeapon.setInstanceLocation(this.X, this.Y);
    }

    @Override
    public void recieveHit(int hitAmount) {
        this.health -= hitAmount;
    }

}

