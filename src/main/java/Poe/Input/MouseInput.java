package Poe.Input;

import Poe.Drawable.Drawable;
import Poe.Engine.Renderer;
import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

public class MouseInput implements MouseListener {

    private static int x = 0;
    private static int y = 0;

    public void mouseClicked(MouseEvent mouseEvent) {

    }

    public void mouseEntered(MouseEvent mouseEvent) {

    }

    public void mouseExited(MouseEvent mouseEvent) {

    }

    public void mousePressed(MouseEvent mouseEvent) {

    }

    public void mouseReleased(MouseEvent mouseEvent) {

    }

    public void mouseMoved(MouseEvent mouseEvent) {
        x = mouseEvent.getX();
        y = mouseEvent.getY();
    }

    public void mouseDragged(MouseEvent mouseEvent) {

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
        return (Renderer.unitsWide / Renderer.getWindowWidth() * x - Renderer.unitsWide / 2) + Renderer.cameraX;
    }

    public static float getWorldY() {
        float unitsTall = Renderer.unitsWide * ((float) Renderer.getWindowHeight() / (float)Renderer.getWindowWidth());
        return -(unitsTall / Renderer.getWindowHeight() * y - unitsTall / 2 + Renderer.cameraY);
    }

}
