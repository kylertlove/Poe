package Poe.Engine;

import Poe.World.World;

import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("World Init:");
        World.init();  //Build the Objects
        logger.info("GameBoard Init:");
        Renderer.init(); //Build the Window
        logger.info("Game Start:");
        GameLoop.start(); //Start the Game
    }
}
