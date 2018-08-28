package Poe.Models;

import Poe.Drawable.Animation;
import Poe.Drawable.Drawable;
import Poe.Engine.GameLoop;
import Poe.Input.KeyInput;
import Poe.Input.MouseInput;
import Poe.ResourceManager.ImageResource;
import com.jogamp.newt.event.KeyEvent;

import java.lang.management.ManagementFactory;


public class Player extends GameObject {

    public Player() {
        animations = new Animation[1];
        animations[0] = new Animation();
        animations[0].frames = new ImageResource[3];
        animations[0].frames[0] = new ImageResource("src/main/Resources/Images/MC_Run_1.png");
        animations[0].frames[1] = new ImageResource("src/main/Resources/Images/MC_Run_2.png");
        animations[0].frames[2] = new ImageResource("src/main/Resources/Images/MC_Run_3.png");
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

        x += xInput * GameLoop.updateDelta();
        y += yInput * GameLoop.updateDelta();

        rotation = (float) Math.toDegrees(Math.atan2(MouseInput.getWorldX() - x, MouseInput.getWorldY() - y));
    }
}
