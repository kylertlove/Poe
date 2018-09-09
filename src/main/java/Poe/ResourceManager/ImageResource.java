package Poe.ResourceManager;

import Poe.Engine.Renderer;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ImageResource {

    private Texture texture = null;
    private BufferedImage image = null;

    public ImageResource(InputStream stream) {
        try {
            image = ImageIO.read(stream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        if(image != null) {
            image.flush();
        }
    }

    public Texture getTexture() {
        if(image == null) {
            return null;
        }
        if(texture == null) {
            texture = AWTTextureIO.newTexture(Renderer.getGlProfile(), image, true);
        }
        return texture;
    }
}
