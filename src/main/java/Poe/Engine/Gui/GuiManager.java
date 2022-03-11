package Poe.Engine.Gui;

import Poe.Engine.Gui.Screens.AbstractScreenHandler;
import Poe.Engine.Gui.Screens.DebugScreen;
import Poe.Engine.Gui.Screens.PauseScreen;

public class GuiManager {

	public static AbstractScreenHandler pauseScreen = new PauseScreen();
	public static AbstractScreenHandler debugScreen = new DebugScreen();
}
