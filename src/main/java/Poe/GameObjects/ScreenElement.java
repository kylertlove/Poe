package Poe.GameObjects;

/**
 * Base object for anything on the screen
 */
public class ScreenElement {

	public float X = 0;
	public float Y = 0;
	public float width = 0;
	public float height = 0;

	public ScreenElement() {

	}

	public ScreenElement(float x, float y, float w, float h) {
		this.X = x;
		this.Y = y;
		this.width = w;
		this.height = h;
	}
}
