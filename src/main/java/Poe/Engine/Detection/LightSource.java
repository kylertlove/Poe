package Poe.Engine.Detection;

import Poe.Drawable.Drawable;
import Poe.GameObjects.GameObject;

public class LightSource extends GameObject {

	public LightSource(float x, float y, float angle, float sides){
		super(0, x, y, angle, sides);
	}

	@Override
	public void render() {
		Drawable.fillPolygon(0, 0, this.width, this.height);
		Drawable.fillPolygon(0, 0, this.width * 2.5f, this.height * 2.5f);
		Drawable.fillPolygon(0, 0, this.width * 4.0f, this.height * 4.0f);
	}

	public float getAngle() {
		return this.width;
	}

	public float getSides() {
		return this.height;
	}
}
