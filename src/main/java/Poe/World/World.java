package Poe.World;

import Poe.Models.GameObject;

import java.util.ArrayList;
import java.util.List;

public class World {

    private static List<GameObject> gameObjectList = new ArrayList<GameObject>();

    public static void update() {
        gameObjectList.forEach(gameObject -> gameObject.update());
    }

    public static void render() {
        gameObjectList.forEach(gameObject -> gameObject.render());
    }

    public static void addObject(GameObject go) {
        gameObjectList.add(go);
    }
}
