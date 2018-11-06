package Poe.World;

import Poe.Engine.CollisionDetector;
import Poe.Engine.Renderer;
import Poe.Level.ILevelBuilder;
import Poe.Level.Level1;
import Poe.Models.Entities.Entity;
import Poe.Models.Entities.Player;
import Poe.Models.Item.Weapons.Projectile;
import Poe.Models.Item.Weapons.ThrowingStar;
import Poe.Models.Structures.Structure;
import Poe.Utlities.DebuggerUtils;
import Poe.Utlities.GameUtils;

import java.util.ArrayList;
import java.util.Map;


public class World {

    public static Player player = null;
    public static Projectile activeRangeWeapon;
    public static Map<Long, Structure> walls;
    public static Map<Long, Entity> enemies;
    public static ILevelBuilder currentLevel;
    public static boolean debug = true;

    /**
     * Game Update Function
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
            if(GameUtils.entityNearEntity(player, entity, entity.viewDistance)) {
                entity.isTrackingEntity = true;
                entity.trackingTarget(player);
            } else {
                entity.isTrackingEntity = false;
            }
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
            //Make sure Entities cant run through walls
            enemies.entrySet()
                    .stream()
                    .filter(set -> set.getValue().isTrackingEntity)
                    .forEach(trackingEntity -> {
                        if(CollisionDetector.isCollided(trackingEntity.getValue(), structure)) {
                            CollisionDetector.updateMoveableSingle(trackingEntity.getValue(), structure);
                        }
                    });
        });
        CollisionDetector.updateMoveable(player, player.objectsCollidedWith);
        player.objectsCollidedWith = new ArrayList<>();

    }

    /**
     * Game Render Function
     */
    public static void render() {
        player.render();
        if(activeRangeWeapon.isActive) {
            activeRangeWeapon.render();
        }
        enemies.entrySet()
                .stream()
                .filter(entity -> GameUtils.isInBounds(entity.getValue()))
                .forEach(inBoundsEnemy -> inBoundsEnemy.getValue().render());

        walls.forEach((index, structure) -> {
            /**
             *TODO:
             * IsInBounds breaks since structures can be larger than screen size.
             * Need different Method to check for 'Any' part of GameObject inBounds
             */
            structure.render();
        });
        if(debug) {
            DebuggerUtils.addDebugMessage("Player: X:" + Math.round(World.player.X) + ", Y:" + Math.round(World.player.Y));
            DebuggerUtils.addDebugMessage(World.currentLevel.getLevel());
            DebuggerUtils.addDebugMessage(Renderer.getWindowHeight() + ", units tall: " + Renderer.getUnitsTall());
            DebuggerUtils.writeToScreen();//debugger
        }
    }

    //Initialize the gameboard
    public static void init() {
        currentLevel = new Level1();
        currentLevel.init();
        player = new Player();
        activeRangeWeapon = new ThrowingStar(Player.DEFAULT_DAMAGE);
    }
}
