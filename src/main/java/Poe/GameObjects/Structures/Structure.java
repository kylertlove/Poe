package Poe.GameObjects.Structures;

import Poe.GameObjects.GameObject;

/**
 * Base Class for all "Non-Living" GameObjects that are present in the world
 */
public class Structure extends GameObject {

	public Structure(long id, float x, float y, float w, float h) {
		super(id, x, y, w, h);
	}
}
