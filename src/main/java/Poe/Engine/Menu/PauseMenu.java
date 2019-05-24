package Poe.Engine.Menu;

import Poe.Engine.EventListener;
import Poe.Engine.Renderer;

public class PauseMenu {

	public static void renderPauseMenu() {
		EventListener.textRenderer.beginRendering(Renderer.getWindowWidth(), Renderer.getWindowHeight());
			EventListener.textRenderer.draw("Paused", Renderer.getWindowWidth()/2, Renderer.getWindowHeight()/2);
		EventListener.textRenderer.endRendering();
	}
}
