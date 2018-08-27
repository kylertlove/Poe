package Poe.ResourceManager;

import Poe.Engine.Renderer;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageResource {

    private Texture texture = null;
    private BufferedImage image = null;

    public ImageResource(String path) {
        try {
            File file = new File(path);
            image = ImageIO.read(file);
            if(image == null) {
                throw new Error("Image Not Found");
            }
        } catch (IOException e) {
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
