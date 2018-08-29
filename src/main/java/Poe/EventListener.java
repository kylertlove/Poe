package Poe;

import Poe.Engine.Renderer;
import Poe.World.World;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;


public class EventListener implements GLEventListener {

    public static GL2 gl = null;

    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        gl.glClearColor(0, 0, 0, 1);
        gl.glEnable(GL2.GL_TEXTURE_2D);
    }

    public void dispose(GLAutoDrawable drawable) {
        System.out.println("Dispose");
    }

    public void display(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        World.render();
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
