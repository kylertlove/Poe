package Poe.Level;

import Poe.Models.Entities.Grunt;
import Poe.Models.Structures.Wall;
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

        //build border walls
        World.walls.put(GameUtils.getId(), new Wall(0, maxHeight/2, maxWidth, 1));//top
        World.walls.put(GameUtils.getId(), new Wall(0, maxHeight/2*(-1), maxWidth, 1));//bottom
        World.walls.put(GameUtils.getId(), new Wall(maxWidth/2, 0, 1, maxHeight));//right
        World.walls.put(GameUtils.getId(), new Wall(maxWidth/2*(-1), 0, 1, maxHeight));//left


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
        for(int i = 0; i < 50; i++) {
            Grunt g = new Grunt(GameUtils.getRandomNumberFromRange((int)maxWidth/2*(-1), (int)maxWidth/2),
                    GameUtils.getRandomNumberFromRange((int)maxHeight/2*(-1), (int)maxHeight/2),
                    1, 1);
            World.enemies.put(g.id, g);
        }
    }

    @Override
    public String getLevel() {
        return this.levelName;
    }
}
