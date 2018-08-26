package Poe;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class EventListener implements GLEventListener {

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL().getGL2();
        gl.glClearColor(0, 0, 0, 1);
    }

    public void dispose(GLAutoDrawable drawable) {
        System.out.println("Dispose");
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

        ((GL2) gl).glColor3f(0.5f, 0, 0.5f);
        ((GL2) gl).glBegin(GL2.GL_QUADS);
        ((GL2) gl).glVertex2f(-0.5f, -0.5f);
        ((GL2) gl).glVertex2f(0.5f, -0.5f);
        ((GL2) gl).glVertex2f(0.5f, 0.5f);
        ((GL2) gl).glVertex2f(-0.5f, 0.5f);

        ((GL2) gl).glEnd();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
//        GL gl = drawable.getGL().getGL2();
//        ((GL2) gl).glMatrixMode(GL2.GL_PROJECTION);
//        ((GL2) gl).glLoadIdentity();
//        ((GL2) gl).glOrtho();
    }
}
