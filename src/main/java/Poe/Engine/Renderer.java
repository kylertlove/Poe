package Poe.Engine;

import Poe.EventListener;
import Poe.Input.KeyInput;
import Poe.Input.MouseInput;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import java.awt.*;
import java.io.File;

public class Renderer {

    private static GLWindow glWindow = null;
    private static GLProfile glProfile = null;
    public static int screenWidth = 1000;
    public static int screenHeight = 500;
    public static float cameraX = 0;
    public static float cameraY = 0;
    private static float unitsWide = 50;

    public static void init(){
        //System.setProperty("newt.window.icons", "null null");
        //System.setProperty("newt.window.icons", "Images"+File.separator+"Poe.png Image"+File.separator+"Poe.png");
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        GLProfile.initSingleton();
        glProfile = GLProfile.get(GLProfile.GL2);
        GLCapabilities glCapabilities = new GLCapabilities(glProfile);
        glWindow = GLWindow.create(glCapabilities);
        glWindow.requestFocus();
        glWindow.setSize(screenWidth, screenHeight);
        glWindow.setTitle("Poe");
        glWindow.addMouseListener(new MouseInput());
        glWindow.addKeyListener(new KeyInput());
        glWindow.addGLEventListener(new EventListener());
        glWindow.setVisible(true);
    }

    public static int getWindowWidth() {
        return glWindow.getWidth();
    }

    public static int getWindowHeight() {
        return glWindow.getHeight();
    }

    public static GLProfile getGlProfile() {
        return glProfile;
    }

    public static void render() {
        if(glWindow == null) {
            return;
        }
        glWindow.display();
    }

    public static float getUnitsWide() {
        return unitsWide;
    }

    public static float getUnitsTall() {
        return unitsWide * ((float) Renderer.getWindowHeight() / (float)Renderer.getWindowWidth());
    }

    public static void updateCamera(float x, float y) {
        cameraX = x;
        cameraY = y;
    }

}
