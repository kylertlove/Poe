package Poe.Drawable;

import Poe.ResourceManager.ImageResource;

public class Animation {

    public ImageResource[] frames;
    private int currentFrame = 0;
    public boolean shouldLoop = true;

    public int fps = 8;
    public long lastFrameTime = 0;

    public void play() {
        long currentTime = System.nanoTime();

        if(currentTime > lastFrameTime + 1000000000 / fps) {
            currentFrame++;
            if(currentFrame >= frames.length) {
                if(shouldLoop) {
                    currentFrame = 0;
                }else {
                    currentFrame--;
                }
            }
            lastFrameTime = currentTime;
        }
    }

    public ImageResource getImage() {
        return frames[currentFrame];
    }
}
