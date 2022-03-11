package Poe.Engine.Gui.Elements;

import Poe.GameObjects.ScreenElement;

import java.util.logging.Logger;

public class RectangleGui extends ScreenElement implements MenuElement {

	private static final Logger logger = Logger.getLogger(RectangleGui.class.getName());

	public RectangleGui(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	@Override
	public boolean isClicked(float x, float y) {
		return checkClick(this, x, y);
	}

	@Override
	public void updateLocation(float x, float y, float w, float h) {
		this.X = x;
		this.Y = y;
		this.width = w;
		this.height = h;
	}

	@Override
	public void clickAction(ElementClickAction action) {
		action.performAction();
	}

}
