package Poe.GameObjects.Entities;

import Poe.Drawable.Animation;
import Poe.ResourceManager.ImageResource;
import Poe.World.World;

/**
 * tier 2 enemy
 */
public class Captain extends Entity {

	public Captain(long id, int x, int y) {
		this.id = id;
		this.X = x;
		this.Y = y;
		this.velocity = 4;
		this.width = 2.0f;
		this.height = 2.0f;
		this.health = 20;
		this.attackDamage = 7;
		this.viewDistance = 14;
		animations = new Animation[1];
		Animation walking = new Animation();
		walking.frames = new ImageResource[1];
		String uri =  "/Images/Poe_test_1.png";
		walking.frames[0] = new ImageResource(this.getClass().getResourceAsStream(uri));
		animations[0] = walking;
	}

	@Override
	public void destroy() {
		this.isActive = false;
		World.enemies.remove(this.id);
	}
}
