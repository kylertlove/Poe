package Poe.Engine.Detection;

import Poe.Engine.Utlities.MathUtils;
import Poe.GameObjects.Entities.Entity;
import Poe.GameObjects.Entities.IntelligentEntities.IntelligentEntity;

public class PlayerDetector {


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
