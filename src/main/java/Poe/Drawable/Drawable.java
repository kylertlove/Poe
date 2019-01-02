package Poe.Drawable;

import Poe.Engine.EventListener;
import Poe.ResourceManager.ImageResource;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;

public class Drawable {

    private static float red = 1;
    private static float green = 1;
    private static float blue = 1;
    private static float alpha = 1;
    public static final float[] DEFAULT_COLOR = new float[]{1, 1, 1, 1};
    private static float rotation = 0;

    public static void fillRect(float x, float y, float width, float height) {
        GL2 gl = EventListener.gl;
        gl.glTranslatef(x, y, 0);
        gl.glRotatef(rotation,0, 0, 1);
        gl.glColor4f(red, green, blue, alpha);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(- width/2, - height/2);
        gl.glVertex2f(width/2, - height/2);
        gl.glVertex2f(width/2, height/2);
        gl.glVertex2f(- width/2, height/2);
        gl.glEnd();
        gl.glFlush();
        gl.glRotatef(-rotation, 0, 0, 1);
        gl.glTranslatef(-x, -y, 0);
    }

    public static void drawVector(float startX, float startY, float endX, float endY) {
        GL2 gl = EventListener.gl;
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2f(startX, startY);
        gl.glVertex2f(endX, endY);
        gl.glEnd();
        gl.glFlush();
    }

    public static void setColor(float[] objectColor) {
        red = Math.max(0, Math.min(1, objectColor[0]));
        green = Math.max(0, Math.min(1, objectColor[1]));
        blue = Math.max(0, Math.min(1, objectColor[2]));
        alpha = Math.max(0, Math.min(1, objectColor[3]));
    }

    public static void setRotation(float r) {
        rotation = -r;
    }

    public static void drawImage(ImageResource imageResource, float x, float y, float width, float height) {
        GL2 gl = EventListener.gl;

        //Bind Texture to gl
        Texture texture = imageResource.getTexture();
        if(texture != null) {
            gl.glBindTexture(GL2.GL_TEXTURE_2D, texture.getTextureObject());
        }
        gl.glTranslatef(x, y, 0);
        gl.glRotatef(rotation,0, 0, 1);
        gl.glColor4f(red, green, blue, alpha);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0, 1);
        gl.glVertex2f(- width/2, - height/2);
        gl.glTexCoord2f(1, 1);
        gl.glVertex2f(width/2, - height/2);
        gl.glTexCoord2f(1, 0);
        gl.glVertex2f(width/2, height/2);
        gl.glTexCoord2f(0, 0);
        gl.glVertex2f(- width/2, height/2);
        gl.glEnd();
        gl.glFlush();
        gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
        gl.glRotatef(-rotation, 0, 0, 1);
        gl.glTranslatef(-x, -y, 0);
    }
}
