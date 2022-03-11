package Poe.Engine.Input;

import Poe.Engine.GameLoop;
import Poe.Engine.Gui.GuiManager;
import Poe.Engine.Renderer;
import Poe.World.World;
import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

import java.util.logging.Logger;

public class MouseInput implements MouseListener {

    private static final Logger logger = Logger.getLogger(MouseInput.class.getName());

    private static int x = 0;
    private static int y = 0;

    public void mouseClicked(MouseEvent mouseEvent) {
    }

    public void mouseEntered(MouseEvent mouseEvent) {

    }

    public void mouseExited(MouseEvent mouseEvent) {

    }

    public void mousePressed(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseEvent.BUTTON3) {
            World.player.rightClick = true;
        }
        if(mouseEvent.getButton() == MouseEvent.BUTTON1) {
            if(GameLoop.paused) {
                GuiManager.pauseScreen.clickHandler(getWorldX(), getWorldY());
            } else {
                World.player.leftClick = true;
            }
        }
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseEvent.BUTTON3) {
            World.player.rightClick = false;
        }
        if(mouseEvent.getButton() == MouseEvent.BUTTON1) {
            World.player.leftClick = false;
        }
    }

    public void mouseMoved(MouseEvent mouseEvent) {
        x = mouseEvent.getX();
        y = mouseEvent.getY();
    }

    public void mouseDragged(MouseEvent mouseEvent) {
        x = mouseEvent.getX();
        y = mouseEvent.getY();
    }

    public void mouseWheelMoved(MouseEvent mouseEvent) {
        World.player.scrollRangeWeapons();
    }

    //X and Y values as pixels
    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    //X and Y as Unit values
    public static float getWorldX() {
        return (Renderer.getUnitsWide() / Renderer.getWindowWidth() * x - Renderer.getUnitsWide() / 2) + Renderer.cameraX;
    }

    public static float getWorldY() {
        return -(Renderer.getUnitsTall() / Renderer.getWindowHeight() * y - Renderer.getUnitsTall() / 2 + Renderer.cameraY);
    }

}
