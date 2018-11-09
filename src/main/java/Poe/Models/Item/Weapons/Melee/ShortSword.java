package Poe.Models.Item.Weapons.Melee;

import Poe.Drawable.Drawable;
import Poe.Models.Item.Weapons.IAttackItems;
import Poe.World.World;

public class ShortSword extends Melee {



    public ShortSword() {
        this.strikingDistance = 0.5f;
        this.X = World.player.X;
        this.Y = World.player.Y;
        this.height = 1.0f;
        this.width = 1.0f;
        this.damageAmount = 3.0f;
    }

    @Override
    public void render() {
        Drawable.setRotation(rotation);
        Drawable.setColor(this.objectColor);
        Drawable.fillRect(this.X, this.Y, this.width, this.height);
        Drawable.setColor(Drawable.DEFAULT_COLOR);
        Drawable.setRotation(0);
    }
}
