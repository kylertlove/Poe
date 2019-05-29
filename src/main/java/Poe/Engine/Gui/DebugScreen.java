package Poe.Engine.Gui;

import Poe.Engine.GameLoop;
import Poe.Engine.Renderer;
import Poe.Engine.Utlities.DebuggerUtils;
import Poe.World.World;

public class DebugScreen {

	public static void writeToScreen() {
		if(World.player.isMeleeAttacking()) {
			World.activeMeleeWeapon.render();
		}
		DebuggerUtils.addDebugMessage("Player: X:" +
				Math.round(World.player.X) + ", Y:" +
				Math.round(World.player.Y));
		DebuggerUtils.addDebugMessage("Player Health: " + World.player.health);
		DebuggerUtils.addDebugMessage(World.currentLevel.getLevel());
		DebuggerUtils.addDebugMessage("Window Height: " +
				Renderer.getWindowHeight() +
				", Units Tall: " +
				Renderer.getUnitsTall());
		DebuggerUtils.addDebugMessage("Attacking: " +
				World.player.isMeleeAttacking() + " with " + World.activeMeleeWeapon.getClass().getSimpleName());
		DebuggerUtils.addDebugMessage("Range Weapon: " +
				World.player.activeRangeWeapon
						.getClass()
						.getSimpleName());
		DebuggerUtils.addDebugMessage("Can Range Attack: " + World.player.isCanRangeAttack());
		DebuggerUtils.addDebugMessage("FPS: " + GameLoop.getFps());
		DebuggerUtils.writeToScreen();//debugger
	}
}
