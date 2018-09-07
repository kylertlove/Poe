package Poe.World;

import Poe.Drawable.Drawable;
import Poe.Engine.CollisionDetector;
import Poe.Engine.Renderer;
import Poe.Models.Entities.Player;
import Poe.Models.GameObject;
import Poe.Models.Item.Weapons.Projectile;
import Poe.Models.Item.Weapons.ThrowingStar;
import Poe.Models.Structures.Structure;
import Poe.Models.Structures.Wall;
import Poe.Utlities.GameUtils;

import java.util.ArrayList;
import java.util.List;


public class World {

    public static Player player = null;
    public static Projectile[] rangeWeapons = new Projectile[1];
    public static Structure[] walls = new Structure[5];
    private static List<GameObject> collidedObjects = new ArrayList<>();

    public static void update() {
        player.update();
        Renderer.updateCamera(player.X, player.Y);
        for(Projectile rangeWeapon : rangeWeapons) {
            if(rangeWeapon.isActive) {
                rangeWeapon.update();
            }
        }
        for(Structure structure : walls) {
            if(CollisionDetector.isCollided(player, structure)) {
                collidedObjects.add(structure);
            }
        }
        CollisionDetector.updateMoveable(player, collidedObjects);
        collidedObjects = new ArrayList<>();
    }

    public static void render() {
        player.render();
        for(Projectile rangeWeapon : rangeWeapons) {
            if(rangeWeapon.isActive) {
                rangeWeapon.render();
            }
        }
        for(Structure structure : walls) {
            structure.render();
        }
    }

    //Initialize the gameboard
    public static void init() {
        player = new Player();
        rangeWeapons[0] = new ThrowingStar();

        //Test building walls
        walls[0] = new Wall(0, 10, 20, 2);
        walls[1] = new Wall(0, -10, 20, 2);
        walls[2] = new Wall(-10, 0, 2, 20);
        walls[3] = new Wall(20, 0, 2, 20);
        walls[4] = new Wall(-4, 3, 1, 3);
    }
}
