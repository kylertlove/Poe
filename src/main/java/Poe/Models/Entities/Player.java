package Poe.Models.Entities;

import Poe.Drawable.Animation;
import Poe.Engine.GameLoop;
import Poe.Input.KeyInput;
import Poe.Input.MouseInput;
import Poe.ResourceManager.ImageResource;
import Poe.Utlities.GameUtils;
import Poe.World.World;
import com.jogamp.newt.event.KeyEvent;
import java.util.ArrayList;

public class Player extends Entity {

    public boolean currentlyRangeAttacking = false;

    public Player() {
        this.id = GameUtils.getId();
        this.width = 2;
        this.height = 2;
        this.velocity = 5;

        animations = new ArrayList<>();
        Animation walking = new Animation();
        walking.frames = new ImageResource[1];
        walking.frames[0] = new ImageResource("src/main/Resources/Images/Poe.png");
        animations.add(walking);
    }

    @Override
    public void update() {
        
        float xInput = 0;
        float yInput = 0;

        if(KeyInput.getKey(KeyEvent.VK_A)) {
            xInput -= velocity;
        }
        if(KeyInput.getKey(KeyEvent.VK_D)) {
            xInput += velocity;
        }
        if(KeyInput.getKey(KeyEvent.VK_W)) {
            yInput += velocity;
        }
        if(KeyInput.getKey(KeyEvent.VK_S)) {
            yInput -= velocity;
        }

        X += xInput * GameLoop.getDelta();
        Y += yInput * GameLoop.getDelta();
        rotation = GameUtils.getAngle(MouseInput.getWorldX(), MouseInput.getWorldY(), X, Y);

        if(KeyInput.getKey(KeyEvent.VK_SPACE) && currentlyRangeAttacking == false) {
            this.rangeAttack();
        }
    }

    public void rangeAttack() {
        this.currentlyRangeAttacking = true;
        //Eventually need to identify what range weapon is being held and activate that
        World.rangeWeapons[0].setInstanceLocation(this.X, this.Y);
    }

}

