package Poe.World.Levels;

public interface LevelBuilder {

    void init();

    void createWalls();

    void createEnemies();

    long generateId();

    String getLevel();

}
