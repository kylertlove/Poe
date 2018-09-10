package Poe.World;

import Poe.Drawable.Drawable;
import Poe.Engine.CollisionDetector;
import Poe.Engine.Renderer;
import Poe.Models.Entities.Entity;
import Poe.Models.Entities.Grunt;
import Poe.Models.Entities.Player;
import Poe.Models.GameObject;
import Poe.Models.Item.Weapons.Projectile;
import Poe.Models.Item.Weapons.ThrowingStar;
import Poe.Models.Structures.Structure;
import Poe.Models.Structures.Wall;
import Poe.Utlities.GameUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;


public class World {

    public static Player player = null;
    public static Projectile activeRangeWeapon;
    public static Map<Integer, Structure> walls = new ConcurrentHashMap<>();
    public static Map<Integer, Entity> enemies = new ConcurrentHashMap<>();
    public static Random random = new Random();

    /**
     * Update Function
     */
    public static void update() {
        //update player and camera position
        player.update();
        Renderer.updateCamera(player.X, player.Y);
        //update range weapons
        if(activeRangeWeapon.isActive) {
            activeRangeWeapon.update();
        }
        enemies.forEach((index, entity) -> {
            entity.update();
            if(CollisionDetector.isCollided(player, entity)) {
                player.objectsCollidedWith.add(entity);
            }
            if(activeRangeWeapon.isActive) {
                if(CollisionDetector.isCollided(activeRangeWeapon, entity)) {
                    activeRangeWeapon.destroy();
                    entity.recieveHit(activeRangeWeapon.damageAmount);
                }
            }
        });
        walls.forEach((index, structure) -> {
            if(CollisionDetector.isCollided(player, structure)) {
                player.objectsCollidedWith.add(structure);
            }
            if(activeRangeWeapon.isActive) {
                if(CollisionDetector.isCollided(activeRangeWeapon, structure)) {
                    activeRangeWeapon.destroy();
                }
            }
        });
        CollisionDetector.updateMoveable(player, player.objectsCollidedWith);
        player.objectsCollidedWith = new ArrayList<>();
    }

    /**
     * Render Function
     */
    public static void render() {
        player.render();
        if(activeRangeWeapon.isActive) {
            activeRangeWeapon.render();
        }
        enemies.forEach((index, entity) -> {
            entity.render();
        });
        walls.forEach((index, structure) -> {
            structure.render();
        });
    }

    //Initialize the gameboard
    public static void init() {
        player = new Player();
        activeRangeWeapon = new ThrowingStar();
        //Test building walls
        walls.put(GameUtils.getId(), new Wall(0, 10, 20, 2));
        walls.put(GameUtils.getId(), new Wall(0, -10, 20, 2));
        walls.put(GameUtils.getId(), new Wall(-10, 0, 2, 20));
        walls.put(GameUtils.getId(), new Wall(20, 0, 2, 20));
        walls.put(GameUtils.getId(), new Wall(-4, 3, 1, 3));
        for(int i = 0; i < 10; i++) {
            Grunt g = new Grunt(random.nextInt(30), random.nextInt(30), 1, 1);
            enemies.put(g.id, g);
        }
    }
}
