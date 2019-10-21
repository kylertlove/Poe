package Poe.World.Levels;

public interface LevelBuilder {

    void init();

    void createWalls();

    void createEnemies();

    void createLightSources();

    long generateId();

    String getLevel();

    int getNumberOfGrunts();
    int getNumberOfCaptains();

}
