package Poe.Models.Entities;

import Poe.Drawable.Animation;
import Poe.Engine.GameLoop;
import Poe.Engine.Input.KeyInput;
import Poe.Engine.Input.MouseInput;
import Poe.Models.Item.Weapons.Projectile.Bow;
import Poe.Models.Item.Weapons.Projectile.Projectile;
import Poe.Models.Item.Weapons.Projectile.ThrowingStar;
import Poe.ResourceManager.ImageResource;
import Poe.Engine.Utlities.GameUtils;
import Poe.Engine.Utlities.MathUtils;
import Poe.World.World;
import com.jogamp.newt.event.KeyEvent;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Player extends Entity {

    private static final Logger logger = Logger.getLogger(Player.class.getName());

    public boolean rangeClick = false;
    public boolean canRangeAttack = true;

    public boolean currentlyMeleeAttacking = false;
    public boolean meleeClick = false;

    public Projectile activeRangeWeapon;
    private Projectile[] rangeWeapons = new Projectile[2];
    private int rangeWeaponIndex = 0;

    public Player() {
        this.width = 1.5f;
        this.height = 1.5f;
        this.velocity = 6;
        this.health = 50;
        this.id = World.currentLevel.generateId();
        animations = new ArrayList<>();
        Animation walking = new Animation();
        walking.frames = new ImageResource[1];
        String uri =  "/Images/Poe.png";
        walking.frames[0] = new ImageResource(this.getClass().getResourceAsStream(uri));
        animations.add(walking);
        rangeWeapons[0] = new ThrowingStar();
        rangeWeapons[1] = new Bow();
        activeRangeWeapon = rangeWeapons[0];
    }

    @Override
    public void update() {

        float xInput = 0;
        float yInput = 0;

        if(KeyInput.getKey(KeyEvent.VK_A) && canMoveLeft) {
            xInput -= velocity;
        }
        if(KeyInput.getKey(KeyEvent.VK_D) && canMoveRight) {
            xInput += velocity;
        }
        if(KeyInput.getKey(KeyEvent.VK_W) && canMoveUp) {
            yInput += velocity;
        }
        if(KeyInput.getKey(KeyEvent.VK_S) && canMoveDown) {
            yInput -= velocity;
        }

        X += xInput * GameLoop.getDelta();
        Y += yInput * GameLoop.getDelta();
        rotation = MathUtils.getAngle(MouseInput.getWorldX(), MouseInput.getWorldY(), X, -Y);

        if(rangeClick && this.canRangeAttack) {
            this.rangeAttack();
        }
        canMoveLeft = true;
        canMoveUp = true;
        canMoveDown = true;
        canMoveRight = true;
    }

    public void rangeAttack() {
        this.canRangeAttack = false;
        for (int i = 0; i < World.projectiles.length; i++) {
            if(World.projectiles[i] == null || !World.projectiles[i].isActive) {
                World.projectiles[i] = getRangeWeapon();
                World.projectiles[i].setInstanceLocation(this.X, this.Y);
                World.projectiles[i].rotation = rotation;
                break;
            }
        }
        GameUtils.setTimeout(() -> canRangeAttack = true, rangeWeapons[rangeWeaponIndex].projectileCooldown);
    }

    public Projectile getRangeWeapon() {
        switch (rangeWeaponIndex) {
            case 0:
                return new ThrowingStar();
            case 1:
                return new Bow();
            default:
                logger.info("No active range weapon available");
                return null;
        }
    }

    public void scrollRangeWeapons() {
        rangeWeaponIndex++;
        if(rangeWeaponIndex > rangeWeapons.length - 1) {
            rangeWeaponIndex = 0;
        }
        this.activeRangeWeapon = rangeWeapons[rangeWeaponIndex];
    }

    public void setRangeWeapon(int inputRangeWeaponIndex) {
        try{
            rangeWeaponIndex = inputRangeWeaponIndex;
            this.activeRangeWeapon = rangeWeapons[inputRangeWeaponIndex];
        } catch(Exception ex) {
            rangeWeaponIndex = 0;
            this.activeRangeWeapon = rangeWeapons[0];
            logger.warning("Range weapon out of bounds index");
        }
    }

    @Override
    public void recieveHit(float hitAmount) {
        this.health -= hitAmount;
        if(this.health <= 0) {
            logger.info("GAME OVER");
        }
    }

}

