package Poe.Models;

import Poe.Drawable.Animation;
import Poe.Engine.GameLoop;
import Poe.Input.KeyInput;
import Poe.Input.MouseInput;
import Poe.ResourceManager.ImageResource;
import com.jogamp.newt.event.KeyEvent;

import java.util.ArrayList;

public class Player extends Entity {

    public Player() {
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
            xInput -= 5;
        }
        if(KeyInput.getKey(KeyEvent.VK_D)) {
            xInput += 5;
        }
        if(KeyInput.getKey(KeyEvent.VK_W)) {
            yInput += 5;
        }
        if(KeyInput.getKey(KeyEvent.VK_S)) {
            yInput -= 5;
        }

        X += xInput * GameLoop.getDelta();
        Y += yInput * GameLoop.getDelta();
        rotation = (float) Math.toDegrees(Math.atan2(MouseInput.getWorldX() - X, MouseInput.getWorldY() - Y));
    }

}

