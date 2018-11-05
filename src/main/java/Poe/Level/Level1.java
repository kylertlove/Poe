package Poe.Level;

import Poe.Models.Entities.Grunt;
import Poe.Utlities.StructureUtils;
import Poe.Utlities.GameUtils;
import Poe.Utlities.PoeLogger;
import Poe.World.World;

public class Level1 implements ILevelBuilder {

    private static final String levelName = "Level 1";
    private static final float maxWidth = 100;
    private static final float maxHeight = 100;

    public Level1() {
    }

    @Override
    public void createWalls() {
        int count = 0;
        for(float i = maxWidth/2*(-1); i < maxWidth/2; i++) {
            for (float j = maxHeight/2*(-1); j < maxHeight/2; j++) {
                if(GameUtils.random.nextInt(1000) < 1) {
                    StructureUtils.tryToBuildBuilding(i, j);
                    count++;
                }
            }
        }
        PoeLogger.logger.info("Total Building Count: " + count);
    }

    @Override
    public void createEnemies() {
        for(int i = 0; i < 10; i++) {
            Grunt g = new Grunt(GameUtils.random.nextInt(30), GameUtils.random.nextInt(30), 1, 1);
            World.enemies.put(g.id, g);
        }
    }

    @Override
    public String getLevel() {
        return this.levelName;
    }
}
