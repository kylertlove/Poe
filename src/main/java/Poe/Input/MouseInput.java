package Poe.Input;

import Poe.Engine.Renderer;
import Poe.Models.Entities.Grunt;
import Poe.Utlities.PoeLogger;
import Poe.World.World;
import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

public class MouseInput implements MouseListener {

    private static int x = 0;
    private static int y = 0;

    public void mouseClicked(MouseEvent mouseEvent) {
        //PoeLogger.logger.info("Mouse Click: X: " + getWorldX() + ", Y: " + getWorldY() + " Player x: " + World.player.X + " player y: " + World.player.Y);
    }

    public void mouseEntered(MouseEvent mouseEvent) {

    }

    public void mouseExited(MouseEvent mouseEvent) {

    }

    public void mousePressed(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseEvent.BUTTON3) {
            World.player.rangeClick = true;
        }
        if(mouseEvent.getButton() == MouseEvent.BUTTON1) {
            World.player.meleeClick = true;
        }
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseEvent.BUTTON3) {
            World.player.rangeClick = false;
        }
        if(mouseEvent.getButton() == MouseEvent.BUTTON1) {
            World.player.meleeClick = false;
            World.player.currentlyMeleeAttacking = false;
            World.activeMeleeWeapon.isActive = false;
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
