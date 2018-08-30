package Poe.World;

import Poe.Engine.Renderer;
import Poe.Models.Entities.Player;
import Poe.Models.Item.Weapons.Projectile;
import Poe.Models.Item.Weapons.ThrowingStar;


public class World {

    public static Player player = null;
    public static Projectile[] rangeWeapons = new Projectile[1];

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
    }

    public static void init() {
        player = new Player();
        rangeWeapons[0] = new ThrowingStar();
    }
}
