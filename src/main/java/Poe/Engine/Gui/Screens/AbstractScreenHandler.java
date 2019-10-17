package Poe.Engine.Gui.Screens;

public interface AbstractScreenHandler {

	default void openGui() {
		renderBackground();
		renderForeground();
	}

	void renderBackground();

	void renderForeground();

	default void clickHandler(float x, float y) { }
}
