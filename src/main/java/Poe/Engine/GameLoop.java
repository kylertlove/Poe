package Poe.Engine;

import Poe.Engine.Menu.PauseMenu;
import Poe.World.World;

import java.util.logging.Logger;

/**
 * GameLoop Class to handle Game Thread
 */
public class GameLoop {

    private static final Logger logger = Logger.getLogger(GameLoop.class.getName());

    public static boolean paused = false;
    private static boolean running = false;
    private static Thread thread;
    private static int fps = 60;
    private static int targetTime = 1000000000 / fps;
    private static int updates = 0;
    private static final int MAX_UPDATES = 5;
    private static long lastUpdateTime = 0;

    public static void start() {
        thread = new Thread(() -> {
            running = true;
            lastUpdateTime = System.nanoTime();
            while (running) {
                    long currentTime = System.nanoTime();
                    //Attempt to throttle update count prior to render.  trying to avoid rubberbanding
                    updates = 0;
                    while (currentTime - lastUpdateTime >= targetTime) {

                        //Main Update Call
                        if(!paused) {
                            World.update();
                        }
                        lastUpdateTime += targetTime;
                        updates++;
                        if(updates > MAX_UPDATES) {
                            break;
                        }
                    }
                    //Render Call
                    Renderer.render();
                    //To make updates seamless, take the remaining FPS time and thread sleep
                    long timeTake = System.nanoTime() - currentTime;
                    if(targetTime > timeTake) {
                        try {
                            Thread.sleep((targetTime - timeTake) / 1000000);
                        } catch (InterruptedException e) {
                            logger.info(e.getMessage());
                            e.printStackTrace();
                        }
                    }
            }
        });
        thread.setName("Main Game Loop");
        thread.start();
    }

    public static float getDelta() {
        return 1.0f / 1000000000 * targetTime;
    }
}
