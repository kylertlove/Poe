package Poe.Engine.Menu;

import Poe.Drawable.Drawable;
import Poe.Engine.EventListener;
import Poe.Engine.GameLoop;
import Poe.Engine.Renderer;
import Poe.GameObjects.GameObject;

import java.util.logging.Logger;

public class PauseMenu {

	private static final float[] buttonColor = new float[]{0, 0, 0, 0};
	private static final Logger logger = Logger.getLogger(PauseMenu.class.getName());

	public static void renderPauseMenu() {
		EventListener.textRenderer.beginRendering(Renderer.getWindowWidth(), Renderer.getWindowHeight());
		EventListener.textRenderer.draw("Paused", Renderer.getWindowWidth()/2 - 35, Renderer.getWindowHeight() - Renderer.getWindowHeight()/3);
		EventListener.textRenderer.endRendering();
		Drawable.setColor(buttonColor);
		Drawable.fillRect(Renderer.getWindowWidth()/2 - 100, Renderer.getWindowHeight()/2, 60, 40);
		Drawable.setColor(Drawable.DEFAULT_COLOR);
	}

	public static void clickHandler() {

	}
}
