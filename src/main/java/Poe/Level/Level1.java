package Poe.Level;

import Poe.Models.Entities.Entity;
import Poe.Models.Entities.Grunt;
import Poe.Models.Structures.Structure;
import Poe.Models.Structures.Wall;
import Poe.Utlities.GameUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Level1 implements ILevelBuilder {

    private static final String levelName = "Level 1";

    public Level1() {
    }

    @Override
    public Map<Integer, Structure> createWalls() {
        Map<Integer, Structure> walls = new ConcurrentHashMap<>();
        walls.put(GameUtils.getId(), new Wall(0, 10, 20, 2));
        walls.put(GameUtils.getId(), new Wall(0, -10, 20, 2));
        walls.put(GameUtils.getId(), new Wall(-10, 0, 2, 20));
        walls.put(GameUtils.getId(), new Wall(20, 0, 2, 20));
        walls.put(GameUtils.getId(), new Wall(-4, 3, 1, 3));
        return walls;
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
