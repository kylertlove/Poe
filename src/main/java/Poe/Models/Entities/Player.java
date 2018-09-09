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
import java.io.InputStream;
import java.net.URL;
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
        InputStream stream = this. getClass().getResourceAsStream(File.separator + "Images" + File.separator+ "Poe.png");
        //URL url = this.getClass().getResource(File.separator + "Images" + File.separator+ "Poe.png");
        walking.frames[0] = new ImageResource(stream);
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

        if(KeyInput.getKey(KeyEvent.VK_SPACE) && currentlyRangeAttacking == false) {
            this.rangeAttack();
        }
        canMoveLeft = true;
        canMoveUp = true;
        canMoveDown = true;
        canMoveRight = true;
    }

    public void rangeAttack() {
//        PoeLogger.logger.info(X+" : "+MouseInput.getWorldX());
//        PoeLogger.logger.info(-Y+" : "+MouseInput.getWorldY());
        this.currentlyRangeAttacking = true;
        //Eventually need to identify what range weapon is being held and activate that
        World.rangeWeapons[0].setInstanceLocation(this.X, this.Y);
    }

}

