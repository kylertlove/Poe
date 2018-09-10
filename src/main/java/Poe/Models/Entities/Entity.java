package Poe.Models.Entities;

import Poe.Models.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Base Class for all "Living" GameObjects
 */
public class Entity extends GameObject {

    public boolean canMoveUp = true;
    public boolean canMoveDown = true;
    public boolean canMoveLeft = true;
    public boolean canMoveRight = true;

    public List<GameObject> objectsCollidedWith = new ArrayList<>();
}
