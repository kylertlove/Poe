package Poe.GameObjects.Entities.IntelligentEntities;

import Poe.Drawable.Animation;
import Poe.Drawable.ImageResource;
import Poe.World.World;

/**
 * tier 2 enemy
 */
public class Captain extends IntelligentEntity {

	public Captain(long id, int x, int y) {
		super(id, x, y, 2.0f, 2.0f);
		this.velocity = 4;
		this.health = 20;
		this.attackDamage = 7;
	}

	@Override
	protected Animation[] animationBuilder() {
		Animation[] a = new Animation[1];
		Animation walking = new Animation();
		walking.frames = new ImageResource[1];
		String uri =  "/Images/Poe_test_1.png";
		walking.frames[0] = new ImageResource(this.getClass().getResourceAsStream(uri));
		a[0] = walking;
		return a;
	}

	@Override
	public int getViewDistance() {
		return 14;
	}
}
