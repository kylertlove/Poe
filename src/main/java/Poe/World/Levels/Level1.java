package Poe.World.Levels;

import Poe.Engine.Detection.LightSource;
import Poe.GameObjects.Entities.IntelligentEntities.Captain;
import Poe.GameObjects.Entities.IntelligentEntities.Grunt;
import Poe.GameObjects.Structures.Wall;
import Poe.Engine.Utlities.StructureUtils;
import Poe.Engine.Utlities.MathUtils;
import Poe.World.World;

import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 * Level 1
 */
public class Level1 implements LevelBuilder {

    private static final Logger logger = Logger.getLogger(Level1.class.getName());

    private static final String levelName = "Level 1";
    private static final float maxWidth = 100;
    private static final float maxHeight = 100;
    private static long objectId = 0;

    public Level1() {
    }

    @Override
    public void init() {
        createEnemies();
        createWalls();
        createLightSources();
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
        IntStream.range(0, getNumberOfGrunts())
                .forEach(grunt -> {
                    Grunt g = new Grunt(generateId(),
                            MathUtils.getRandomNumberFromRange((int)(maxWidth - 10)/2*(-1), (int)(maxWidth - 10)/2),
                            MathUtils.getRandomNumberFromRange((int)(maxHeight - 10)/2*(-1), (int)(maxHeight - 10)/2)
                                        );
                    World.enemies.put(g.id, g);
                });

        IntStream.range(0, getNumberOfCaptains()).forEach(value -> {
            Captain captain = new Captain(
                    generateId(),
                    MathUtils.getRandomNumberFromRange((int)(maxWidth - 10)/2*(-1), (int)(maxWidth - 10)/2),
                    MathUtils.getRandomNumberFromRange((int)(maxHeight - 10)/2*(-1), (int)(maxHeight - 10)/2));
            World.enemies.put(captain.id, captain);
        });
    }

    public void createLightSources() {
        World.lightSource = new LightSource(0, 0, 2.0f, 0.9f);
    }

    @Override
    public long generateId() {
        return objectId++;
    }

    @Override
    public String getLevel() {
        return "Levels 1";
    }

    @Override
    public int getNumberOfGrunts() {
        return 50;
    }

    @Override
    public int getNumberOfCaptains() {
        return 15;
    }
}
