package Poe;


import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

public class Poe {

    private static GLWindow glWindow = null;

    public static void main(String[] args) {
        init();
    }

    public static void init(){
        GLProfile.initSingleton();
        GLProfile glProfile = GLProfile.get(GLProfile.GL2);
        GLCapabilities glCapabilities = new GLCapabilities(glProfile);
        glWindow = GLWindow.create(glCapabilities);
        glWindow.setSize(640, 360);
        glWindow.setTitle("Poe");
        glWindow.addGLEventListener(new EventListener());
        FPSAnimator fpsAnimator = new FPSAnimator(glWindow, 60);
        fpsAnimator.start();

        glWindow.setVisible(true);
    }

}
