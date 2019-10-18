package Poe.Engine.Detection;

import Poe.Engine.Utlities.MathUtils;
import Poe.GameObjects.Entities.Entity;
import Poe.GameObjects.Entities.IntelligentEntities.IntelligentEntity;

public class PlayerDetector {
	/**
	 * Notes on Player detection:
	 * Detection Level - Number is calculated based on how far player is from a light source.
	 * Probability of being seen - Detection Level * 1 / distance from entity (as long as `entityNearEntity` is true)
	 */

	/**
	 * @param Entity A
	 * @param Entity B
	 * @param float radius
	 * @return will check if Entity A is within passed radius of Entity B
	 */
	public static boolean entityNearEntity(Entity A, IntelligentEntity B, float radius) {
		return MathUtils.getDistanceBetweenObjects(A, B) < radius;
	}


}
