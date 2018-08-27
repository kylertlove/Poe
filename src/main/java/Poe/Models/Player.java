package Poe.Models;

import Poe.Drawable.Animation;
import Poe.Drawable.Drawable;
import Poe.ResourceManager.ImageResource;

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

    }
}
