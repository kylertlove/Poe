package Poe.Models.Entities;

import Poe.Drawable.Animation;
import Poe.ResourceManager.ImageResource;
import Poe.World.World;

import java.util.ArrayList;

public class Grunt extends Entity {

    public Grunt(long id, int x, int y) {
        this.id = id;
        this.X = x;
        this.Y = y;
        this.velocity = 3;
        this.width = 1.5f;
        this.height = 1.5f;
        this.health = 10;
        this.viewDistance = 8;
        animations = new ArrayList<>();
        Animation walking = new Animation();
        walking.frames = new ImageResource[1];
        String uri =  "/Images/Grunt.png";
        walking.frames[0] = new ImageResource(this.getClass().getResourceAsStream(uri));
        animations.add(walking);
    }

    @Override
    public void destroy() {
        this.isActive = false;
        World.enemies.remove(this.id);
    }
}
