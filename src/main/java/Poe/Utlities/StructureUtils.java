package Poe.Utlities;

import Poe.Engine.CollisionDetector;
import Poe.Models.GameObject;
import Poe.Models.Structures.Building;
import Poe.Models.Structures.Wall;
import Poe.Utlities.GameUtils;
import Poe.Utlities.PoeLogger;
import Poe.World.World;

import java.util.Arrays;

public class StructureUtils {

    /**
     * Verify the structure is able to be built at the coordinates
     * @return boolean
     */
    public static void tryToBuildBuilding(float x, float y) {
        Building building = new Building(x, y, 10, 10);
        PoeLogger.logger.info("Generating Building @ X:" + x + ", Y:" + y);
        if(World.walls.size() == 0) {
            Wall[] wallArray = building.buildStructure();
            for (int wallIndex = 0; wallIndex < wallArray.length; wallIndex++) {
                World.walls.put(GameUtils.getId(), wallArray[wallIndex]);
            }
        } else {
            if(!CollisionDetector.isCollidedWithList(building, World.walls)) {
                Wall[] wallArray = building.buildStructure();
                for (int wallIndex = 0; wallIndex < wallArray.length; wallIndex++) {
                    World.walls.put(GameUtils.getId(), wallArray[wallIndex]);
                }
            }
        }
    }
}
