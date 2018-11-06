package Poe.Utlities;

import Poe.Engine.Renderer;
import Poe.EventListener;
import Poe.World.World;
import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.util.HashMap;
import java.util.Map;

public class DebuggerUtils {

    private static int totalDebugMsgs = 1;
    private static Map<Integer, String> debugMap = new HashMap<Integer, String>();

    public static void addDebugMessage(String msg) {
        totalDebugMsgs++;
        debugMap.put(totalDebugMsgs, msg);
    }

    public static void writeToScreen() {
        if(World.debug){
            EventListener.textRenderer.beginRendering(Renderer.getWindowWidth(), Renderer.getWindowHeight());
            debugMap.forEach((index, message) -> {
                EventListener.textRenderer.draw(message, 10, Renderer.getWindowHeight() - (16 * index));
            });
            EventListener.textRenderer.endRendering();
        }
        totalDebugMsgs = 1;
        debugMap = new HashMap<Integer, String>();
    }
}
