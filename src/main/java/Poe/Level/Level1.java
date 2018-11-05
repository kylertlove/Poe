package Poe.Level;

import Poe.Models.Entities.Entity;
import Poe.Models.Entities.Grunt;
import Poe.Models.Structures.Building;
import Poe.Models.Structures.Structure;
import Poe.Models.Structures.StructureUtils;
import Poe.Models.Structures.Wall;
import Poe.Utlities.GameUtils;
import Poe.Utlities.PoeLogger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Level1 implements ILevelBuilder {

    private static final String levelName = "Level 1";
    private static final float maxWidth = 100;
    private static final float maxHeight = 100;

    public Level1() {
    }

    @Override
    public void createWalls() {
        PoeLogger.logger.info("Generating Map");
        for(float i = maxWidth/2*(-1); i < maxWidth/2; i++) {
            for (float j = maxHeight/2*(-1); j < maxHeight/2; j++) {
                if(GameUtils.random.nextInt(1000) < 1) {
                    PoeLogger.logger.info("i: " + i + ", j: " + j);
                    StructureUtils.tryToBuildStructure(i, j);
                }
            }
        }
    }

    @Override
    public Map<Integer, Entity> createEnemies() {
        Map<Integer, Entity> enemies = new ConcurrentHashMap<>();
        for(int i = 0; i < 10; i++) {
            Grunt g = new Grunt(GameUtils.random.nextInt(30), GameUtils.random.nextInt(30), 1, 1);
            enemies.put(g.id, g);
        }
        return enemies;
    }

    @Override
    public String getLevel() {
        return this.levelName;
    }
}
