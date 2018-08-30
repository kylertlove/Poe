package Poe.World;

import Poe.Drawable.Drawable;
import Poe.Engine.Renderer;
import Poe.Models.Entities.Player;
import Poe.Models.Item.Weapons.Projectile;
import Poe.Models.Item.Weapons.ThrowingStar;
import Poe.Models.Structures.Structure;
import Poe.Models.Structures.Wall;


public class World {

    public static Player player = null;
    public static Projectile[] rangeWeapons = new Projectile[1];
    public static Structure[] walls = new Structure[5];

    public static void update() {
        player.update();
        Renderer.updateCamera(player.X, player.Y);
        for(int i = 0; i < rangeWeapons.length; i++) {
            if(rangeWeapons[i].isActive) {
                rangeWeapons[i].update();
            }
        }
    }

    public static void render() {
        player.render();
        for(int i = 0; i < rangeWeapons.length; i++) {
            if(rangeWeapons[i].isActive) {
                rangeWeapons[i].render();
            }
        }
        for(int i = 0; i < walls.length; i++) {
            walls[i].render();
        }
    }

    public static void init() {
        player = new Player();
        rangeWeapons[0] = new ThrowingStar();

        //Test building walls
        walls[0] = new Wall(3, 10, 2, 80);
        walls[1] = new Wall(12, 2, 20, 2);
        walls[2] = new Wall(79, 42, 6, 43);
        walls[3] = new Wall(33, 10, 2, 16);
        walls[4] = new Wall(90, 90, 2, 80);
    }
}
