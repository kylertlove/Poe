package Poe.GameObjects.Entities.IntelligentEntities;

import Poe.Drawable.Animation;
import Poe.Drawable.ImageResource;
import Poe.World.World;

public class Grunt extends IntelligentEntity {

    public Grunt(long id, int x, int y) {
        super(id, x, y, 1.5f, 1.5f);
        this.velocity = 3;
        this.health = 10;
        this.attackDamage = 4;
    }

    @Override
    protected Animation[] animationBuilder() {
        Animation[] a = new Animation[1];
        Animation walking = new Animation();
        walking.frames = new ImageResource[1];
        String uri =  "/Images/Grunt.png";
        walking.frames[0] = new ImageResource(this.getClass().getResourceAsStream(uri));
        a[0] = walking;
        return a;
    }

    @Override
    public int getViewDistance() {
        return 8;
    }
}
