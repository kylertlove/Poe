package Poe.Engine;

import Poe.Engine.Renderer;
import Poe.Utlities.PoeLogger;
import Poe.World.World;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.util.awt.TextRenderer;

import java.awt.*;


public class EventListener implements GLEventListener {

    //The OpenGL render object
    public static GL2 gl = null;
    public static TextRenderer textRenderer;

    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.glEnable(GL2.GL_BLEND);
        gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
        textRenderer = new TextRenderer(new Font(Font.DIALOG, Font.BOLD, 16));
    }

    public void dispose(GLAutoDrawable drawable) {
        PoeLogger.logger.info("Dispose");
    }

    public void display(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glTranslatef(-Renderer.cameraX, -Renderer.cameraY, 0);
        World.render();
        gl.glTranslatef(Renderer.cameraX, Renderer.cameraY, 0);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        gl = drawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-Renderer.getUnitsWide()/2, Renderer.getUnitsWide()/2,
                -Renderer.getUnitsTall()/2, Renderer.getUnitsTall()/2, -1, 1); //Orthoscopic
        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }
}
