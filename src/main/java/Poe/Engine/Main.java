package Poe.Engine;

import Poe.Models.GameObject;
import Poe.Models.Player;
import Poe.World.World;

public class Main {

    public static void main(String[] args) {
        Renderer.init();
        GameLoop.start();


        //Test
        World.addObject(new Player());
    }
}
