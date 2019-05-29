package Poe.Engine.Gui;

import Poe.Drawable.Drawable;
import Poe.Engine.EventListener;
import Poe.Engine.Renderer;
import Poe.World.World;

import java.util.logging.Logger;

public class PauseMenu {

	private static final float[] buttonColor = new float[]{0, 0, 0, 1};
	private static final Logger logger = Logger.getLogger(PauseMenu.class.getName());

	public static void renderPauseMenu() {
		EventListener.textRenderer.beginRendering(Renderer.getWindowWidth(), Renderer.getWindowHeight());
		EventListener.textRenderer.draw("Paused",
				Renderer.getWindowWidth()/2 - (Drawable.getTextWidth("Paused") / 2),
				Renderer.getWindowHeight() - Renderer.getWindowHeight()/3);
		EventListener.textRenderer.endRendering();
		Drawable.setColor(buttonColor);
		Drawable.setRotation(0);
		Drawable.fillRect((float)(World.player.X - 5),
						  (float)(World.player.Y - 4),
						  6,
						  2);
		Drawable.setColor(Drawable.DEFAULT_COLOR);
	}

	public static void clickHandler() {

	}
}
