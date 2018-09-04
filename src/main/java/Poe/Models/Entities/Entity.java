package Poe.Models.Entities;

import Poe.Models.GameObject;

/**
 * Base Class for all "Living" GameObjects
 */
public class Entity extends GameObject {

    public int health = 0;
    public boolean canMoveUp = true;
    public boolean canMoveDown = true;
    public boolean canMoveLeft = true;
    public boolean canMoveRight = true;


}
