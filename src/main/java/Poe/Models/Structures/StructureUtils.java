package Poe.Models.Structures;

import Poe.Engine.CollisionDetector;
import Poe.Models.GameObject;
import Poe.Utlities.GameUtils;
import Poe.Utlities.PoeLogger;
import Poe.World.World;

import java.util.Arrays;

public class StructureUtils {

    /**
     * Verify the structure is able to be built at the coordinates
     * @return boolean
     */
    public static void tryToBuildStructure(float x, float y) {
        Building building = new Building(x, y, 10, 10);
        PoeLogger.logger.info("Generate a building. X:" + x + ", y:" + y);
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
        PoeLogger.logger.info("Wall Count: " + World.walls.size());
    }
}
