package Poe.GameObjects.Entities.Items;

import Poe.GameObjects.Entities.Entity;

/**
 * Base Items Class
 */
public class Item extends Entity {

    public boolean canPickUp = false;

    public Item(long id, float x, float y, float w, float h) {
        super(id, x, y, w, h);
    }
}
