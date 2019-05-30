package Poe.GameObjects.Entities;

import Poe.Drawable.Animation;
import Poe.Engine.GameLoop;
import Poe.Engine.Input.KeyInput;
import Poe.Engine.Input.MouseInput;
import Poe.GameObjects.Item.Weapons.Melee.Melee;
import Poe.GameObjects.Item.Weapons.Melee.ShortSword;
import Poe.GameObjects.Item.Weapons.Projectile.Bow;
import Poe.GameObjects.Item.Weapons.Projectile.Projectile;
import Poe.GameObjects.Item.Weapons.Projectile.ThrowingStar;
import Poe.ResourceManager.ImageResource;
import Poe.Engine.Utlities.GameUtils;
import Poe.Engine.Utlities.MathUtils;
import Poe.World.World;
import com.jogamp.newt.event.KeyEvent;

import java.util.logging.Logger;

public class Player extends Entity {

    private static final Logger logger = Logger.getLogger(Player.class.getName());

    //left/right click boolean.  activated/Deactivated in MouseInput class
    public boolean rightClick = false;
    public boolean leftClick = false;

    public Projectile activeRangeWeapon;
    public Projectile[] projectiles = new Projectile[15];
    public Melee activeMeleeWeapon;
    private int rangeWeaponIndex = 0;
    private Projectile[] rangeWeapons = new Projectile[2];

    public Player() {
        this.width = 1.5f;
        this.height = 1.5f;
        this.velocity = 6;
        this.health = 50;
        this.id = World.currentLevel.generateId();
        this.buildPlayerAnimation();
        rangeWeapons[0] = new ThrowingStar();
        rangeWeapons[1] = new Bow();
        activeRangeWeapon = rangeWeapons[0];
        this.activeMeleeWeapon = new ShortSword();
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

        if(rightClick && this.canRangeAttack) {
            this.rangeAttack();
        }
        if(leftClick && !this.isMeleeAttacking) {
            this.meleeAttack();
        }
        canMoveLeft = true;
        canMoveUp = true;
        canMoveDown = true;
        canMoveRight = true;
    }

    private void rangeAttack() {
        this.canRangeAttack = false;
        for (int i = 0; i < projectiles.length; i++) {
            if(projectiles[i] == null || !projectiles[i].isActive) {
                projectiles[i] = getNewRangeWeaponProjectile();
                projectiles[i].setInstanceLocation(this.X, this.Y);
                projectiles[i].rotation = rotation;
                break;
            }
        }
        GameUtils.setTimeout(() -> canRangeAttack = true, rangeWeapons[rangeWeaponIndex].getActionCooldown());
    }

    private void meleeAttack() {
        this.isMeleeAttacking = true;
        activeMeleeWeapon.isActive = true;
        GameUtils.setTimeout(() -> this.isMeleeAttacking = false, activeMeleeWeapon.getActionCooldown());
    }

    private Projectile getNewRangeWeaponProjectile() {
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

    private void buildPlayerAnimation() {
        animations = new Animation[1];
        Animation walking = new Animation();
        walking.frames = new ImageResource[4];
        walking.fps = 6;
        String uri1 =  "/Images/Poe_test_1.png";
        String uri2 =  "/Images/Poe_test_2.png";
        String uri3 =  "/Images/Poe_test_3.png";
        String uri4 =  "/Images/Poe_test_4.png";
        walking.frames[0] = new ImageResource(this.getClass().getResourceAsStream(uri1));
        walking.frames[1] = new ImageResource(this.getClass().getResourceAsStream(uri2));
        walking.frames[2] = new ImageResource(this.getClass().getResourceAsStream(uri3));
        walking.frames[3] = new ImageResource(this.getClass().getResourceAsStream(uri4));
        animations[0] = walking;
    }

}

