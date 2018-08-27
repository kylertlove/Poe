package Poe;

import Poe.Drawable.Drawable;
import Poe.Engine.Renderer;
import Poe.ResourceManager.ImageResource;
import Poe.World.World;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;


public class EventListener implements GLEventListener {

    public static GL2 gl = null;
    public static ImageResource image = null;

    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        gl.glClearColor(0, 0, 0, 1);
        gl.glEnable(GL2.GL_TEXTURE_2D);
        image = new ImageResource("src/main/Resources/Images/playerShip.png");
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

        float unitsTall = Renderer.getWindowHeight()/ (Renderer.getWindowWidth()/Renderer.unitsWide);

        gl.glOrtho(-Renderer.unitsWide/2, Renderer.unitsWide/2, -unitsTall/2, unitsTall/2, -1, 1); //locations of Orthoscopic
        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }
}
