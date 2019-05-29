package Poe.World.Levels;

import Poe.GameObjects.Entities.Grunt;
import Poe.GameObjects.Structures.Wall;
import Poe.Engine.Utlities.StructureUtils;
import Poe.Engine.Utlities.MathUtils;
import Poe.World.World;

import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * Level 1
 */
public class Level1 implements ILevelBuilder {

    private static final Logger logger = Logger.getLogger(Level1.class.getName());

    private static final String levelName = "Levels 1";
    private static final float maxWidth = 100;
    private static final float maxHeight = 100;
    private static long objectId = 0;

    public Level1() {
    }

    @Override
    public void init() {
        createEnemies();
        createWalls();
    }

    @Override
    public void createWalls() {
        World.walls = new ConcurrentHashMap<>();
        //build border walls
        World.walls.put(generateId(), new Wall(0, maxHeight/2, maxWidth, 1));//top
        World.walls.put(generateId(), new Wall(0, maxHeight/2*(-1), maxWidth, 1));//bottom
        World.walls.put(generateId(), new Wall(maxWidth/2, 0, 1, maxHeight));//right
        World.walls.put(generateId(), new Wall(maxWidth/2*(-1), 0, 1, maxHeight));//left
        int count = 0; //Identify how many structures are being generated
        for(float i = maxWidth/2*(-1); i < maxWidth/2; i++) {
            for (float j = maxHeight/2*(-1); j < maxHeight/2; j++) {
                if(MathUtils.getRandomNumberFromRange(0, 1000) < 1) {
                    StructureUtils.tryToBuildBuilding(i, j);
                    count++;
                }
            }
        }
        logger.info("Total Building Count: " + count);
    }

    @Override
    public void createEnemies() {
        World.enemies = new ConcurrentHashMap<>();
        for(int i = 0; i < 50; i++) {
            Grunt g = new Grunt(generateId(),
                    MathUtils.getRandomNumberFromRange((int)maxWidth/2*(-1), (int)maxWidth/2),
                    MathUtils.getRandomNumberFromRange((int)maxHeight/2*(-1), (int)maxHeight/2));
            World.enemies.put(g.id, g);
        }
    }

    @Override
    public long generateId() {
        return objectId++;
    }

    @Override
    public String getLevel() {
        return levelName;
    }
}
