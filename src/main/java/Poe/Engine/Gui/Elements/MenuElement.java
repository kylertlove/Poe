package Poe.Engine.Gui.Elements;

import Poe.GameObjects.ScreenElement;

public interface MenuElement {

	boolean isClicked(float x, float y);
	void updateLocation(float x, float y, float w, float h);
	void clickAction(ElementClickAction action);

	default boolean checkClick(ScreenElement element, float x, float y) {
		return x < (element.X + element.width/2) &&
				x > (element.X - element.width/2) &&
				y < (element.Y + element.height/2) &&
				y > (element.Y - element.height/2);
	}
}
