package Poe.Engine;

import Poe.World.World;

public class Main {

    public static void main(String[] args) {
        World.init();  //Build the Objects
        Renderer.init(); //Build the Window
        GameLoop.start(); //Start the Game
    }
}
