package Poe.GameObjects.Entities.IntelligentEntities;

public interface DetectableEntity {

	/**
	 * Distance an Entity can detect a player
	 * @return int
	 */
	default int getViewDistance() {
		return 4;
	}

}
