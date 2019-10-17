package Poe.Engine.Gui.Screens;

import Poe.Drawable.Drawable;
import Poe.Engine.EventListener;
import Poe.Engine.GameLoop;
import Poe.Engine.Gui.Elements.RectangleGui;
import Poe.Engine.Renderer;

import java.util.logging.Logger;

public class PauseScreen implements AbstractScreenHandler {

	private static final float[] buttonColor = new float[]{0.3f, 0.3f, 0.3f, 0.8f};
	private static final Logger logger = Logger.getLogger(PauseScreen.class.getName());
	private static RectangleGui menuBox = new RectangleGui(Renderer.cameraX, Renderer.cameraY,
			Renderer.getUnitsWide() / 2, Renderer.getUnitsTall() - (Renderer.getUnitsTall() / 4));
	private static RectangleGui resumeBtn = new RectangleGui(menuBox.X, menuBox.Y, 4, 2);

	@Override
	public void renderBackground() {
		Drawable.setColor(buttonColor);
		Drawable.setRotation(0);
		menuBox.updateLocation(Renderer.cameraX, Renderer.cameraY,
				Renderer.getUnitsWide() / 2, Renderer.getUnitsTall() - (Renderer.getUnitsTall() / 4));
		Drawable.fillRect(menuBox.X, menuBox.Y, menuBox.width, menuBox.height);
		Drawable.setColor(Drawable.DEFAULT_COLOR);
	}

	@Override
	public void renderForeground() {
		EventListener.textRenderer.beginRendering(Renderer.getWindowWidth(), Renderer.getWindowHeight());
		EventListener.textRenderer.draw("Paused",
				Renderer.getWindowWidth()/2 - (Drawable.getTextWidth("Paused") / 2),
				Renderer.getWindowHeight() - Renderer.getWindowHeight()/3);
		EventListener.textRenderer.endRendering();
		resumeBtn.updateLocation(menuBox.X, -menuBox.Y, 4, 2);
		Drawable.fillRect(resumeBtn.X, -resumeBtn.Y, resumeBtn.width, resumeBtn.height);
	}

	@Override
	public void clickHandler(float x, float y) {
		if(resumeBtn.isClicked(x, y)) {
			resumeBtn.clickAction(() -> GameLoop.paused = !GameLoop.paused);
		}
	}
}
