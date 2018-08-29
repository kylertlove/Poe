package Poe.Models.Item.Weapons;

import Poe.Drawable.Drawable;
import Poe.Engine.GameLoop;
import Poe.Utlities.GameUtils;
import Poe.World.World;

public class ThrowingStar extends Projectile {

    public ThrowingStar() {
        this.id = GameUtils.getId();
        this.X = 0;
        this.Y = 0;
        this.width = 0.5f;
        this.height = 0.5f;
        this.velocity = 15;
        this.rotation = 0;
        this.isActive = false;
    }

    @Override
    public void destroy() {
        this.isActive = false;
        World.player.currentlyRangeAttacking = false;
    }

    @Override
    public void update() {
        if(GameUtils.isInBounds(this)) {
            this.X = this.X + ((this.velocity * GameLoop.getDelta()) * (float)Math.cos((double)rotation));
            this.Y = this.Y + ((this.velocity * GameLoop.getDelta()) * (float)Math.sin((double)rotation));
        } else {
            this.destroy();
        }
    }

    @Override
    public void render() {
        Drawable.setColor(0.5f, 0, 0.5f, 1);
        Drawable.fillRect(this.X, this.Y, this.width, this.height);
        Drawable.setColor(1, 1, 1, 1);
    }

}
