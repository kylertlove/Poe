package Poe.Models.Item;

import Poe.Models.GameObject;

/**
 * Base Item Class
 */
public class Item extends GameObject {

    private boolean canPickUp = false;
    protected float damageAmount = 1;
}
